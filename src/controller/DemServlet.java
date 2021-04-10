package controller;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Client;
import Model.Article;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
@WebServlet (name="DemServlet" , urlPatterns= {"/demandeArticle"})
public class DemServlet extends HttpServlet{
	private Article article ;
	@Override
	public void init() throws ServletException{
		article = new Article();
	}
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		String qte = request.getParameter("qte");
		String email = request.getParameter("email");
		int stock = Integer.parseInt(request.getParameter("stock"));
		int idArticle = Integer.parseInt(request.getParameter("idArt"));
		Client cl = new Client();
		int idClient = cl.getIdByEmail(email) ;
		String regQte = "^[0-9]+";
		Article articleDt = article.showArticleById(idArticle);
		if(stock<Integer.parseInt(qte)) {
			 articleDt.setMessage("le nombre d'articles insuffisant.");
		}else if(qte.trim().isEmpty() || !qte.matches(regQte)) {
			articleDt.setMessage("les infromation invalide");
		}else {
			Client client = new Client();
			if(client.DemanderArticle(idClient, idArticle,Integer.parseInt(qte))) articleDt.setMessage("<p style='color:green'>la demande est bien energistrer.</p>");
			else  articleDt.setMessage("erreur de connexion");
		}
		request.setAttribute("articleDet", articleDt);
		request.getRequestDispatcher("Detaills.jsp").forward(request, response);
	}
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
