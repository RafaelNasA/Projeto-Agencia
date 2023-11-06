package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import principal.DAO.DestinoDAO;


public class MainDestino {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		DestinoDAO destinoDAO = new DestinoDAO();
		
		System.out.println("\n Bem-vindo(a) ao Sistema de Gestão de Destinos.");

        while (true) {
            
            System.out.println("Escolha uma das opções abaixo:");
            System.out.println("1. Cadastrar Destino");
            System.out.println("2. Listar Destinos");
            System.out.println("3. Atualizar Destino");
            System.out.println("4. Excluir Destino");
            System.out.println("5. Finalizar.");
            System.out.print("Digite sua opção: ");

            int opcao = input.nextInt();

            switch (opcao) {
            
                case 1:
                    // Cadastrar Destino
                	Destino destino = new Destino();
                	
                	System.out.print("De onde você está saindo: ");
                    input.nextLine(); 
                    destino.setOrigem(input.nextLine());
                	
                    System.out.print("Qual destino desejado: ");
                    input.nextLine(); 
                    destino.setDestino(input.nextLine()); 
                    
                    System.out.print("Data de ida: ");
                    input.nextLine();
                    destino.setDataIda(input.nextLine());
                    
                    System.out.print("Data de volta: ");
                    input.nextLine();
                    destino.setDataVolta(input.nextLine());
                    
                    System.out.print("Quantidade de quartos: ");
                    input.nextInt();
                    destino.setQtdQuartos(input.nextInt());
                    
                    destinoDAO.criarDestino(destino);
                    System.out.println("Destino cadastrado com sucesso!");
                    break;
                    
                case 2:
                    // Listar Destino
                    List<Destino> destinos = destinoDAO.listarDestinos();
                    System.out.println("Sua lista de destinos:");
                    for (Destino m : destinos) {
                        System.out.println("ID: " + m.getId() +
                                ", Local de partida: " + m.getOrigem() +
                                ", Destino desejado: " + m.getDestino()+
                                ", Data de ida: " + m.getDataIda()+
                                ", Data de volta: " + m.getDataVolta()+
                                ", Quantidade de quartos: " + m.getQtdQuartos());
                    }
                    break;
                    
                case 3:
                	 // Atualizar Destino
                    System.out.print("ID do destino para atualização: ");
                    int destidoId = input.nextInt();
                    Destino destinoAtualizar = destinoDAO.buscarDestino(destidoId);
                    
                    if (destinoAtualizar != null) {
                        System.out.print("De onde você está saindo: ");
                        String novaOrigemString = input.next();
                        
                        System.out.print("Novo destino: ");
                        String novoDestinoString = input.next();
                        
                        System.out.print("Nova data de ida: ");
                        String novaDataIdaString = input.next();
                        
                        System.out.print("Nova data de volta: ");
                        String novaDataVoltaString = input.next();
                        
                        System.out.print("Nova quantidade de quartos: ");
                        Integer novaQtdQuartosInt = input.nextInt();
                        
                                              
                        destinoAtualizar.setOrigem(novaOrigemString);
                        destinoDAO.atualizarDestino(destinoAtualizar);
                        
                        destinoAtualizar.setDestino(novoDestinoString);
                        destinoDAO.atualizarDestino(destinoAtualizar);
                        
                        destinoAtualizar.setDataIda(novaDataIdaString);
                        destinoDAO.atualizarDestino(destinoAtualizar);
                        
                        destinoAtualizar.setDataVolta(novaDataVoltaString);
                        destinoDAO.atualizarDestino(destinoAtualizar);
                        
                        destinoAtualizar.setQtdQuartos(novaQtdQuartosInt);
                        destinoDAO.atualizarDestino(destinoAtualizar);
                       
                        
                    } else {
                        System.out.println("Destino não encontrada.");
                    }
                    break;
                	
                case 4:
                	  // Excluir Destino
                    System.out.print("Informe o ID do destino para exclusão: ");
                    int DestinoIdExcluir = input.nextInt();
                    Destino DestinoExcluir = destinoDAO.buscarDestino(DestinoIdExcluir);
                    if (DestinoExcluir != null) {
                        destinoDAO.excluirDestino(DestinoIdExcluir);
                        System.out.println("Destino excluído com sucesso!");
                    } else {
                        System.out.println("Destino não encontrado.");
                    }
                    break;
                case 5:
                	  // Sair
                    System.out.println("Finalizando...");
                    System.out.println("Até a próxima.");
                    destinoDAO.fecharConexao();
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

}
