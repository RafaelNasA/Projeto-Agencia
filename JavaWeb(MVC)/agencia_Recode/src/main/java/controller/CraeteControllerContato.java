package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContatoDAO;
import model.Contato;


@WebServlet("/CraeteControllerContato")
public class CraeteControllerContato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Contato contato = new Contato();
		
		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setAssunto(req.getParameter("assunto"));
		contato.setConteudo(req.getParameter("conteudo"));
		
		
			ContatoDAO contatoDAO = new ContatoDAO();
			contatoDAO.criarContato(contato);
			
			resp.sendRedirect("ReadControllerContato");
		}
	}


