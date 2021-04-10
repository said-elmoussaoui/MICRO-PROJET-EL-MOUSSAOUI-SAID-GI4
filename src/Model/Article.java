package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Article {
	private int id;
	private String titre;
	private double prix;
	private int stock;
	private String categorie;
	private String photo;
	private String auteur;
	private String message;
	public Article() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Article(String titre, double prix, int stock, String categorie, String photo,String auteur) {
		super();
		this.titre = titre;
		this.prix = prix;
		this.stock = stock;
		this.categorie = categorie;
		this.photo = photo;
		this.auteur = auteur;
	}
	
	public Article(int id, String titre, double prix, int stock, String categorie, String photo,String auteur) {
		super();
		this.id = id;
		this.titre = titre;
		this.prix = prix;
		this.stock = stock;
		this.categorie = categorie;
		this.photo = photo;
		this.auteur = auteur;
	}
	public Article(int id, String titre, double prix, int stock, String categorie, String photo,String auteur,String message) {
		super();
		this.id = id;
		this.titre = titre;
		this.prix = prix;
		this.stock = stock;
		this.categorie = categorie;
		this.photo = photo;
		this.auteur = auteur;
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Article> showArticle(String genre){
		List<Article> articles = new ArrayList<Article>();
		ConnectionToDB con = null;
		try {
			con = new ConnectionToDB();
			Statement st = con.getStatement();
			String sql = "select * from Articles where Categorie = '"+genre+"'";
			ResultSet  resu = st.executeQuery(sql);
			while(resu.next()) {
				Article article = new Article(resu.getInt("CodeArticle"),resu.getString("titre"),resu.getFloat("prix"),resu.getInt("stock"),resu.getString("Categorie"),resu.getString("photo"),resu.getString("auteur"));
				if(article.getStock() != 0) articles.add(article);
			}
		}catch(SQLException er) {
			er.printStackTrace();
		}finally {
			if(con!=null) con.close();
		}
		return articles;
	}
	public List<Article> showAllArticle(){
		List<Article> articles = new ArrayList<Article>();
		ConnectionToDB con = null;
		try {
			con = new ConnectionToDB();
			Statement st = con.getStatement();
			String sql = "select * from Articles";
			ResultSet  resu = st.executeQuery(sql);
			while(resu.next()) {
				Article article = new Article(resu.getString("titre"),resu.getFloat("prix"),resu.getInt("stock"),resu.getString("Categorie"),resu.getString("photo"),resu.getString("auteur"));
				articles.add(article);
			}
		}catch(SQLException er) {
			er.printStackTrace();
		}finally {
			if(con!=null) con.close();
		}
		return articles;
			
		}
	public Article showArticleById(int id) {
		Article article = null;
		ConnectionToDB con = null;
		try {
			con = new ConnectionToDB();
			Statement st = con.getStatement();
			String sql = "select * from articles where CodeArticle= '"+id+"'";
			ResultSet resu = st.executeQuery(sql);
			while(resu.next()) {
				article = new Article(resu.getInt("CodeArticle"),resu.getString("titre"),resu.getDouble("prix"),resu.getInt("stock"),resu.getString("Categorie"),resu.getString("photo"),resu.getString("auteur"),"");
			}
		}catch(SQLException er) {
			er.printStackTrace();
		}finally {
			if(con!=null) con.close();
		}
		return article;
	}
	public List<String> showAllCat() {
		List<String> categories = new ArrayList<String>();
		ConnectionToDB con = null;
		try {
			con = new ConnectionToDB();
			Statement st = con.getStatement();
			String sql = "select DISTINCT Categorie from articles";
			ResultSet resu = st.executeQuery(sql);
			while(resu.next()) {
				 categories.add(resu.getString("Categorie"));
			}
		}catch(SQLException er) {
			er.printStackTrace();
		}finally {
			if(con!=null) con.close();
		}
		return categories;
	}
}
