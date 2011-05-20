package com.news.photostories;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.escenic.xmlns.x2009.ximport.EscenicDocument;
import com.escenic.xmlns.x2009.ximport.AuthorDocument.Author;
import com.escenic.xmlns.x2009.ximport.ContentDocument.Content;
import com.escenic.xmlns.x2009.ximport.ContentDocument.Content.Relation;
import com.escenic.xmlns.x2009.ximport.ContentDocument.Content.State;
import com.escenic.xmlns.x2009.ximport.CreatorDocument.Creator;
import com.escenic.xmlns.x2009.ximport.EscenicDocument.Escenic.Version;
import com.escenic.xmlns.x2009.ximport.FieldDocument.Field;
import com.escenic.xmlns.x2009.ximport.PriorityDocument.Priority;
import com.escenic.xmlns.x2009.ximport.SectionRefDocument.SectionRef;
import com.news.Article;
import com.news.Photo;
import com.news.PhotoStory;
//import com.news.Category;
//import com.news.Image;

public class ExtractPhotostoriesContraXML {
	
	private static String queryString =" SELECT distinct a FROM PhotoStory a WHERE a.photoStoryID >=151 AND a.subSection.section.sectionID=1 ORDER BY a.photoStoryID DESC";
	public static List<PhotoStory> photostories = new ArrayList<PhotoStory>();
	
	public static void main(String[] args) throws Exception {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DownloadContraArticlesJPA");
		EntityManager em = emf.createEntityManager();
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date defaultDate = new Date();
		
		int i = 0;
		int maxResults = 100;
		
		Query q = em.createQuery(queryString)
		.setFirstResult(i*maxResults)
		.setMaxResults(maxResults);
		List<PhotoStory> results = q.getResultList();

//		while (!results.isEmpty()) {
			EscenicDocument escenicDocument = EscenicDocument.Factory.newInstance();
			initializeEscenic(escenicDocument);
			for (PhotoStory photostory : results) {
				
				Content content = escenicDocument.getEscenic().addNewContent();
				content.addNewSource().setStringValue("ContraPhotostory");
				content.addNewSourceid().setStringValue(Integer.toString(photostory.getPhotoStoryID()));
				content.addNewType().setStringValue("photostory");
				content.setState(State.PUBLISHED);
				
				//published date check from relation
				List<Article> articles = em.createQuery("SELECT a FROM Article a WHERE LOWER(a.links) like :param ORDER BY a.articleDate")
				.setParameter("param", "%ph"+photostory.getPhotoStoryID() + "%")
				.getResultList();
				
				for(Article story : articles){
					List<String>ids = Arrays.asList(story.getLinks().trim().toLowerCase().split(","));
					if(ids.contains("ph"+photostory.getPhotoStoryID())){
						defaultDate = story.getArticleDate();
						break;
					}
				}
				
				content.addNewPublishdate().setStringValue(dtf.format(defaultDate));
				content.addNewCreationdate().setStringValue(dtf.format(defaultDate));

				
				SectionRef sectionRef = content.addNewSectionRef();
				sectionRef.addNewUniqueName().setStringValue("photostories");
				sectionRef.setHomeSection(true);

				for (Photo photo : photostory.getPhotos()) {
					// picture relation
					Relation relation = content.addNewRelation();
					relation.addNewType().setStringValue("PICTUREREL");
					relation.addNewSource().setStringValue("ContraImages");
					relation.addNewSourceid().setStringValue(photo.getPhoto().trim());

					Field titlePictureField = relation.addNewField();
					titlePictureField.addNewName().setStringValue("title");
					titlePictureField.newCursor().setTextValue(photo.getPhotoDesc());

					Field captionTitlePictureField = relation.addNewField();
					captionTitlePictureField.addNewName().setStringValue("captiontitle");
					Field captionPictureField = relation.addNewField();
					captionPictureField.addNewName().setStringValue("caption");
					captionPictureField.newCursor().setTextValue(photo.getPhotoDesc());
				}
				Priority priority = content.addNewPriority();
				priority.setValue(0);

				Field titleField = content.addNewField();
				titleField.addNewName().setStringValue("title");
				titleField.newCursor().setTextValue(photostory.getPhotoStoryTitle());

			}
			
			String counterString="";
			++i;
			if(i < 10){
				counterString = "000"; 
			}else if (i < 100){
				counterString = "00";
			}else if (i < 1000){
				counterString = "0";
			}else if (i < 10000){
				counterString = "";
			}
			counterString = counterString+i;

			String outFileName = "import-photostories/photostories"+(counterString)+".xml";
			File f = new File(outFileName);
			escenicDocument.save(f);
			
//			q = em.createQuery(queryString)
//			.setFirstResult(i*maxResults)
//			.setMaxResults(maxResults);
//			results = q.getResultList();
//		}
	}

	private static void initializeEscenic(EscenicDocument escenicDocument) {
		escenicDocument.addNewEscenic();
		escenicDocument.getEscenic().setVersion(Version.X_2_0);
	}
	
}
