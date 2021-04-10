package Model;

import java.util.ArrayList;
import java.util.List;

public class articlesMod {
	private String genre;
	private List<Article> articles = new ArrayList<Article>();
	private List<String> categories = new ArrayList<String>();
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public List<String> getCategories(){
		return categories;
	}
	
}
