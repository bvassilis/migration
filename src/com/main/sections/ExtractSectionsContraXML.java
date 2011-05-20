package com.main.sections;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.escenic.xmlns.x2009.ximport.EscenicDocument;
import com.escenic.xmlns.x2009.ximport.EscenicDocument.Escenic.Version;
import com.escenic.xmlns.x2009.ximport.ParentDocument.Parent;
import com.escenic.xmlns.x2009.ximport.SectionDocument.Section;
//import com.news.Category;
//import com.news.Newspaper;
//import com.news.Newstype;
import com.news.Competition;
import com.news.Place;
import com.news.Sport;

public class ExtractSectionsContraXML {
	
	static EntityManager em;

	public static void main(String[] args) throws IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DownloadContraArticlesJPA");
		em = emf.createEntityManager();
		
		exportCategoriesContraXML();
//		exportNewspapersSectionsContraXML();
	}
	
//	private static void exportNewspapersSectionsContraXML() throws IOException {
//		EscenicDocument escenicDocument = EscenicDocument.Factory.newInstance();
//		initializeEscenic(escenicDocument);
//		
//		//newspapers section
//		Section section = escenicDocument.getEscenic().addNewSection();
//		section.addNewSource().setStringValue("ContraSections");
//		section.addNewSourceid().setStringValue("newspapers");
//		section.addNewName().setStringValue("Πρωτοσέλιδα");
//		section.setMirrorSource2(false);
//		
//		Parent parent = section.addNewParent();
//		parent.addNewUniqueName().setStringValue("ece_frontpage");
//
//		section.addNewUniqueName().newCursor().setTextValue("newspapers");
//		section.addNewDirectory().newCursor().setTextValue("newspapers");
//		section.addNewSectionLayout().newCursor().setTextValue("defaultsection");
//		section.addNewArticleLayout().newCursor().setTextValue("defaultarticle");
//		//end newpapers sections
//		
//		Query q = em.createQuery("SELECT p FROM Newstype p ORDER BY p.priority");
//		List<Newstype> resultsNewstype = q.getResultList();
//		
//		for (Newstype newstype : resultsNewstype) {
//			section = escenicDocument.getEscenic().addNewSection();
//			section.addNewSource().setStringValue("ContraSections");
//			section.addNewSourceid().setStringValue(newstype.getName());
//			section.addNewName().setStringValue(newstype.getDisplayName());
//			section.setMirrorSource2(false);
//			
//			parent = section.addNewParent();
//			parent.addNewSource().setStringValue("ContraSections");
//			parent.addNewSourceid().setStringValue("newspapers");
//
//			section.addNewUniqueName().newCursor().setTextValue(newstype.getName());
//			section.addNewDirectory().newCursor().setTextValue(newstype.getName());
//			section.addNewSectionLayout().newCursor().setTextValue("defaultsection");
//			section.addNewArticleLayout().newCursor().setTextValue("defaultarticle");
//		}
//
//		q = em.createQuery("SELECT n FROM Newspaper n ORDER BY n.priority");
//		List<Newspaper> resultsNewspaper = q.getResultList();
//		
//		for (Newspaper newspaper : resultsNewspaper) {
//			section = escenicDocument.getEscenic().addNewSection();
//			section.addNewSource().setStringValue("ContraSections");
//			String englishTitle = ELOT743Convertor.convert(newspaper.getTitle().toLowerCase());
//			section.addNewSourceid().setStringValue(englishTitle);
//			section.addNewName().setStringValue(newspaper.getTitle());
//			section.setMirrorSource2(false);
//			
//			Newstype newstype = (Newstype) em.createQuery("SELECT p FROM Newstype p WHERE p.id = "+newspaper.getTypeId()).getSingleResult();
//			parent = section.addNewParent();
//			parent.addNewSource().setStringValue("ContraSections");
//			parent.addNewSourceid().setStringValue(newstype.getName());
//
//			section.addNewUniqueName().newCursor().setTextValue(englishTitle);
//			section.addNewDirectory().newCursor().setTextValue(englishTitle);
//			section.addNewSectionLayout().newCursor().setTextValue("defaultsection");
//			section.addNewArticleLayout().newCursor().setTextValue("defaultarticle");
//		}
//		
//	    String outFileName = "import-sections/newspapers-sections.xml";
//	    File f = new File(outFileName);
//	    escenicDocument.save(f);
//	}

	private static void exportCategoriesContraXML() throws IOException{
		
		
		Query q = em.createQuery("SELECT p FROM Sport p WHERE p.sportID in (1,2,29,42)");
		
		List<Sport> results = q.getResultList();

		Query q2 = em.createQuery("SELECT p FROM Sport p WHERE p.sportID not in (0,1,2,29,42)");
		
		List<Sport> results2 = q2.getResultList();
		
		results.addAll(results2);
//		List<Integer> resultsCategoriesIds = q2.getResultList();
//		resultsCategoriesIds.add(Integer.valueOf(12));
		EscenicDocument escenicDocument = EscenicDocument.Factory.newInstance();
		initializeEscenic(escenicDocument);
		
		for (Sport cat : results) {
			Section section = escenicDocument.getEscenic().addNewSection();
			section.addNewSource().setStringValue("ContraSections");
			section.addNewSourceid().setStringValue(Integer.toString(cat.getSportID()));
			section.addNewName().setStringValue(cat.getSportName());
			section.setMirrorSource2(false);

			Parent parent = section.addNewParent();
			if (cat.getSportID() != 1 && cat.getSportID() != 2 && cat.getSportID() != 29 && cat.getSportID() != 42) {
				parent.addNewSource().setStringValue("ContraSections");
				parent.addNewSourceid().setStringValue(Integer.toString(42));
			} else {
				parent.addNewUniqueName().setStringValue("ece_frontpage");
			}

			section.addNewUniqueName().newCursor().setTextValue(cat.getSportName_url());
			section.addNewDirectory().newCursor().setTextValue(cat.getSportName_url());
			section.addNewSectionLayout().newCursor().setTextValue("defaultsection");
			section.addNewArticleLayout().newCursor().setTextValue("defaultarticle");
		}
		
		//competitions table
		Query q3 = em.createQuery("SELECT c FROM Competition c WHERE c.sport.sportID <> 0 AND c.competitionID<>0");
		Place defaultPlace = (Place) em.createQuery("Select p FROM Place p WHERE p.placeID = 1").getSingleResult();
		Sport defaultSport = (Sport) em.createQuery("Select p FROM Sport p WHERE p.sportID = 1").getSingleResult();
		List<Competition> results3 = q3.getResultList();
		
		//sport -places
		for (Competition cat : results3) {
			Sport defSport = cat.getSport();
			Place defPlace = cat.getPlace();
			if(defPlace.getPlaceID()==0){
				defPlace = defaultPlace;
			}
			if(defSport.getSportID()==0){
				defSport = defaultSport;
			}
			Section section = escenicDocument.getEscenic().addNewSection();
			section.addNewSource().setStringValue("ContraSections");
			section.addNewSourceid().setStringValue(Integer.toString(defSport.getSportID()) +"-"+Integer.toString(defPlace.getPlaceID()));
			section.addNewName().setStringValue(defPlace.getPlaceName());
			section.setMirrorSource2(false);

			Parent parent = section.addNewParent();
			parent.addNewSource().setStringValue("ContraSections");
			parent.addNewSourceid().setStringValue(Integer.toString(defSport.getSportID()));

			section.addNewUniqueName().newCursor().setTextValue(defPlace.getPlaceName_url()+"_"+defSport.getSportName_url());
			section.addNewDirectory().newCursor().setTextValue(defPlace.getPlaceName_url());
			section.addNewSectionLayout().newCursor().setTextValue("defaultsection");
			section.addNewArticleLayout().newCursor().setTextValue("defaultarticle");
		}
		
		//places - competitions
		for (Competition cat : results3) {
			Sport defSport = cat.getSport();
			Place defPlace = cat.getPlace();
			if(defPlace.getPlaceID()==0){
				defPlace = defaultPlace;
			}
			if(defSport.getSportID()==0){
				defSport = defaultSport;
			}
			Section section = escenicDocument.getEscenic().addNewSection();
			section.addNewSource().setStringValue("ContraSections");
			section.addNewSourceid().setStringValue(Integer.toString(defSport.getSportID()) +"-"+Integer.toString(defPlace.getPlaceID())+"-"+Integer.toString(cat.getCompetitionID()));
			section.addNewName().setStringValue(cat.getCompetitionName());
			section.setMirrorSource2(false);

			Parent parent = section.addNewParent();
			parent.addNewSource().setStringValue("ContraSections");
			parent.addNewSourceid().setStringValue(Integer.toString(defSport.getSportID()) +"-"+Integer.toString(defPlace.getPlaceID()));

			section.addNewUniqueName().newCursor().setTextValue(cat.getCompetitionName_url());
			section.addNewDirectory().newCursor().setTextValue(cat.getCompetitionName_url());
			section.addNewSectionLayout().newCursor().setTextValue("defaultsection");
			section.addNewArticleLayout().newCursor().setTextValue("defaultarticle");
		}
		
		
		
	    String outFileName = "import-sections/sections-contra.xml";
	    File f = new File(outFileName);
	    escenicDocument.save(f);
	}

	private static void initializeEscenic(EscenicDocument escenicDocument) {
		escenicDocument.addNewEscenic();
		escenicDocument.getEscenic().setVersion(Version.X_2_0);
	}
}
