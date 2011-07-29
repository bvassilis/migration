package com.main.images;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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

	public static void main(String[] args) throws Exception {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DownloadContraArticlesJPA");
		em = emf.createEntityManager();
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int i = 0;
		int maxResults = 500;
		Integer maxArticleId = 333050;
		int imageFlag = imagesScript();
		List<Article> results = q.setParameter("articleID", maxArticleId)
		.setMaxResults(maxResults).getResultList();
		List<Integer> tagids = Arrays.asList(20,7,15,22,24,12,13,14,1,2,3,5,11,4,25,19,18,16,6,17);
		while (!results.isEmpty()) {
			EscenicDocument escenicDocument = EscenicDocument.Factory.newInstance();
			initializeEscenic(escenicDocument);
			for (Article article : results) {
				maxArticleId = article.getArticleID();
				String photo = article.getArticlePhoto().trim();
				Date datePhoto = article.getArticleDate();
				
				String fullPath = "/home/vassilis/Pictures/cosmo/"+photo;

				//check if file  
				if(!new File(fullPath).exists())
					continue;
				
				Content content = escenicDocument.getEscenic().addNewContent();
				content.addNewSource().setStringValue("CosmoImages");	
				content.addNewSourceid().setStringValue(photo);
				content.addNewType().setStringValue("picture");
				content.setState(State.PUBLISHED);
				content.addNewPublishdate().setStringValue(dtf.format(datePhoto));
				content.addNewCreationdate().setStringValue(dtf.format(datePhoto));

				SectionRef sectionRef = content.addNewSectionRef();
				if (tagids.contains(article.getSubSectionTagID())){
					sectionRef.addNewSource().setStringValue("CosmoTagSection");
					sectionRef.addNewSourceid().setStringValue(String.valueOf(article.getSubSectionTagID()));
				}
				else if (article.getSubSection().getSubSectionID() == 19) {
					sectionRef.addNewSource().setStringValue("CosmoSection");
					sectionRef.addNewSourceid().setStringValue(String.valueOf(article.getSubSection().getSubSectionID()));
				} else if (article.getSubSection().getSubSectionID() == 8 || article.getSubSection().getSubSectionID() == 7) {
					sectionRef.addNewSource().setStringValue("CosmoSection");
					sectionRef.addNewSourceid().setStringValue(String.valueOf(article.getSubSection().getSubSectionID()) + (article.getPath().contains("Hellas") ? "a" : "b"));
				} else throw new Exception("No section");
				sectionRef.setHomeSection(true);

				Priority priority = content.addNewPriority();
				priority.setValue(0);

				Field binaryField = content.addNewField();
				binaryField.addNewName().setStringValue("binary");
				binaryField.addNewTitle().setStringValue(photo.replaceAll("[^\\.a-zA-Z0-9_-]", ""));
				binaryField.newCursor().setTextValue("/tmp/cosmo/imgs/"+photo);
			}
			
			String outFileName = "news";

			outFileName = "import-images/"+outFileName+(++i)+".xml";
			File f = new File(outFileName);
			escenicDocument.save(f);
			
			results = q.setParameter("articleID", maxArticleId)
			.setMaxResults(maxResults).getResultList();
		}
	}
	
	
	private static int imagesScript(){
		Calendar cal = Calendar.getInstance();
		cal.set(2007, 0, 1, 0, 0, 0);
		q = em.createQuery(" SELECT a FROM Article a WHERE a.articlePhoto is not null AND a.articleID > :articleID AND (a.subSection.subSectionID in (19,7,8) OR a.subSectionTagID in (20,7,15,22,24,12,13,14,1,2,3,5,11,4,25,19,18,16,6,17))  AND a.articleDate >= :articleDate ORDER BY a.articleID ASC")
		.setParameter("articleDate", cal.getTime() );
		return 0;
	}

	private static void initializeEscenic(EscenicDocument escenicDocument) {
		escenicDocument.addNewEscenic();
		escenicDocument.getEscenic().setVersion(Version.X_2_0);
	}
	
}
