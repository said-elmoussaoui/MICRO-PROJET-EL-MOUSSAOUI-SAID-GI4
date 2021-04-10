package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Client {
	private int id;
	private String Email;
	private String nom;
	private  String prenom;
	private String Adresse;
	private int  CodePostal;
	private String ville;
	private String Tel;
	private String MotPasse;
	public Client() {
		super();
	}
	public Client(String email, String nom, String prenom, String adresse, int codePostal, String ville, String tel,
			String motPasse) {
		super();
		Email = email;
		this.nom = nom;
		this.prenom = prenom;
		Adresse = adresse;
		CodePostal = codePostal;
		this.ville = ville;
		Tel = tel;
		MotPasse = motPasse;
	}
	public Client(String Email,String MotPasse) {
		super();
		this.Email = Email;
		this.MotPasse = MotPasse;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public int getCodePostal() {
		return CodePostal;
	}
	public void setCodePostal(int codePostal) {
		CodePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getMotPasse() {
		return MotPasse;
	}
	public void setMotPasse(String motPasse) {
		MotPasse = motPasse;
	}
	public boolean inscrire() {
		ConnectionToDB con = null;
		boolean res = false;
		try {
			con = new ConnectionToDB();
			Statement st = con.getStatement();
			String sql = "insert into clients(Email,Nom,Prenom,Adresse,CodePostal,ville,Tel,MotPasse) values ('"+this.Email+"','"+this.nom+"','"+this.prenom+"','"+this.Adresse+"','"+this.CodePostal+"','"+this.ville+"','"+this.Tel+"','"+this.MotPasse+"');";
			st.executeUpdate(sql);
			res = true;
		}catch(SQLException er) {
			er.printStackTrace();
		}finally {
			if(con != null) con.close();
		}
		return res;
	}
	public boolean TestConnexion(String email,String password) {
		ConnectionToDB con = null;
		boolean res = false;
		try {
			con = new ConnectionToDB();
			Statement st = con.getStatement();
			String sql = "select * from clients where Email = '"+email+"' and MotPasse = '"+password+"'";
			ResultSet resu = st.executeQuery(sql);
			while(resu.next()) { res = true; }
		}catch(SQLException er) {
			er.printStackTrace();
		}finally {
			if(con != null) con.close();
		}
		return res;
	}
	public String GetNameOf(String email) {
		ConnectionToDB con = null;
		String res = "";
		try {
			con = new ConnectionToDB();
			Statement st = con.getStatement();
			String sql = "select nom,prenom from clients where Email = '"+email+"' ";
			ResultSet resu = st.executeQuery(sql);
			while(resu.next()) { 
				String nom = resu.getString("Nom");
				String prenom = resu.getString("prenom");
				res = nom +"  "+prenom;
			}
		}catch(SQLException er) {
			er.printStackTrace();
		}finally {
			if(con != null) con.close();
		}
		return res;
	}
	public void reduceArticles(int nbr,int idArt) {
		ConnectionToDB con = null;
		Article article = new Article();
		int nbrArt = article.showArticleById(idArt).getStock();
		try {
			con = new ConnectionToDB();
			Statement st = con.getStatement();
			String sql = "update  articles set stock = '"+(nbrArt-nbr)+"' where CodeArticle = '"+idArt+"'";
			st.executeUpdate(sql);
		}catch(SQLException er) {
			er.printStackTrace();
		}finally {
			if(con!=null) con.close();
		}
	}
	public void DemanderArticleAdjoint(int idCommande,int idArticle,int qte) {
		ConnectionToDB con = null;
		try {
			con = new ConnectionToDB();
			Statement st = con.getStatement();
			String sql1 = "insert into  lignecommandes values ('"+idCommande+"','"+idArticle+"','"+qte+"') ";
			st.executeUpdate(sql1);
		}catch(SQLException er) {
			er.printStackTrace();
		}finally {
			if(con != null) con.close();
		}
	}
	public int getNumComByIdClient(int idClient) {
		ConnectionToDB con = null;
		int retourner = 0;
		try {
			con = new ConnectionToDB();
			Statement st = con.getStatement();
			String sql11 = "select NumCommande from commandes where CodeClient = '"+idClient+"'";
			ResultSet resu = st.executeQuery(sql11);
			while(resu.next()) {
				retourner = resu.getInt("NumCommande");
			}
		}catch(SQLException er) {
			er.printStackTrace();
		}finally {
			if(con != null) con.close();
		}
		return retourner;
	}
	public boolean DemanderArticle(int idClient,int idArticle,int qte) {
		ConnectionToDB con = null;
		boolean resultat = false;
		try {
			con = new ConnectionToDB();
			Statement st = con.getStatement();
			Date date = new Date();
			String year = ""+date.getYear();
			String heur = ""+date.getHours();
			String min = ""+date.getMinutes();
			if(date.getMinutes()<10) min = "0"+date.getMinutes();
			if(date.getHours()<10)   heur = "0"+date.getHours();
			String dateDemande = date.getDate()+"/"+(date.getMonth()+1)+"/20"+year.substring(1,3)+"  "+heur+"::"+min;
			String sql = "insert into commandes (CodeClient,DateCommande) values ('"+idClient+"','"+dateDemande+"')";
			st.executeUpdate(sql);
			int NumCommande = getNumComByIdClient(idClient);
			DemanderArticleAdjoint(NumCommande, idArticle, qte);
			reduceArticles(qte,idArticle); 
			resultat = true;
		}catch(SQLException er) {
			er.printStackTrace();
		}finally {
			if(con != null) con.close();
		}
		return resultat;
	}
	public int getIdByEmail(String email) {
		ConnectionToDB con = null;
		int idClient = 0;
		try {
			con = new ConnectionToDB();
			Statement st =con.getStatement();
			String sql = "select id from clients where Email = '"+email+"' ";
			ResultSet resu = st.executeQuery(sql);
			while(resu.next()) {
				idClient = resu.getInt("id");
			}
		}catch(SQLException er) {
			er.printStackTrace();
		}finally {
			if(con != null) con.close();
		}
		return idClient;
	}
}
