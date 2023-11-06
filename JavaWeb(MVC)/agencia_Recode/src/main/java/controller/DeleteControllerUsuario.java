package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;

@WebServlet("/DeleteControllerUsuario")
public class DeleteControllerUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		UsuarioDAO uDAO = new UsuarioDAO();
		uDAO.excluirUsuario(id);
		
		resp.sendRedirect("ReadControllerUsuario");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
