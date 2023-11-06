package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import model.Contato;

public class ContatoDAO {
		
		private Connection conexao;

	    public ContatoDAO() {

	        try {

	            conexao = database.DatabaseConnection.conectar();

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }

	    }

	    public void criarContato(Contato contato) {

	        String sql = "INSERT INTO contato (nome, email, assunto, conteudo) VALUES (?, ?, ?, ?)";

	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

	            stmt.setString(1, contato.getNome());

	            stmt.setString(2, contato.getEmail());
	            
	            stmt.setString(3, contato.getAssunto());
	            
	            stmt.setString(4, contato.getConteudo());

	            stmt.executeUpdate();

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }
		
	}
	    
	    public Contato buscarContato(int id) {
	        Contato contato = null;
	        String sql = "SELECT * FROM contato WHERE id = ?";
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
	            stmt.setInt(1, id);
	            ResultSet resultado = stmt.executeQuery();
	            if (resultado.next()) {
	            	contato = new Contato();
	            	contato.setId(resultado.getInt("id"));
	            	contato.setNome(resultado.getString("nome"));
	            	contato.setEmail(resultado.getString("email"));
	            	contato.setAssunto(resultado.getString("assunto"));
	            	contato.setConteudo(resultado.getString("conteudo"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return contato;
	    }
		
	    public List<Contato> listarContatos() {

	        List<Contato> Contatos = new ArrayList<>();

	        String sql = "SELECT * FROM contato";

	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

	            ResultSet resultado = stmt.executeQuery();

	            while (resultado.next()) {

	                Contato contato = new Contato();

	                contato.setId(resultado.getInt("id"));

	                contato.setNome(resultado.getString("nome"));

	                contato.setEmail(resultado.getString("email"));
	                
	                contato.setAssunto(resultado.getString("assunto"));
	                
	                contato.setConteudo(resultado.getString("conteudo"));

	               Contatos.add(contato);

	            }

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }

	        return Contatos;

	    }
	    
	    public void excluirContato(int id) {

	        String sql = "DELETE FROM contato WHERE id = ?";

	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

	            stmt.setInt(1, id);

	            stmt.executeUpdate();

	        } catch (SQLException e) {

	            e.printStackTrace();

	        }

	    }
	    
	    public void atualizarContato(Contato contato) {

	        String sql = "UPDATE contato SET nome = ?, email = ?, assunto = ?, conteudo = ? WHERE id = ?";

	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

	            stmt.setString(1, contato.getNome());

	            stmt.setString(2, contato.getEmail());
	            
	            stmt.setString(3, contato.getAssunto());
	            
	            stmt.setString(4, contato.getConteudo());

	            stmt.setInt(5, contato.getId());

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

