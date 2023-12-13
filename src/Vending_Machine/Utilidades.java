package Vending_Machine;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Utilidades {
	
	
	public static void criarItems(ArrayList<Produtos> items) {
		System.out.println("Criando items...\n");
		for (int i = 1; i < 11; i++) {
			int codigo = i;
			String produto = "";
			Double preco = 0.0;
			int quantidade = 0;
			
			Produtos item = new Produtos(codigo, produto, preco, quantidade);
			items.add(item);
			
		}
	}
	
	
	public static void lerCSV(ArrayList<Produtos> items) {
	       
        String fileName = "vendingMachine.csv";
       
        try {
            FileReader fileReader = new FileReader(fileName);
            Scanner scnobj = new Scanner(fileReader);
            
            if (scnobj.hasNextLine()) {
            	scnobj.nextLine();
            }
            System.out.println("Lendo CSV...\n");
            while (scnobj.hasNextLine()) {
                String linha = scnobj.nextLine();
         
                String [] objetos = linha.split(",");
         
                int codigo = Integer.parseInt(objetos[0]);
               
                String produto = (objetos[1]);
                
                double preco = Double.parseDouble(objetos[2]);
                
                int quantidade = Integer.parseInt(objetos[3]);
                
                Produtos item = new Produtos(codigo, produto, preco, quantidade);
           
                items.add(item);
            }	       
            scnobj.close();
            fileReader.close();
            
        } catch (Exception e) {
        	Utilidades.criarItems(items);
        }
	}
	
	
	public static void listarItems(ArrayList<Produtos> items) {
		
		 String lista_items = "Código\t\tProduto\t\t\tPreço - R$\tQuantidade\n";
		 for(Produtos item : items) {
			 lista_items += item.getCodigo()+"\t\t"+item.getProduto()+"\t\t\t"+item.getPreco()+"\t\t"+item.getQuantidade()+"\n";
		 }
		 
		 System.out.println(lista_items);
	}
	
	
	public static void deletarItem(ArrayList<Produtos> items) {
		Scanner scn = new Scanner(System.in);
		Scanner scn2 = new Scanner(System.in);
		
		System.out.println("Digite o código do produto que deseja deletar: ");
		 int selecionar_item = scn2.nextInt();
		 
		 for(Produtos item : items) {
			 if(item.getCodigo() == selecionar_item) {
				 mostrarItem(item);
			
			 System.out.println("<S> - para excluir este item");
			 String confirmacao = scn.nextLine();
			 
			 if(confirmacao.equalsIgnoreCase("s")) {
				 item.setProduto(" ");
				 item.setPreco(0);
				 item.setQuantidade(0);
				 
				 System.out.println("Item deletado!");
				 
			 }
			 }	 
		 }
	}
	
	
	public static void resetarVending(ArrayList<Produtos> items) {
		for(Produtos item : items) {
			 item.setProduto(" ");
			 item.setPreco(0);
			 item.setQuantidade(0);
		}
		 System.out.println("Vending Machine resetada com sucesso!");
	}

	
	public static void salvarCSV(ArrayList<Produtos> items) {
		String arquivoCSV = "vendingMachine.csv";

        try (FileWriter writer = new FileWriter(arquivoCSV, false)) {
            
            writer.append("Código,Produto,Preço,Quantidade\n");
            		
            for (Produtos item : items) {
                writer.append(String.valueOf(item.getCodigo()))
                      .append(",")
                      .append(item.getProduto())
                      .append(",")
                      .append(String.format(Locale.US,"%.2f", item.getPreco()))
                      .append(",")
                	  .append(String.valueOf(item.getQuantidade()))
	                  .append("\n");
            }

            System.out.println("Arquivo CSV criado com sucesso!");

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("Salvando...");
	}
	
	
	public static void atualizarItem(ArrayList<Produtos> items) {
		Scanner scn = new Scanner(System.in);
		Scanner scn2 = new Scanner(System.in);
		
	    System.out.println("Digite o código do produto que deseja atualizar: ");
	    int selecionar_item = scn.nextInt();
	 
	    for(Produtos item : items) {
	    	if(item.getCodigo() == selecionar_item) {
	    		mostrarItem(item);
	    		
				System.out.println("\nDigite o nome do produto: ");
				String produto = scn2.nextLine();
				
				System.out.println("\nDigite o preço do produto: ");
				Double preco = scn.nextDouble();
				
				System.out.println("\nDigite a quantidade em estoque: ");
				int quantidade = scn.nextInt();
				
				item.setProduto(produto);
				item.setPreco(preco);
				item.setQuantidade(quantidade);
				
				System.out.println("\nItem atualizado!");
				mostrarItem(item);
			
	    	}
	    }
	}
	
	
	public static void autorizacao() {
		Scanner scn = new Scanner(System.in);

		boolean autorizacao = true;
		while(autorizacao == true) {
			System.out.println("\nLogin:");
			String login = scn.nextLine();
			 
			System.out.printf("("+login+") Senha: ");
			String senha = scn.nextLine();
			 
			if(login.equals("admin") & senha.equals("admin")) {
				System.out.println("\nVocê entrou como administrador!\n");
				autorizacao = false;
			 }
			else {
				System.out.println("Login incorreto!");
				 
			 }
		 }
		 
	}
	
	
	public static String menu() {
		 Scanner scn = new Scanner(System.in);
		 
			 System.out.println("<1> - Atualizar item\n"       +
			 		        	"<2> - Listar items\n"         +
			 		        	"<3> - Deletar item\n"         +
			                    "<4> - Salvar\n"               +
			 		        	"<5> - Sair sem salvar\n"      +
			                    "<6> - Resetar vending machine");
			 
			 String opcao = scn.nextLine(); 	
			 return opcao;
	}
	
	
	public static void mostrarItem(Produtos item) {
		System.out.println("------------------------------------");
		System.out.println("Código: " + item.getCodigo()    );
		System.out.println("Produto: "  + item.getProduto()   );
		System.out.println("Preço: "    + item.getPreco()     );
		System.out.println("Quantidade: " + item.getQuantidade());
		System.out.println("------------------------------------\n");
	}
}
