package com.main.script;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.news.Article;
import com.news.Photo;
import com.news.PhotoStory;

//import com.news.Image;

public class ImageShellPhotostoryScript {
	
	private static EntityManager em;
	private static Query q;
	private static String fileName;

	public static void main(String args[]) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DownloadContraArticlesJPA");
		em = emf.createEntityManager();
		
		int dis =  photostoryScript();
		
		try {
			// Create file
			FileWriter fstream = new FileWriter(fileName);
			BufferedWriter out = new BufferedWriter(fstream);

			int i = 0;
			int maxResults = 500;

			List<Object> objects = q.setFirstResult(i * maxResults).setMaxResults(maxResults).getResultList();

			while (!objects.isEmpty()) {
				for (Object photostoryObj : objects) {
					PhotoStory photoStory = (PhotoStory) photostoryObj;
					for(Photo photo : photoStory.getPhotos()){
						if(photo.getPhoto().trim().isEmpty() || photo.getPhoto().indexOf('.')==-1)
							continue;
						out.write("wget -O '/home/vassilis/Pictures/cosmo/"+photo.getPhoto().trim()+"' 'http://static.fsport.gr/images/"+ photo.getPhoto().trim() + "' -a photos.log ; \n");
					}
				}
				i++;
				out.write("echo " + i*500+"; \n");
				objects = q.setFirstResult(i * maxResults).setMaxResults(maxResults).getResultList();
			}
			// Close the output stream
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		
	}
	

	private static int photostoryScript() {
		q = em.createQuery(" SELECT distinct a FROM PhotoStory a WHERE a.photoStoryID >=151 AND a.subSection.subSectionID in (19,7,8) ORDER BY a.photoStoryID DESC");
		fileName = "photostory.sh";
		return 1;
	}


}
