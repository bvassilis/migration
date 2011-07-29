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
import com.news.Video;

//import com.news.Image;

public class ImageVideoShellScript {
	
	private static EntityManager em;
	private static Query q;
	private static String fileName;

	public static void main(String args[]) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DownloadContraArticlesJPA");
		em = emf.createEntityManager();
		
		videoThumbs();
		
		try {
			// Create file
			FileWriter fstream = new FileWriter(fileName);
			BufferedWriter out = new BufferedWriter(fstream);

			int i = 0;
			int maxResults = 300;

			List<Object> objects = q.setFirstResult(i * maxResults).setMaxResults(maxResults).getResultList();

//			while (!objects.isEmpty()) {
				for (Object videoObj : objects) {
					String photo = (String) videoObj;
					if(photo.trim().isEmpty() || photo.indexOf('.')==-1)
						continue;
					out.write("wget -O '/home/vassilis/Pictures/cosmovideos/"+photo.trim()+"' 'http://www.cosmo.gr/videoThumbs/"+ photo.trim() + "' -a videos.log ; \n");
				}
				i++;
				out.write("echo " + i*500+"; \n");
//				objects = q.setFirstResult(i * maxResults).setMaxResults(maxResults).getResultList();
//			}
			// Close the output stream
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		
	}
	
	private static int videoThumbs() {
		q = em.createQuery(" SELECT distinct a.videoThumb FROM Video a WHERE a.videoThumb is not null AND a.subSection.section.sectionID=3 ORDER BY a.videoID DESC");
		fileName = "video.sh";
		return 2;
	}


}
