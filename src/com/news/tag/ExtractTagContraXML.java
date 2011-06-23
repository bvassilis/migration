package com.news.tag;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.escenic.xmlns.x2009.ximport.ContentDocument.Content;
import com.escenic.xmlns.x2009.ximport.ContentDocument.Content.State;
import com.escenic.xmlns.x2009.ximport.EscenicDocument;
import com.escenic.xmlns.x2009.ximport.EscenicDocument.Escenic.Version;
import com.escenic.xmlns.x2009.ximport.FieldDocument.Field;
import com.escenic.xmlns.x2009.ximport.PriorityDocument.Priority;
import com.escenic.xmlns.x2009.ximport.SectionRefDocument.SectionRef;
import com.news.Team;

public class ExtractTagContraXML {
	
	private static String queryString="SELECT a FROM Team a WHERE a.teamID>0 AND a.teamName_url is not null";
	public static void main(String[] args) throws Exception {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DownloadContraArticlesJPA");
		EntityManager em = emf.createEntityManager();
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int i = 0;
		int maxResults = 100;
		List<Team>teams = new ArrayList<Team>();
		
		Query q = em.createQuery(queryString)
		.setFirstResult(i*maxResults)
		.setMaxResults(maxResults);
		teams = q.getResultList();

		while (!teams.isEmpty()) {
			EscenicDocument escenicDocument = EscenicDocument.Factory.newInstance();
			initializeEscenic(escenicDocument);
			for (Team team : teams) {
				
				Content content = escenicDocument.getEscenic().addNewContent();
				content.addNewSource().setStringValue("ContraTags");
				content.addNewSourceid().setStringValue(Integer.toString(team.getTeamID()));
				content.addNewType().setStringValue("tag");
				content.setState(State.PUBLISHED);
				content.addNewPublishdate().setStringValue(dtf.format(new Date()));
				content.addNewCreationdate().setStringValue(dtf.format(new Date()));

				SectionRef sectionRef = content.addNewSectionRef();
				sectionRef.addNewUniqueName().setStringValue("tags");
				sectionRef.setHomeSection(true);

				Priority priority = content.addNewPriority();
				priority.setValue(0);

				Field titleField = content.addNewField();
				titleField.addNewName().setStringValue("title");
				titleField.newCursor().setTextValue(team.getTeamName_url().toLowerCase());
				
				Field codeField = content.addNewField();
				codeField.addNewName().setStringValue("displayName");
				codeField.newCursor().setTextValue(team.getTeamName());
				
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

			String outFileName = "import-tags/tag"+(counterString)+".xml";
			File f = new File(outFileName);
			escenicDocument.save(f);
			
			q = em.createQuery(queryString)
			.setFirstResult(i*maxResults)
			.setMaxResults(maxResults);
			teams = q.getResultList();
		}
	}

	private static void initializeEscenic(EscenicDocument escenicDocument) {
		escenicDocument.addNewEscenic();
		escenicDocument.getEscenic().setVersion(Version.X_2_0);
	}
	
}
