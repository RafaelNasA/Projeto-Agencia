package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import principal.DAO.ContatoDAO;

public class MainContato {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ContatoDAO contatoDAO = new ContatoDAO();
		
		System.out.println("\n Bem-vindo(a) ao Sistema de Gestão de Contatos.");

        while (true) {
            
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("1. Preencher Contato");
            System.out.println("2. Listar todos os contatos feitos");
            System.out.println("3. Editar algum contato feito");
            System.out.println("4. Excluir algum contato feito");
            System.out.println("5. Finalizar.");
            System.out.print("Digite aqui sua opção: ");

            int opcao = input.nextInt();

            switch (opcao) {
            
                case 1:
                    // Preencher contato
                	Contato contato = new Contato();
                	
                    System.out.print("Nome: ");
                    input.nextLine(); 
                    contato.setNome(input.nextLine());
       
                    
                    System.out.print("Email: ");
                    contato.setEmail(input.nextLine());
                   
                    
                    System.out.print("Assunto: ");
                    input.nextLine(); 
                    contato.setAssunto(input.nextLine());
                    
                    System.out.print("Conteudo: ");
                    contato.setConteudo(input.nextLine());
                    
                    contatoDAO.criarContato(contato);                                    
                    System.out.println("Contato cadastrado com sucesso!");
                    break;
                    
                case 2:
                    // Listar contatos
                    List<Contato> contatos = contatoDAO.listarContatos();
                    System.out.println("Lista de contatos feitos:");
                    for (Contato m : contatos) {
                        System.out.println("ID: " + m.getId() +
                                ", Nome: " + m.getNome() +
                                ", Email: " + m.getEmail()+
                                ", Assunto: " + m.getAssunto()+
                                ", Conteudo: " + m.getConteudo());
                    }
                    break;
                    
                case 3:
                	 // Atualizar contato
                    System.out.print("ID do contato para atualização: ");
                    int contatoId = input.nextInt();
                    Contato contatoAtualizar = contatoDAO.buscarContato(contatoId);
                    
                    if (contatoAtualizar != null) {
                        System.out.print("Nome: ");
                        String novoNomeString = input.next();
                        
                        contatoAtualizar.setNome(novoNomeString);
                        contatoDAO.atualizarContato(contatoAtualizar);
                        
                        System.out.print("E-mail: ");
                        String novoEmailString = input.next();
                        
                        contatoAtualizar.setEmail(novoEmailString);
                        contatoDAO.atualizarContato(contatoAtualizar);
                        
                        System.out.print("Assunto: ");
                        String novoAssuntoString = input.next();
                        
                        contatoAtualizar.setAssunto(novoAssuntoString);
                        contatoDAO.atualizarContato(contatoAtualizar);
                        
                        System.out.print("Conteudo: ");
                        String novoConteudoString = input.next();
                        
                        contatoAtualizar.setConteudo(novoConteudoString);
                        contatoDAO.atualizarContato(contatoAtualizar);
                        
                                                                     
                    } else {
                        System.out.println("Usuario não encontrada.");
                    }
                    break;
                	
                case 4:
                	  // Excluir contato
                	
                    System.out.print("Informe o ID do contato: ");
                    int contatoIdExcluir = input.nextInt();
                    
                    Contato ExcluirContato = contatoDAO.buscarContato(contatoIdExcluir);
                    
                    if (ExcluirContato != null) {
                        contatoDAO.excluirContato(contatoIdExcluir);
                        System.out.println("Usuario excluído com sucesso!");
                    } else {
                        System.out.println("Usuario não encontrada.");
                    }
                    break;
                    
                case 5:
                	  // Sair
                    System.out.println("Finalizando...");
                    System.out.println("Até a próxima.");
                    contatoDAO.fecharConexao();
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

	}

}
