package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import principal.DAO.UsuarioDAO;

public class MainUsuario {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		UsuarioDAO UsuarioDAO = new UsuarioDAO();
		
		System.out.println("\n Bem-vindo(a) ao Sistema de Gestão de Usuarios.");

        while (true) {
            
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("1. Cadastrar Usuario");
            System.out.println("2. Listar Usuarios");
            System.out.println("3. Atualizar Usuario");
            System.out.println("4. Excluir Usuario");
            System.out.println("5. Finalizar.");
            System.out.print("Digite aqui sua opção: ");

            int opcao = input.nextInt();

            switch (opcao) {
            
                case 1:
                    // Cadastrar Usuario
                	Usuario usuario = new Usuario();
                	
                    System.out.print("Nome do Usuario: ");
                    input.nextLine(); 
                    usuario.setNome(input.nextLine());
                    
                    System.out.print("Email: ");
                    usuario.setEmail(input.nextLine());
                    
                    UsuarioDAO.criarUsuario(usuario);
                    System.out.println("Usuario cadastrado com sucesso!");
                    break;
                    
                case 2:
                    // Listar Usuario
                    List<Usuario> usuarios = UsuarioDAO.listarUsuarios();
                    System.out.println("Lista de Usuarios:");
                    for (Usuario m : usuarios) {
                        System.out.println("ID: " + m.getId() +
                                ", Nome: " + m.getNome() +
                                ", Email: " + m.getEmail());
                    }
                    break;
                    
                case 3:
                	 // Atualizar Usuario
                    System.out.print("ID do usuario para atualização: ");
                    int usuarioId = input.nextInt();
                    Usuario usuarioAtualizar = UsuarioDAO.buscarUsuario(usuarioId);
                    
                    if (usuarioAtualizar != null) {
                        System.out.print("Novo nome de usuario: ");
                        String novoNomeString = input.next();
                        
                        System.out.print("Novo Email de usuario: ");
                        String novoEmailString = input.next();
                        
                        usuarioAtualizar.setNome(novoNomeString);
                        UsuarioDAO.atualizarUsuario(usuarioAtualizar);
                        
                        usuarioAtualizar.setEmail(novoEmailString);
                        UsuarioDAO.atualizarUsuario(usuarioAtualizar);
                        
                    } else {
                        System.out.println("Usuario não encontrada.");
                    }
                    break;
                	
                case 4:
                	  // Excluir Usuario
                    System.out.print("Informe o ID do usuario para exclusão: ");
                    int UsuarioIdExcluir = input.nextInt();
                    Usuario UsuarioExcluir = UsuarioDAO.buscarUsuario(UsuarioIdExcluir);
                    if (UsuarioExcluir != null) {
                        UsuarioDAO.excluirUsuario(UsuarioIdExcluir);
                        System.out.println("Usuario excluído com sucesso!");
                    } else {
                        System.out.println("Usuario não encontrada.");
                    }
                    break;
                case 5:
                	  // Sair
                    System.out.println("Finalizando...");
                    System.out.println("Até a próxima.");
                    UsuarioDAO.fecharConexao();
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
		
}


