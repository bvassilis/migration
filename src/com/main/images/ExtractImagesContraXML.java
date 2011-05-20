package com.main.images;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.escenic.xmlns.x2009.ximport.EscenicDocument;
import com.escenic.xmlns.x2009.ximport.AuthorDocument.Author;
import com.escenic.xmlns.x2009.ximport.ContentDocument.Content;
import com.escenic.xmlns.x2009.ximport.ContentDocument.Content.State;
import com.escenic.xmlns.x2009.ximport.CreatorDocument.Creator;
import com.escenic.xmlns.x2009.ximport.EscenicDocument.Escenic.Version;
import com.escenic.xmlns.x2009.ximport.FieldDocument.Field;
import com.escenic.xmlns.x2009.ximport.PriorityDocument.Priority;
import com.escenic.xmlns.x2009.ximport.SectionRefDocument.SectionRef;
import com.news.Article;
//import com.news.Image;

public class ExtractImagesContraXML {
	
	private static EntityManager em;
	private static Query q;
	private static String fileName;

	public static void main(String[] args) throws IOException, ParseException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DownloadContraArticlesJPA");
		em = emf.createEntityManager();
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int i = 0;
		int maxResults = 100;
//		int imageFlag = photostoryScript();
		int imageFlag = videoThumbs();
//		int imageFlag = imagesScript();
		List<Object[]> results = q.setFirstResult(i*maxResults)
		.setMaxResults(maxResults).getResultList();

		while (!results.isEmpty()) {
			EscenicDocument escenicDocument = EscenicDocument.Factory.newInstance();
			initializeEscenic(escenicDocument);
			for (Object[] phtObj : results) {
				String photo = ((String) phtObj[0]).trim();
				Date datePhoto = new Date(); 
				if(phtObj[1] instanceof Integer){
					int ddays = (Integer) phtObj[1];
					long res = (long) (new Date().getTime() - (((4160-ddays)*0.001)*365*24*60*60*1000));
					datePhoto = new Date(res);
				} else datePhoto = (Date) phtObj[1];
				
				String fullPath = "/home/vassilis/Pictures/contra/"+photo;
				if(imageFlag == 2){
					fullPath = "/home/vassilis/Pictures/contravideos/"+photo;
				}

				//check if file  
				if(!new File(fullPath).exists())
					continue;
				
				Content content = escenicDocument.getEscenic().addNewContent();
				if(imageFlag == 2){
					content.addNewSource().setStringValue("ContraImagesVideos");
				}else{
					content.addNewSource().setStringValue("ContraImages");	
				}
				content.addNewSourceid().setStringValue(photo);
				content.addNewType().setStringValue("picture");
				content.setState(State.PUBLISHED);
				content.addNewPublishdate().setStringValue(dtf.format(datePhoto));
				content.addNewCreationdate().setStringValue(dtf.format(datePhoto));

				SectionRef sectionRef = content.addNewSectionRef();
				sectionRef.addNewUniqueName().setStringValue("ece_incoming");
				sectionRef.setHomeSection(true);

				Priority priority = content.addNewPriority();
				priority.setValue(0);

				Field binaryField = content.addNewField();
				binaryField.addNewName().setStringValue("binary");
				binaryField.addNewTitle().setStringValue(photo.replaceAll("[^\\.a-zA-Z0-9_-]", ""));
				if(imageFlag == 2){
					binaryField.newCursor().setTextValue("/opt/temp/contra/videos/"+photo);
				}else{
					binaryField.newCursor().setTextValue("/opt/temp/contra/imgs/"+photo);
				}
			}
			
			String outFileName = "";
			if(imageFlag == 2){
				outFileName = "video";
			}else if(imageFlag == 1){
				outFileName = "photostory";
			}else if(imageFlag == 0){
				outFileName = "news";
			}

			outFileName = "import-images/"+outFileName+(++i)+".xml";
			File f = new File(outFileName);
			escenicDocument.save(f);
			
			results = q.setFirstResult(i*maxResults)
			.setMaxResults(maxResults).getResultList();
		}
	}
	
	private static int videoThumbs() {
		q = em.createQuery(" SELECT distinct a.videoThumb, a.videoDate FROM Video a WHERE a.videoThumb is not null AND a.subSection.section.sectionID=1 ORDER BY a.videoID DESC");
		return 2;
	}

	private static int photostoryScript() {
		q = em.createQuery(" SELECT distinct p.photo, p.photoStory.photoStoryID  FROM Photo p WHERE p.photoStory.photoStoryID >=151 AND p.photoStory.subSection.section.sectionID=1 ORDER BY p.photoStory.photoStoryID DESC");
		return 1;
	}
	
	private static int imagesScript(){
		Calendar cal = Calendar.getInstance();
		cal.set(2007, 0, 1, 0, 0, 0);
		q = em.createQuery(" SELECT distinct a.articlePhoto, a.articleDate FROM Article a WHERE a.articlePhoto is not null AND a.sport.sportID <> 0 AND a.articleDate >= :articleDate ORDER BY a.articleID DESC")
		.setParameter("articleDate", cal.getTime() );
		return 0;
	}

	private static void initializeEscenic(EscenicDocument escenicDocument) {
		escenicDocument.addNewEscenic();
		escenicDocument.getEscenic().setVersion(Version.X_2_0);
	}
	
}
