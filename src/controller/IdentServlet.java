package controller;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Model.Client;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
@WebServlet (name="IdentServlet" , urlPatterns= {"/Identifier"})
public class IdentServlet extends HttpServlet{
	private Client client ;
	@Override
	public void init() throws ServletException{
		client = new Client();
	}
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String regEmail = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		HttpSession session = request.getSession();
		String nom = client.GetNameOf(email);
		int idClient = client.getIdByEmail(email);
		session.setAttribute("Name", nom);
		session.setAttribute("email", email);
		session.setAttribute("id", idClient);
		if(email.trim().isEmpty() || passwd.trim().isEmpty()) {
				String msg = "l'un des champs obligatoire est vide !!";
				request.setAttribute("message", msg);
				request.getRequestDispatcher("Identifier.jsp").forward(request, response);
		}else if(!email.matches(regEmail)) {
			String msg = "email invalide";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("Identifier.jsp").forward(request, response);
		}else {
			boolean resultat = client.TestConnexion(email,passwd);
			if(resultat == true) {
				
				request.getRequestDispatcher("HelloPage.jsp").forward(request, response);
			}else {
				String msg = "les informations sont invalide !!";
				request.setAttribute("message", msg);
				request.getRequestDispatcher("Identifier.jsp").forward(request, response);
			}
		}
	}
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
