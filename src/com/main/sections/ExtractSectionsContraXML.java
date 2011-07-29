package com.main.sections;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.escenic.xmlns.x2009.ximport.EscenicDocument;
import com.escenic.xmlns.x2009.ximport.EscenicDocument.Escenic.Version;
import com.escenic.xmlns.x2009.ximport.ParentDocument.Parent;
import com.escenic.xmlns.x2009.ximport.SectionDocument.Section;
import com.news.Competition;
import com.news.Place;
import com.news.Sport;
import com.news.SubSection;

public class ExtractSectionsContraXML {

	static EntityManager em;

	public static void main(String[] args) throws IOException {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DownloadContraArticlesJPA");
//		em = emf.createEntityManager();

		exportCategoriesContraXML();
	}


	private static void exportCategoriesContraXML() throws IOException {

		try {
			// Open the file that is the first
			// command line parameter
			FileInputStream fstream = new FileInputStream("/home/vassilis/workspace/TransformContraArticlesJPA/sections.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
//			BufferedReader br2 = new BufferedReader(new InputStreamReader(in));
			
			EscenicDocument escenicDocument = EscenicDocument.Factory.newInstance();
			initializeEscenic(escenicDocument);
			
			String strLine;
			
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				String[] strLineArray = strLine.split(",");
				int i = 0;
				while(i<5){
					strLineArray[i] = strLineArray[i].replace('?', ' ').trim();
					i++;
				}
				Section section = escenicDocument.getEscenic().addNewSection();
				if(!strLineArray[4].isEmpty()){
					section.addNewSource().setStringValue("CosmoSection");
					section.addNewSourceid().setStringValue(strLineArray[4]);
					String sectionName = strLineArray[2].isEmpty()?(strLineArray[1].isEmpty()?strLineArray[0]:strLineArray[1]):strLineArray[2];
					section.addNewName().setStringValue(sectionName);
					section.setMirrorSource2(false);
					Parent parent = section.addNewParent();
					String parentName = strLineArray[1].isEmpty()?strLineArray[0]:strLineArray[1];
					parent.addNewUniqueName().setStringValue(ELOT743Convertor.convert(parentName));
					section.addNewUniqueName().newCursor().setTextValue(ELOT743Convertor.convert(sectionName));
					section.addNewDirectory().newCursor().setTextValue(ELOT743Convertor.convert(sectionName));
					section.addNewSectionLayout().newCursor().setTextValue("defaultsection");
					section.addNewArticleLayout().newCursor().setTextValue("defaultarticle");
				} else if(!strLineArray[3].isEmpty()){
					section.addNewSource().setStringValue("CosmoTagSection");
					section.addNewSourceid().setStringValue(strLineArray[3]);
					String sectionName = strLineArray[2].isEmpty()?(strLineArray[1].isEmpty()?strLineArray[0]:strLineArray[1]):strLineArray[2];
					section.addNewName().setStringValue(sectionName);
					section.setMirrorSource2(false);
					Parent parent = section.addNewParent();
					String parentName = strLineArray[1].isEmpty()?strLineArray[0]:strLineArray[1];
					parent.addNewUniqueName().setStringValue(ELOT743Convertor.convert(parentName));
					section.addNewUniqueName().newCursor().setTextValue(ELOT743Convertor.convert(sectionName));
					section.addNewDirectory().newCursor().setTextValue(ELOT743Convertor.convert(sectionName));
					section.addNewSectionLayout().newCursor().setTextValue("defaultsection");
					section.addNewArticleLayout().newCursor().setTextValue("defaultarticle");
				} else if(!strLineArray[2].isEmpty()){
					String sectionName = strLineArray[2].isEmpty()?(strLineArray[1].isEmpty()?strLineArray[0]:strLineArray[1]):strLineArray[2];
					section.addNewName().setStringValue(sectionName);
					section.setMirrorSource2(false);
					Parent parent = section.addNewParent();
					String parentName = !strLineArray[1].isEmpty()?strLineArray[1]:strLineArray[0];
					parent.addNewUniqueName().setStringValue(ELOT743Convertor.convert(parentName));
					section.addNewUniqueName().newCursor().setTextValue(ELOT743Convertor.convert(sectionName));
					section.addNewDirectory().newCursor().setTextValue(ELOT743Convertor.convert(sectionName));
					section.addNewSectionLayout().newCursor().setTextValue("defaultsection");
					section.addNewArticleLayout().newCursor().setTextValue("defaultarticle");
				} else if(!strLineArray[1].isEmpty()){
					String sectionName = strLineArray[2].isEmpty()?(strLineArray[1].isEmpty()?strLineArray[0]:strLineArray[1]):strLineArray[2];
					section.addNewName().setStringValue(sectionName);
					section.setMirrorSource2(false);
					Parent parent = section.addNewParent();
					String parentName = strLineArray[0];
					parent.addNewUniqueName().setStringValue(ELOT743Convertor.convert(parentName));
					section.addNewUniqueName().newCursor().setTextValue(ELOT743Convertor.convert(sectionName));
					section.addNewDirectory().newCursor().setTextValue(ELOT743Convertor.convert(sectionName));
					section.addNewSectionLayout().newCursor().setTextValue("defaultsection");
					section.addNewArticleLayout().newCursor().setTextValue("defaultarticle");
				} else if(!strLineArray[0].isEmpty()){
					String sectionName = strLineArray[2].isEmpty()?(strLineArray[1].isEmpty()?strLineArray[0]:strLineArray[1]):strLineArray[2];
					section.addNewName().setStringValue(sectionName);
					section.setMirrorSource2(false);
					Parent parent = section.addNewParent();
					parent.addNewUniqueName().setStringValue("ece_frontpage");
					section.addNewUniqueName().newCursor().setTextValue(ELOT743Convertor.convert(sectionName));
					section.addNewDirectory().newCursor().setTextValue(ELOT743Convertor.convert(sectionName));
					section.addNewSectionLayout().newCursor().setTextValue("defaultsection");
					section.addNewArticleLayout().newCursor().setTextValue("defaultarticle");
				}
			}
			// Close the input stream
			String outFileName = "import-sections/sections-cosmo.xml";
			File f = new File(outFileName);
			escenicDocument.save(f);
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}



		
	}


	private static void initializeEscenic(EscenicDocument escenicDocument) {
		escenicDocument.addNewEscenic();
		escenicDocument.getEscenic().setVersion(Version.X_2_0);
	}
}
