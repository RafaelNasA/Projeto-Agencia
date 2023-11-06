package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;


@WebServlet("/UpdateControllerUsuario")
public class UpdateControllerUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		UsuarioDAO uDAO = new UsuarioDAO();
		Usuario usuario = uDAO.buscarUsuario(id);
		
		req.setAttribute("usuario", usuario);
		
		RequestDispatcher rd = req.getRequestDispatcher("atualizarUsuario.jsp");
		rd.forward(req, resp);
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		usuario.setId(Integer.parseInt(req.getParameter("id")));
		usuario.setNome(req.getParameter("nome"));
		usuario.setEmail(req.getParameter("email"));
		
		UsuarioDAO uDAO = new UsuarioDAO();
		uDAO.atualizarUsuario(usuario);
		
		res.sendRedirect("ReadControllerUsuario");
		
	}

}
