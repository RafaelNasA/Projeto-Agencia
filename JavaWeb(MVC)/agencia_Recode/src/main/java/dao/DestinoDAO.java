package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import model.Destino;
import dao.UsuarioDAO;

public class DestinoDAO {
	private Connection conexao;
	UsuarioDAO usuarioDAO = new UsuarioDAO();

    public DestinoDAO() {

        try {

            conexao = database.DatabaseConnection.conectar();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
    
    public void criarDestino (Destino destino) {

        String sql = "INSERT INTO destino ( origem, destino, dataIda, dataVolta, qtdQuartos) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, destino.getId());
            
            //stmt.setInt(2, destino.getUsuario().getId());

            stmt.setString(2, destino.getOrigem());
            
            stmt.setString(3, destino.getDestino());
            
            stmt.setString(4, destino.getDataIda());
            
            stmt.setString(5, destino.getDataVolta());
            
            stmt.setInt(6, destino.getQtdQuartos());

            stmt.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
    
    public Destino buscarDestino(int id) {
        Destino destino = null;
        String sql = "SELECT * FROM Destino WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
            	destino = new Destino();
            	destino.setId(resultado.getInt("id"));
            	//destino.setUsuario(usuarioDAO.buscarUsuario(resultado.getInt("usuario_id")));
            	destino.setOrigem(resultado.getString("origem"));
            	destino.setDestino(resultado.getString("destino"));
            	destino.setDataIda(resultado.getString("Data_Ida"));
            	destino.setDataVolta(resultado.getString("Data_volta"));
            	destino.setQtdQuartos(resultado.getInt("qtd_quartos"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return destino;
    }
    
	
	public List<Destino> listarDestinos() {

	        List<Destino> Destino = new ArrayList<>();

	        String sql = "SELECT * FROM destino";

	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

	            ResultSet resultado = stmt.executeQuery();

	            while (resultado.next()) {

	            	Destino destino = new Destino();

	            	destino.setId(resultado.getInt("id"));	            		       

	            	destino.setOrigem(resultado.getString("Origem"));
	            	
	            	destino.setDestino(resultado.getString("Destino"));
	            	
	            	destino.setDataIda(resultado.getString("DataIda"));
	            	
	            	destino.setDataVolta(resultado.getString("DataVolta"));

	            	destino.setQtdQuartos(resultado.getInt("qtdQuartos"));

	            	Destino.add(destino);

	            }

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }

	        return Destino;

	    }
	
	public void excluirDestino(int id) {

	        String sql = "DELETE FROM destino WHERE id = ?";

	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

	            stmt.setInt(1, id);

	            stmt.executeUpdate();

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }

	    }
	
	public void atualizarDestino(Destino destino) {

	        String sql = "UPDATE destino SET origem = ?, destino = ?, dataIda = ?, dataVolta = ?, qtdQuartos WHERE id = ?";

	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

	            stmt.setInt(1, destino.getId());
	      
	            stmt.setString(2, destino.getOrigem());
	            
	            stmt.setString(3, destino.getDestino());
	            
	            stmt.setString(4, destino.getDataIda());
	            
	            stmt.setString(5, destino.getDataVolta());

	            stmt.setInt(6, destino.getQtdQuartos());

	            stmt.executeUpdate();

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }

	    }
	    
	public void fecharConexao() {

			try {

				if (conexao != null && !conexao.isClosed()) {

					conexao.close();
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
}
