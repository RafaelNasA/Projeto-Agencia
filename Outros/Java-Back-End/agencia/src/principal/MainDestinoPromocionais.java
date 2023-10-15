package principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import principal.DAO.DestinoPromocionaisDAO;

public class MainDestinoPromocionais {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DestinoPromocionaisDAO destinoPromocionalDAO = new DestinoPromocionaisDAO();
		
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
                	DestinoPromocionais destinoPromocional = new DestinoPromocionais();
                	
                	System.out.print("De onde você está saindo: ");
                    input.nextLine(); 
                    destinoPromocional.setOrigem(input.nextLine());                	        
                    
                    System.out.print("Data de ida: ");
                    input.nextLine();
                    destinoPromocional.setDataIda(input.nextLine());
                    
                    System.out.print("Data de volta: ");
                    input.nextLine();
                    destinoPromocional.setDataVolta(input.nextLine());
                    
                    System.out.print("Quantidade de quartos: ");
                    input.nextInt();
                    destinoPromocional.setQtdQuartos(input.nextInt());
                    
                    destinoPromocionalDAO.criarDestinoPromocionais(destinoPromocional);
                    System.out.println("Destino cadastrado com sucesso!");
                    break;
                    
                case 2:
                    // Listar Destino
                    List<DestinoPromocionais> destinosPromocional = destinoPromocionalDAO.listarDestinoPromocionais();
                    System.out.println("Sua lista de destinos:");
                    for (DestinoPromocionais m : destinosPromocional) {
                        System.out.println("ID: " + m.getId() +
                                
                                ", Destino desejado: " + m.getOrigem()+
                                ", Data de ida: " + m.getDataIda()+
                                ", Data de volta: " + m.getDataVolta()+
                                ", Quantidade de quartos: " + m.getQtdQuartos());
                    }
                    break;
                    
                case 3:
                	 // Atualizar Destino
                    System.out.print("ID do destino para atualização: ");
                    int destidoId = input.nextInt();
                    DestinoPromocionais destinoPromocionaisAtualizar = destinoPromocionalDAO.buscarDestinoPromocionais(destidoId);
                    
                    if (destinoPromocionaisAtualizar != null) {
                        System.out.print("De onde você está saindo: ");
                        String novaOrigemString = input.next();                        
                        
                        System.out.print("Nova data de ida: ");
                        String novaDataIdaString = input.next();
                        
                        System.out.print("Nova data de volta: ");
                        String novaDataVoltaString = input.next();
                        
                        System.out.print("Nova quantidade de quartos: ");
                        Integer novaQtdQuartosInt = input.nextInt();
                        
                                              
                        destinoPromocionaisAtualizar.setOrigem(novaOrigemString);
                        destinoPromocionalDAO.atualizarDestinoPromocionais(destinoPromocionaisAtualizar);                                         
                        
                        destinoPromocionaisAtualizar.setDataIda(novaDataIdaString);
                        destinoPromocionalDAO.atualizarDestinoPromocionais(destinoPromocionaisAtualizar);
                        
                        destinoPromocionaisAtualizar.setDataVolta(novaDataVoltaString);
                        destinoPromocionalDAO.atualizarDestinoPromocionais(destinoPromocionaisAtualizar);
                        
                        destinoPromocionaisAtualizar.setQtdQuartos(novaQtdQuartosInt);
                        destinoPromocionalDAO.atualizarDestinoPromocionais(destinoPromocionaisAtualizar);
                       
                        
                    } else {
                        System.out.println("Destino não encontrada.");
                    }
                    break;
                	
                case 4:
                	  // Excluir Destino
                    System.out.print("Informe o ID do destino para exclusão: ");
                    int DestinoIdExcluir = input.nextInt();
                    DestinoPromocionais DestinoExcluir = destinoPromocionalDAO.buscarDestinoPromocionais(DestinoIdExcluir);
                    if (DestinoExcluir != null) {
                        destinoPromocionalDAO.excluirDestinoPromocionais(DestinoIdExcluir);;
                        System.out.println("Destino excluído com sucesso!");
                    } else {
                        System.out.println("Destino não encontrado.");
                    }
                    break;
                case 5:
                	  // Sair
                    System.out.println("Finalizando...");
                    System.out.println("Até a próxima.");
                    destinoPromocionalDAO.fecharConexao();
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }


}
