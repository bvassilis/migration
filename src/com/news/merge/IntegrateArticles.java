package com.news.merge;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.escenic.xmlns.x2009.ximport.EscenicDocument;
import com.escenic.xmlns.x2009.ximport.EscenicDocument.Escenic.Version;
import com.news.Article;
import com.news.Articles_Archives100_130000;
import com.news.Articles_Archives80000;

public class IntegrateArticles {
	

	public static void main(String[] args) throws IOException, ParseException {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DownloadContraArticlesJPA");
		EntityManager em = emf.createEntityManager();

//		int imagesCounter = 0;
		int i = 0;
		int maxResults = 1000;

		Query q = em.createQuery("FROM Articles_Archives80000 order by articleID")
		.setFirstResult(i*maxResults)
		.setMaxResults(maxResults);
		List<Articles_Archives80000> results = q.getResultList();

		while (!results.isEmpty()) {
			for(Articles_Archives80000 aa : results){
				if(em.find(Article.class, aa.getArticleID())==null)
					em.persist(aa.toArticle());
			}
			
			q = em.createQuery("FROM Articles_Archives80000 order by articleID")
			.setFirstResult(i*maxResults)
			.setMaxResults(maxResults);
			results = q.getResultList();
		}
		
		
		/// 
		
		
		i = 0;
		maxResults = 1000;

		q = em.createQuery("FROM Articles_Archives100_130000 order by articleID")
		.setFirstResult(i*maxResults)
		.setMaxResults(maxResults);
		List<Articles_Archives100_130000> resultsAa = q.getResultList();

		while (!results.isEmpty()) {
			for(Articles_Archives100_130000 aa : resultsAa){
				if(em.find(Article.class, aa.getArticleID())==null)
					em.persist(aa.toArticle());
			}
			
			q = em.createQuery("FROM Articles_Archives100_130000 order by articleID")
			.setFirstResult(i*maxResults)
			.setMaxResults(maxResults);
			results = q.getResultList();
		}
	}

	private static void initializeEscenic(EscenicDocument escenicDocument) {
		escenicDocument.addNewEscenic();
		escenicDocument.getEscenic().setVersion(Version.X_2_0);
	}
	
}
