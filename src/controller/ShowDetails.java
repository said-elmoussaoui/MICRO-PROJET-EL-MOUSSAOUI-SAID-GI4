package controller;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Article;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
@WebServlet (name="ShowDetails" , urlPatterns= {"/Details"})
public class ShowDetails extends HttpServlet{
	private Article article ;
	@Override
	public void init() throws ServletException{
		article = new Article();
	}
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		int idArt = Integer.parseInt(request.getParameter("toDeta")); 
		Article articleDt = article.showArticleById(idArt);
		request.setAttribute("articleDet", articleDt);
		request.getRequestDispatcher("Detaills.jsp").forward(request, response);
	}
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
