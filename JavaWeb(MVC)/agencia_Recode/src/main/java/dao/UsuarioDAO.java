package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import model.Usuario;

public class UsuarioDAO {
	private Connection conexao;
	

    public UsuarioDAO() {

        try {

            conexao = database.DatabaseConnection.conectar();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }
    
    public void criarUsuario(Usuario Usuario) {

        String sql = "INSERT INTO Usuario (nome, email) VALUES (?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, Usuario.getNome());

            stmt.setString(2, Usuario.getEmail());

            stmt.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
        }
     }
    
    public Usuario buscarUsuario(int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultado = stmt.executeQuery();
            if (resultado.next()) {
            	usuario = new Usuario();
            	usuario.setId(resultado.getInt("id"));
            	usuario.setNome(resultado.getString("nome"));
            	usuario.setEmail(resultado.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
    
    public List<Usuario> listarUsuarios() {

        List<Usuario> Usuarios = new ArrayList<>();

        String sql = "SELECT * FROM usuario";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {

                Usuario Usuario = new Usuario();

                Usuario.setId(resultado.getInt("id"));

                Usuario.setNome(resultado.getString("nome"));

                Usuario.setEmail(resultado.getString("email"));

               Usuarios.add(Usuario);

            }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return Usuarios;

    }
    
    public void excluirUsuario(int id) {

        String sql = "DELETE FROM usuario WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
    
    public void atualizarUsuario(Usuario Usuario) {

        String sql = "UPDATE usuario SET nome = ?, email = ? WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, Usuario.getNome());

            stmt.setString(2, Usuario.getEmail());

            stmt.setInt(3, Usuario.getId());

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
