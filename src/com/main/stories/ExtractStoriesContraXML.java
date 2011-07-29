package com.main.stories;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
import com.news.Articles_Archives100_130000;
import com.news.Competition;
import com.news.Place;
import com.news.Sport;

public class ExtractStoriesContraXML {

	private static String queryString = " SELECT a FROM Article a WHERE (a.subSection.subSectionID in (19,7,8) OR a.subSectionTagID in (20,7,15,22,24,12,13,14,1,2,3,5,11,4,25,19,18,16,6,17)) AND a.articleID > :articleID ORDER BY a.articleID ASC";
//	public static List<Competition> competitions = new ArrayList<Competition>();
//	public static List<Sport> sports = new ArrayList<Sport>();
	public static XmlOptions opt;
	private static EntityManager em;

	public static void main(String[] args) throws Exception {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DownloadContraArticlesJPA");
		em = emf.createEntityManager();
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String outfolder = "import-stories";
		opt = new XmlOptions();
		opt.setUseCDataBookmarks();
		opt.setSaveCDataLengthThreshold(0);
		opt.setSaveCDataEntityCountThreshold(-1);
		List<Integer> tagids = Arrays.asList(20,7,15,22,24,12,13,14,1,2,3,5,11,4,25,19,18,16,6,17);
		int i = 0;
		int maxResults = 10;
		Integer maxArticleId = 333050;

		Query q = em.createQuery(queryString).setParameter("articleID", maxArticleId).setMaxResults(maxResults);
		List<Article> results = q.getResultList();
		while (!results.isEmpty()) {
			EscenicDocument escenicDocument = EscenicDocument.Factory.newInstance(opt);
			initializeEscenic(escenicDocument);
			for (Article article : results) {
				maxArticleId = article.getArticleID();
				Content content = escenicDocument.getEscenic().addNewContent();
				content.addNewSource().setStringValue("CosmoNews");
				content.addNewSourceid().setStringValue(Integer.toString(article.getArticleID()));
				content.addNewType().setStringValue("news");
				content.setState(State.PUBLISHED);
				content.addNewPublishdate().setStringValue(dtf.format(article.getArticleDate()));
				content.addNewCreationdate().setStringValue(dtf.format(article.getArticleDate()));

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

				// picture relation
				if (article.getArticlePhoto() != null && !article.getArticlePhoto().trim().isEmpty()) {
					String fullPath = "/home/vassilis/Pictures/cosmo/" + article.getArticlePhoto().trim();
					//
					// //check if file
					if (new File(fullPath).exists()) {
						Relation relation = content.addNewRelation();
						relation.addNewType().setStringValue("PICTUREREL");
						relation.addNewSource().setStringValue("CosmoImages");
						relation.addNewSourceid().setStringValue(article.getArticlePhoto().trim());
					}
				}

				if (article.getLinks() != null) {
					for (String articleId : article.getLinks().split(",")) {
						articleId = articleId.trim();
						if (articleId.isEmpty())
							continue;

						if (!articleId.matches("[0-9]*")) {
							continue;
						} else {
							Relation relationStory = content.addNewRelation();
							relationStory.addNewType().setStringValue("STORYREL");
							relationStory.addNewSource().setStringValue("CosmoNews");
							relationStory.addNewSourceid().setStringValue(articleId);
						}

					}
				}
				Priority priority = content.addNewPriority();
				priority.setValue(0);

				Field titleField = content.addNewField();
				titleField.addNewName().setStringValue("title");
				titleField.newCursor().setTextValue(article.getArticleTitle());
				Field superTitleField = content.addNewField();
				superTitleField.addNewName().setStringValue("slug");
				superTitleField.newCursor().setTextValue(article.getArticleTitle());

				Field leadtextField = content.addNewField();
				leadtextField.addNewName().setStringValue("leadtext");
				leadtextField.newCursor().setTextValue(article.getArticleSummary() == null ? "" : article.getArticleSummary().replaceAll("\\<.*?\\>", ""));

				if (article.getArticleBody() != null && !article.getArticleBody().trim().isEmpty()) {
					Field bodyField = content.addNewField();
					bodyField.addNewName().setStringValue("body");
					// //body
					XmlCursor bodyCursor = bodyField.newCursor();
					bodyCursor.xmlText(opt);
					String fixedBody = article.getArticleBody().trim();
					fixedBody = HTMLFilter.fixHtml(fixedBody);
					bodyCursor.setTextValue(fixedBody);
				}
				//
				Field bylineField = content.addNewField();
				bylineField.addNewName().setStringValue("byline");
				bylineField.newCursor().setTextValue(article.getArticleAuthor() == null ? "" : article.getArticleAuthor().trim());

				//
				// String tagFieldString = "";
				// if(article.getTeam1() !=null &&
				// article.getTeam1().getTeamID()>0 &&
				// article.getTeam1().getTeamName_url() != null){
				// tagFieldString = "tagppo"
				// +article.getTeam1().getTeamName_url().toLowerCase();
				// }
				//
				// if(article.getTeam2() !=null &&
				// article.getTeam2().getTeamID()>0 &&
				// article.getTeam2().getTeamName_url() != null){
				// tagFieldString = tagFieldString + " tagppo" +
				// article.getTeam2().getTeamName_url().toLowerCase();
				// }
				//
				// if(!tagFieldString.isEmpty()){
				// Field tagField = content.addNewField();
				// tagField.addNewName().setStringValue("tag");
				// tagField.newCursor().setTextValue(tagFieldString);
				// }

				//
				//
				// if(article.getTeam1()!=null &&
				// article.getTeam1().getTeamID()!=0){
				// Tag tag = content.addNewTag();
				// tag.newCursor().setTextValue(article.getTeam1().getTeamName_url());
				// }
				//
				// if(article.getTeam2()!=null &&
				// article.getTeam2().getTeamID()!=0){
				// Tag tag = content.addNewTag();
				// tag.newCursor().setTextValue(article.getTeam2().getTeamName_url());
				// }

				// Field bylineprefixField = content.addNewField();
				// bylineprefixField.addNewName().setStringValue("bylineprefix");
				//
				// Field notesField = content.addNewField();
				// notesField.addNewName().setStringValue("notes");
				//
				// Field geocodeField = content.addNewField();
				// geocodeField.addNewName().setStringValue("com.escenic.geocode");
			}

			String counterString = "";
			++i;
			if (i < 10) {
				counterString = "000";
			} else if (i < 100) {
				counterString = "00";
			} else if (i < 1000) {
				counterString = "0";
			} else if (i < 10000) {
				counterString = "";
			}
			counterString = counterString + i;

			String outFileName = outfolder + "/stories-news" + (counterString) + ".xml";
			File f = new File(outFileName);
			escenicDocument.save(f);
			
			q = em.createQuery(queryString).setParameter("articleID", maxArticleId).setMaxResults(maxResults);
			results = q.getResultList();

		}
		ReplaceCDATA.replace(outfolder);
	}

	private static void initializeEscenic(EscenicDocument escenicDocument) {
		escenicDocument.addNewEscenic();
		escenicDocument.getEscenic().setVersion(Version.X_2_0);
	}

}
