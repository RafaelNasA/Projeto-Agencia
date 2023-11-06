package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoDAO;
import model.Destino;

@WebServlet("/CreateControllerDestino")
public class CreateControllerDestino extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Destino destino = new Destino();
		
		destino.setOrigem(req.getParameter("Origem"));
		destino.setDestino(req.getParameter("Destino"));
		destino.setDataIda(req.getParameter("Ida"));
		destino.setDataVolta(req.getParameter("Volta"));
		destino.setQtdQuartos(Integer.parseInt(req.getParameter("qtd quartos")));
		
		DestinoDAO destinoDAO = new DestinoDAO();
		destinoDAO.criarDestino(destino);
	}

}
