package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;

@WebServlet("/CreaterControllerUsuario")
public class CreaterControllerUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Usuario usuario = new Usuario();
		usuario.setNome(req.getParameter("nome"));
		usuario.setEmail(req.getParameter("email"));
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
				usuarioDAO.criarUsuario(usuario);
		
				resp.sendRedirect("ReadControllerUsuario");
	}

}
