package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDAO;
import model.Usuario;


@WebServlet("/ReadControllerUsuario")
public class ReadControllerUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UsuarioDAO uDAO = new UsuarioDAO();
		
		List<Usuario> usuario = uDAO.listarUsuarios();
		
		req.setAttribute("usuario", usuario);
		
		RequestDispatcher rd = req.getRequestDispatcher("usuarios.jsp");
		rd.forward(req, resp);

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
