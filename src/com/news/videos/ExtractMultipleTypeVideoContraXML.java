package com.news.videos;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

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
//import com.news.Category;
//import com.news.Image;
import com.news.Video;

public class ExtractMultipleTypeVideoContraXML {
	
	private static String queryString="SELECT a FROM Video a WHERE a.videoID in (SELECT distinct b.videoID FROM Video b WHERE b.videoThumb is not null AND b.subSection.section.sectionID=1 ) ORDER BY a.videoID DESC";
	public static void main(String[] args) throws Exception {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DownloadContraArticlesJPA");
		EntityManager em = emf.createEntityManager();
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		int i = 0;
		int maxResults = 100;
		List<Video>videos = new ArrayList<Video>();
		
		Query q = em.createQuery(queryString)
		.setFirstResult(i*maxResults)
		.setMaxResults(maxResults);
		videos = q.getResultList();

//		while (!videos.isEmpty()) {
			EscenicDocument escenicDocument = EscenicDocument.Factory.newInstance();
			initializeEscenic(escenicDocument);
			for (Video video : videos) {
				
				Content content = escenicDocument.getEscenic().addNewContent();
				content.addNewSource().setStringValue("ContraVideos");
				content.addNewSourceid().setStringValue(Integer.toString(video.getVideoID()));
				content.addNewType().setStringValue("multipleTypeVideo");
				content.setState(State.PUBLISHED);
				content.addNewPublishdate().setStringValue(dtf.format(video.getVideoDate()));
				content.addNewCreationdate().setStringValue(dtf.format(video.getVideoDate()));

				SectionRef sectionRef = content.addNewSectionRef();
				sectionRef.addNewUniqueName().setStringValue("videos");
				sectionRef.setHomeSection(true);
//					// picture relation
					Relation relation = content.addNewRelation();
					relation.addNewType().setStringValue("TEASERREL");
					relation.addNewSource().setStringValue("ContraImagesVideos");
					relation.addNewSourceid().setStringValue(video.getVideoThumb());

					Priority priority = content.addNewPriority();
				priority.setValue(0);

				Field titleField = content.addNewField();
				titleField.addNewName().setStringValue("title");
				titleField.newCursor().setTextValue(video.getVideoName());
				
				Field codeField = content.addNewField();
				codeField.addNewName().setStringValue("embeddedcode");
				codeField.newCursor().setTextValue(video.getVideoCode());
				
				Field leadField = content.addNewField();
				leadField.addNewName().setStringValue("leadtext");
				leadField.newCursor().setTextValue(video.getVideoDesc());
				
				Field videotypeField = content.addNewField();
				videotypeField.addNewName().setStringValue("videotype");
				videotypeField.addNewValue().newCursor().setTextValue("advancedCode");
				
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

			String outFileName = "import-videos/videos"+(counterString)+".xml";
			File f = new File(outFileName);
			escenicDocument.save(f);
			
//			q = em.createQuery(queryString)
//			.setFirstResult(i*maxResults)
//			.setMaxResults(maxResults);
//			videos = q.getResultList();
//		}
	}

	private static void initializeEscenic(EscenicDocument escenicDocument) {
		escenicDocument.addNewEscenic();
		escenicDocument.getEscenic().setVersion(Version.X_2_0);
	}
	
}
