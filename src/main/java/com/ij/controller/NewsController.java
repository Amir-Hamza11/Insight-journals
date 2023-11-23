package com.ij.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ij.entity.News;
import com.ij.service.NewsService;

@RestController
@RequestMapping("/news")
@CrossOrigin("*")
public class NewsController {

	@Autowired
	private NewsService newsService;

	@PostMapping("/add")
	public News postNews(@RequestBody News news) {
		return newsService.postNews(news);
	}

	
	@GetMapping("/get-all")
	public List<News> getAllCustomer() {

		return newsService.getAllNews();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Long> deleteCustomer(@PathVariable Long id)
	{
		 newsService.deleteNews(id);
		
		 return ResponseEntity.ok(id);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<News> getCustomerById(@PathVariable Long id)
	{
		News news = newsService.getNews(id);
		
		if(news == null)
		{
			return ResponseEntity.notFound().build();
		}
		else
			return ResponseEntity.ok(news);
	}
	
	@GetMapping("/category/{category}")
	public List<News> getNewsByCategory(@PathVariable String category)
	{
		return newsService.getNewsByCategory(category);
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<News> updateCustomer(@PathVariable Long id, @RequestBody News news)
	{
		News  updateNews = newsService.updateNews(id, news);
		
		if(updateNews == null)
		{
			return ResponseEntity.notFound().build();
		}
		else
			return ResponseEntity.ok(updateNews);
	}
}
