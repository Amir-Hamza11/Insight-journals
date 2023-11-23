package com.ij.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ij.entity.News;
import com.ij.repo.NewsRepository;

@Service
public class NewsService {

	@Autowired
	private NewsRepository newsRepository;

	// SAVE DATA:

	public News postNews(News news) {
		return newsRepository.save(news);
	}

	// GET DATA:

	public List<News> getAllNews() {

		return newsRepository.findAll();
	}

	public News getNews(Long id) {

		return newsRepository.findById(id).orElse(null);
	}
	
	public List <News> getNewsByCategory(String category) {

		return newsRepository.findByCategory(category);
	}


	// DELETE DATA:
	public void deleteNews(Long id) {

		newsRepository.deleteById(id);
	}
	
	//UPDATE CUSTOMER:
	
	public News updateNews(Long id, News news) {
		
		Optional<News> optionalNews = newsRepository.findById(id);
		
		if(optionalNews.isPresent()) {
			News existingCustomer = optionalNews.get();
			existingCustomer.setImage(news.getImage());
			existingCustomer.setDate(news.getDate());
			existingCustomer.setHeadline(news.getHeadline());
			existingCustomer.setContent(news.getContent());
			existingCustomer.setCategory(news.getCategory());
			
			return newsRepository.save(existingCustomer);
		}
		
		return null;
	}
	
	
	
	

}
