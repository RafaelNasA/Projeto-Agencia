package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDAO;


@WebServlet("/DeleteControllerContato")
public class DeleteControllerContato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		ContatoDAO cDAO = new ContatoDAO();
		
		cDAO.excluirContato(id);
		
		resp.sendRedirect("ReadControllerContato");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
