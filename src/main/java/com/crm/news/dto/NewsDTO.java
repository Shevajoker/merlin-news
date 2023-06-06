package com.crm.news.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsDTO {

	private String title;
	private String text;
	private String pictureUrl;
	private String infoUrl;
	
}
