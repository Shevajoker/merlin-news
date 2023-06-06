package com.crm.news.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.news.dto.NewsDTO;
import com.crm.news.parsing.NewsParsing;




@RestController
@RequestMapping("/api/v1")
public class NewsController {

	
	@GetMapping("/news")
	public List<NewsDTO> getNews(){ 
		
		NewsParsing newsParsing = new NewsParsing();
		
		List<String> listUrl = newsParsing.getPages();
		List<NewsDTO> dtos = new ArrayList<>();
		for (String items : listUrl) {
			dtos.addAll(newsParsing.getNews(items));
		}
		
		
		
		return dtos;
	}
}
