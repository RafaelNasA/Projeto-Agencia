package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DestinoPromocionaisDAO;
import model.DestinoPromocionais;

@WebServlet("/CreateControllerDestinoPromocionais")
public class CreateControllerDestinoPromocionais extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		DestinoPromocionais destinoPromocional = new DestinoPromocionais();
		
		destinoPromocional.setOrigem(req.getParameter("Origem"));
		destinoPromocional.setDataIda(req.getParameter("Ida"));
		destinoPromocional.setDataVolta(req.getParameter("Volta"));
		destinoPromocional.setQtdQuartos(Integer.parseInt(req.getParameter("qtd quartos")));
		
		DestinoPromocionaisDAO destinoPromocionaisDAO = new DestinoPromocionaisDAO();
		destinoPromocionaisDAO.criarDestinoPromocionais(destinoPromocional);
		
	}

}
