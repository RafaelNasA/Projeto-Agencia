package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDAO;
import model.Contato;



@WebServlet("/ReadControllerDestino")
public class ReadControllerContato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ContatoDAO cDAO = new ContatoDAO();
		List<Contato> contatos = cDAO.listarContatos();
		req.setAttribute("contatos", contatos);;
		
		RequestDispatcher rd = req.getRequestDispatcher("contatos.jsp");
		rd.forward(req, resp);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
