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

public class ImageShellScript {
	
	private static EntityManager em;
	private static Query q;
	private static String fileName;

	public static void main(String args[]) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DownloadContraArticlesJPA");
		em = emf.createEntityManager();
		
//		int dis = imagesScript();
//		int dis =  photostoryScript();
		int dis =  videoThumbs();
		
		try {
			// Create file
			FileWriter fstream = new FileWriter(fileName);
			BufferedWriter out = new BufferedWriter(fstream);

			int i = 0;
			int maxResults = 1000;

			List<Object> objects = q.setFirstResult(i * maxResults).setMaxResults(maxResults).getResultList();

			while (!objects.isEmpty()) {
				if(dis == 0){
					for (Object articleObj : objects) {
						String photo = (String) articleObj;
						if(photo.trim().isEmpty() || photo.indexOf('.')==-1)
							continue;
						out.write("wget -O '/home/vassilis/Pictures/contra/"+photo.trim()+"' 'http://static.fsport.gr/images/"+ photo.trim() + "' -a images.log ; \n");
					}
				}
				if(dis == 1){
					for (Object photostoryObj : objects) {
						PhotoStory photoStory = (PhotoStory) photostoryObj;
						for(Photo photo : photoStory.getPhotos()){
							if(photo.getPhoto().trim().isEmpty() || photo.getPhoto().indexOf('.')==-1)
								continue;
							out.write("wget -O '/home/vassilis/Pictures/contra/"+photo.getPhoto().trim()+"' 'http://static.fsport.gr/images/"+ photo.getPhoto().trim() + "' -a photos.log ; \n");
						}
					}
				}
				if(dis == 2){
					for (Object videoObj : objects) {
						String photo = (String) videoObj;
						if(photo.trim().isEmpty() || photo.indexOf('.')==-1)
							continue;
						out.write("wget -O '/home/vassilis/Pictures/contravideos/"+photo.trim()+"' 'http://www.cosmo.gr/videoThumbs/"+ photo.trim() + "' -a videos.log ; \n");
					}
				}
				i++;
				out.write("echo " + i*1000+"; \n");
				objects = q.setFirstResult(i * maxResults).setMaxResults(maxResults).getResultList();
			}
			// Close the output stream
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		
	}
	
	private static int videoThumbs() {
		q = em.createQuery(" SELECT distinct a.videoThumb FROM Video a WHERE a.videoThumb is not null AND (a.subSection.section.sectionID=1 OR a.subSection.section.sectionID=4) AND a.subSection.subSectionID not in (47,16) ORDER BY a.videoID DESC");
		fileName = "video.sh";
		return 2;
	}

	private static int photostoryScript() {
		q = em.createQuery(" SELECT distinct a FROM PhotoStory a WHERE a.photoStoryID >=151 AND (a.subSection.section.sectionID=1 OR a.subSection.section.sectionID=4) AND a.subSection.subSectionID not in (47,16) ORDER BY a.photoStoryID DESC");
		fileName = "photostory.sh";
		return 1;
	}

//	private static String getXlPhoto(String articlePhoto) {
//		int lind =articlePhoto.lastIndexOf('.');
//		return articlePhoto.substring(0, lind)+"_xl"+articlePhoto.substring(lind, articlePhoto.length());
//	}

	private static int imagesScript(){
		Calendar cal = Calendar.getInstance();
		cal.set(2007, 0, 1, 0, 0, 0);
		q = em.createQuery(" SELECT distinct a.articlePhoto FROM Article a WHERE a.articlePhoto is not null AND (a.subSection.section.sectionID=1 OR a.subSection.section.sectionID=4) AND a.subSection.subSectionID not in (47,16) AND a.articleDate >= :articleDate ORDER BY a.articleID DESC")
		.setParameter("articleDate", cal.getTime() );
		fileName = "images.sh";
		return 0;
	}

}
