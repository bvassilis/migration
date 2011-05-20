package com.main.stories;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlOptions;

import com.escenic.xmlns.x2009.ximport.ContentDocument.Content;
import com.escenic.xmlns.x2009.ximport.ContentDocument.Content.Relation;
import com.escenic.xmlns.x2009.ximport.ContentDocument.Content.State;
import com.escenic.xmlns.x2009.ximport.EscenicDocument;
import com.escenic.xmlns.x2009.ximport.EscenicDocument.Escenic.Version;
import com.escenic.xmlns.x2009.ximport.FieldDocument.Field;
import com.escenic.xmlns.x2009.ximport.PriorityDocument.Priority;
import com.escenic.xmlns.x2009.ximport.SectionRefDocument.SectionRef;
import com.escenic.xmlns.x2009.ximport.TagDocument.Tag;
import com.news.Article;
import com.news.Competition;
import com.news.Place;
import com.news.Sport;

public class ExtractStoriesContraXML {
	
	private static String queryString=" SELECT a FROM Article a WHERE a.sport.sportID <> 0 ORDER BY a.articleID DESC";
	public static List<Competition> competitions = new ArrayList<Competition>();
	public static List<Sport> sports = new ArrayList<Sport>();
	public static XmlOptions opt;
	private static EntityManager em;
	
	public static void main(String[] args) throws Exception {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DownloadContraArticlesJPA");
		em = emf.createEntityManager();
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		opt = new XmlOptions();
		opt.setUseCDataBookmarks();
		opt.setSaveCDataLengthThreshold(0);
		opt.setSaveCDataEntityCountThreshold(-1);
		
		int i = 0;
		int maxResults = 1000;
		
		competitions = em.createQuery(" SELECT c FROM Competition c ").getResultList();
		sports = em.createQuery(" SELECT c FROM Sport c ").getResultList();
		
		Query q = em.createQuery(queryString)
		.setFirstResult(i*maxResults)
		.setMaxResults(maxResults);
		List<Article> results = q.getResultList();

//		while (!results.isEmpty()) {
			EscenicDocument escenicDocument = EscenicDocument.Factory.newInstance(opt);
			initializeEscenic(escenicDocument);
			for (Article article : results) {
				
				Content content = escenicDocument.getEscenic().addNewContent();
				content.addNewSource().setStringValue("ContraNews");
				content.addNewSourceid().setStringValue(Integer.toString(article.getArticleID()));
				content.addNewType().setStringValue("news");
				content.setState(State.PUBLISHED);
				content.addNewPublishdate().setStringValue(dtf.format(article.getArticleDate()));
				content.addNewCreationdate().setStringValue(dtf.format(article.getArticleDate()));

				
				SectionRef sectionRef = content.addNewSectionRef();
				try {
					if (article.getCompetition().getCompetitionID() != 0) {
						sectionRef.addNewUniqueName().setStringValue(article.getCompetition().getCompetitionName_url());
					} else if (article.getCompetition().getCompetitionID() == 0 && article.getPlace().getPlaceID() != 0 && existCompetition(article.getSport(), article.getPlace())) {
						sectionRef.addNewUniqueName().setStringValue(article.getPlace().getPlaceName_url() + "_" + article.getSport().getSportName_url());
					} else {
						sectionRef.addNewUniqueName().setStringValue(article.getSport().getSportName_url());
					}
				}catch (Exception e) {
					System.out.println("No section found for article"+ article.getArticleID());
					throw new Exception(e.getMessage());
				}
				sectionRef.setHomeSection(true);

//				List<Image> images = em.createQuery(" SELECT i FROM Image i WHERE i.articleId = " + article.getId()).getResultList();
//				
//				for (Image image : images) {
//					// picture relation
					Relation relation = content.addNewRelation();
					relation.addNewType().setStringValue("PICTUREREL");
					relation.addNewSource().setStringValue("ContraImages");
					relation.addNewSourceid().setStringValue(article.getArticlePhoto());
				
			if (article.getLinks() != null) {
				for (String articleId : article.getLinks().split(",")) {
					articleId = articleId.trim();
					if (articleId.isEmpty())
						continue;

					if (articleId.startsWith("ph")) {
						try {
							em.createQuery("FROM PhotoStory WHERE photoStoryID = :photoStoryID").setParameter("photoStoryID", articleId.toLowerCase().replaceAll("ph", "")).getSingleResult();
							Relation relationStory = content.addNewRelation();
							relationStory.addNewType().setStringValue("PHOTOSTORYREL");
							relationStory.addNewSource().setStringValue("ContraPhotostory");
							relationStory.addNewSourceid().setStringValue(article.getArticlePhoto());
						} catch (Exception e) {
							System.out.println("No PhotoStory found with id " + articleId.replaceAll("ph", ""));
						}
					} else {
						Relation relationStory = content.addNewRelation();
						relationStory.addNewType().setStringValue("STORYREL");
						relationStory.addNewSource().setStringValue("ContraNews");
						relationStory.addNewSourceid().setStringValue(articleId);
					}
				}
			}
//					Field titlePictureField = relation.addNewField();
//					titlePictureField.addNewName().setStringValue("title");
//					titlePictureField.newCursor().setTextValue(image.getCaption());
//
//					Field captionTitlePictureField = relation.addNewField();
//					captionTitlePictureField.addNewName().setStringValue("captiontitle");
//					Field captionPictureField = relation.addNewField();
//					captionPictureField.addNewName().setStringValue("caption");
//					captionPictureField.newCursor().setTextValue(image.getCaption());
//				}
				Priority priority = content.addNewPriority();
				priority.setValue(0);

				Field titleField = content.addNewField();
				titleField.addNewName().setStringValue("title");
				titleField.newCursor().setTextValue(article.getArticleTitle());
////				Field superTitleField = content.addNewField();
////				superTitleField.addNewName().setStringValue("supertitle");
////				superTitleField.newCursor().setTextValue(article.getTitle());
//				
				Field leadtextField = content.addNewField();
				leadtextField.addNewName().setStringValue("leadtext");
				leadtextField.newCursor().setTextValue(article.getArticleSummary()==null?"":article.getArticleSummary().replaceAll("\\<.*?\\>", ""));
//				Field quoteField = content.addNewField();
//				quoteField.addNewName().setStringValue("quote");
				Field bodyField = content.addNewField();
				bodyField.addNewName().setStringValue("body");
				
//				//body
				XmlCursor bodyCursor  = bodyField.newCursor();
				bodyCursor.xmlText(opt);
				String fixedBody = article.getArticleBody().trim();
				if(!fixedBody.isEmpty())
					fixedBody = HTMLFilter.fixHtml(fixedBody);
				bodyCursor.setTextValue(fixedBody);
//				
				Field bylineField = content.addNewField();
				bylineField.addNewName().setStringValue("byline");
				bylineField.newCursor().setTextValue( article.getArticleAuthor() == null ? "" : article.getArticleAuthor().trim());
//				
//				
				if(article.getTeam1().getTeamID()!=0){
					Tag tag = content.addNewTag();
					tag.newCursor().setTextValue(article.getTeam1().getTeamName_url());
				}
				
				if(article.getTeam2().getTeamID()!=0){
					Tag tag = content.addNewTag();
					tag.newCursor().setTextValue(article.getTeam2().getTeamName_url());
				}
				
//				Field bylineprefixField = content.addNewField();
//				bylineprefixField.addNewName().setStringValue("bylineprefix");
//				
//				Field notesField = content.addNewField();
//				notesField.addNewName().setStringValue("notes");
//				
//				Field geocodeField = content.addNewField();
//				geocodeField.addNewName().setStringValue("com.escenic.geocode");
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

			String outFileName = "import-stories/stories"+(counterString)+".xml";
			File f = new File(outFileName);
			escenicDocument.save(f);
			
//			q = em.createQuery(" SELECT a FROM Article a WHERE a.sport.sportID <> 0")
//			.setFirstResult(i*maxResults)
//			.setMaxResults(maxResults);
//			results = q.getResultList();
//		}
		ReplaceCDATA.replace();
	}
	

	private static boolean existCompetition(Sport sport, Place place) {
			List c = em.createQuery("SELECT c FROM Competition c WHERE c.sport = :sport AND c.place = :place")
			.setParameter("sport", sport)
			.setParameter("place", place)
			.getResultList();
		return !c.isEmpty();
	}


	private static void initializeEscenic(EscenicDocument escenicDocument) {
		escenicDocument.addNewEscenic();
		escenicDocument.getEscenic().setVersion(Version.X_2_0);
	}
	
}
