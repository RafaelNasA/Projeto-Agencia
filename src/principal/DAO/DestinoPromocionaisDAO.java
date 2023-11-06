package principal.DAO;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import principal.Conexao;
import principal.DestinoPromocionais;

public class DestinoPromocionaisDAO {
	
	private Connection conexao;
	UsuarioDAO usuarioDAO = new UsuarioDAO();

    public DestinoPromocionaisDAO() {

        try {

            conexao = Conexao.conectar();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
    
    public void criarDestinoPromocionais (DestinoPromocionais destinoPromocionais) {

        String sql = "INSERT INTO destinoPromocionais (usuario, origem, dataIda, dataVolta, qtdQuartos) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, destinoPromocionais.getId());

            //falta pegar id usuario (fk) aqui
            
            stmt.setString(3, destinoPromocionais.getOrigem());
            
            stmt.setString(4, destinoPromocionais.getDataIda());
            
            stmt.setString(5, destinoPromocionais.getDataVolta());
            
            stmt.setInt(6, destinoPromocionais.getQtdQuartos());

            stmt.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }
	
}
	
    public DestinoPromocionais buscarDestinoPromocionais(int id) {
        DestinoPromocionais destinoPromocionais = null;
        String sql = "SELECT * FROM destinoPromocionais WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
            	destinoPromocionais = new DestinoPromocionais();
            	destinoPromocionais.setId(resultado.getInt("id"));
            	destinoPromocionais.setUsuario(usuarioDAO.buscarUsuario(resultado.getInt("usuario_id")));
            	destinoPromocionais.setOrigem(resultado.getString("origem"));
            	destinoPromocionais.setDataIda(resultado.getString("Data_Ida"));
            	destinoPromocionais.setDataVolta(resultado.getString("Data_volta"));
            	destinoPromocionais.setQtdQuartos(resultado.getInt("qtd_quartos"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return destinoPromocionais;
    }
    
	public List<DestinoPromocionais> listarDestinoPromocionais() {

	        List<DestinoPromocionais> DestinoPromocionais = new ArrayList<>();

	        String sql = "SELECT * FROM destinoPromocionais";

	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

	            ResultSet resultado = stmt.executeQuery();

	            while (resultado.next()) {

	            	DestinoPromocionais destinoPromocionais = new DestinoPromocionais();

	            	destinoPromocionais.setId(resultado.getInt("id"));
	            	
	            	//aqui falta fk usuario

	            	destinoPromocionais.setOrigem(resultado.getString("Origem"));
	            	
	            	destinoPromocionais.setDataIda(resultado.getString("DataIda"));
	            	
	            	destinoPromocionais.setDataVolta(resultado.getString("DataVolta"));

	            	destinoPromocionais.setQtdQuartos(resultado.getInt("qtdQuartos"));

	            	DestinoPromocionais.add(destinoPromocionais);

	            }

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }

	        return DestinoPromocionais;

	    }
	    
	public void excluirDestinoPromocionais(int id) {

	        String sql = "DELETE FROM destinoPromocionais WHERE id = ?";

	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

	            stmt.setInt(1, id);

	            stmt.executeUpdate();

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }

	    }
	    
	public void atualizarDestinoPromocionais(DestinoPromocionais destinoPromocionais) {

	        String sql = "UPDATE destinoPromocionais SET origem = ?, dataIda = ?, dataVolta = ?, qtdQuartos WHERE id = ?";

	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

	            stmt.setInt(1, destinoPromocionais.getId());
	            
	            stmt.setString(2, destinoPromocionais.getOrigem());
	            
	            stmt.setString(3, destinoPromocionais.getDataIda());
	            
	            stmt.setString(4, destinoPromocionais.getDataVolta());

	            stmt.setInt(5, destinoPromocionais.getQtdQuartos());

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
