package com.crm.news.parsing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.crm.news.dto.NewsDTO;





public class NewsParsing {

	public List<String> getPages() {
		List<String> listUrl = new ArrayList<>();
		listUrl.add("https://anrex.info/sale/");
		try {
			Document document = Jsoup.connect("https://anrex.info/sale/").get();

			Elements elements = document.select(".nums").select(".dark_link");

			for (Element item : elements) {
				listUrl.add("https://anrex.info" + item.attr("href"));
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());

		} finally {

		}
		return listUrl;
	}

	@SuppressWarnings("finally")
	public List<NewsDTO> getNews(String url) {

		List<NewsDTO> dtos = new ArrayList<>();
		String title = null;
		String text = null;
		String pictureUrl = null;
		String infoUrl = null;

		try {
			Document document = Jsoup.connect(url).get();

			Elements elements = document.select(".item");

			for (Element item : elements) {

				title = item.select(".body-info").select("a").first().text();
				text = item.select(".previewtext").first().text();
				pictureUrl = "https://anrex.info" + item.select("img").first().attr("src");
				infoUrl = "https://anrex.info"
						+ item.select(".body-info").select(".link-block-more").select("a").first().attr("href");

				dtos.add(new NewsDTO(title, text, pictureUrl, infoUrl));

			}
			return dtos;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return dtos;
		} finally {
			return dtos;
		}

	}

}