package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDAO;
import model.Contato;


@WebServlet("/UpdateControllerDestino")
public class UpdateControllerContato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		ContatoDAO cDAO = new ContatoDAO();
		Contato contato = cDAO.buscarContato(id);
		
		req.setAttribute("contato", contato);;
		
		RequestDispatcher rd = req.getRequestDispatcher("atualizarContato.jsp");
		rd.forward(req, resp);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Contato contato = new Contato();
		
		contato.setId(Integer.parseInt(req.getParameter("Id")));
		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setAssunto(req.getParameter("assunto"));
		contato.setConteudo(req.getParameter("conteudo"));
		
		ContatoDAO cDAO = new ContatoDAO();
		cDAO.atualizarContato(contato);
		
		res.sendRedirect("ReadControllerContato");
	
	}

}


