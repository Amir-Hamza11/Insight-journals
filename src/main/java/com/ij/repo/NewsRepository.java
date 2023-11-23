package com.ij.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ij.entity.News;

public interface NewsRepository extends JpaRepository<News, Long> {

	public List<News> findByCategory(String category);
	
}
