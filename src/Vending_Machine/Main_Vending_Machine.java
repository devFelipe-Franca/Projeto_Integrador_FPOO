package Vending_Machine;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;


public class Main_Vending_Machine {
	public static void main(String[] args) {
		
		ArrayList<Produtos> items = new ArrayList<>();
		
		Scanner scn = new Scanner(System.in);
		Scanner scn2 = new Scanner(System.in);
		
		System.out.println("<1> - Entrar como administrador\n" +
						   "<2> - Entrar como usuário\n"       );
		
		String autenticacao = scn2.nextLine(); 
		
		switch(autenticacao) {
			
		case "1":
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
			 
			 lerCSV(items);
				
			 boolean menu = true;
			 while(menu == true) {
				 System.out.println("<1> - Atualizar item\n"       +
				 		        	"<2> - Listar items\n"         +
				 		        	"<3> - Deletar item\n"         +
				                    "<4> - Salvar\n"               +
				 		        	"<5> - Sair sem salvar\n"      +
				                    "<6> - Resetar vending machine");
		   
				 String opcao = scn2.nextLine(); 
				 
				 if(opcao.equals("1")) {
					atualizarItem(items);
				 }
				 
				 else if(opcao.equals("2")) {
					listarItems(items);
				 }

				 else if(opcao.equals("3")) {
					deletarItem(items); 
				 } 
				 
				 else if(opcao.equals("4")) {  
					salvarCSV(items);
					break;
				 }
				 
				 else if(opcao.equals("5")) {  
					System.out.println("Saindo sem salvar...");
					break;
				 }
				
				 else if(opcao.equals("6")) {
					resetarVending(items);
				 } 
			 }
		}
	}
	
	public static void atualizarItem(ArrayList<Produtos> items) {
		Scanner scn = new Scanner(System.in);
		Scanner scn2 = new Scanner(System.in);
		
	    System.out.println("Digite o código do produto que deseja atualizar: ");
	    int selecionar_item = scn.nextInt();
	 
	    for(Produtos item : items) {
	    	if(item.getCodigo() == selecionar_item) {
	    		System.out.println("\n------------------------------------");	
	    		System.out.println("Código: " + item.getCodigo()    );
	    		System.out.println("Produto: "  + item.getProduto()   );
	    		System.out.println("Preço: "    + item.getPreco()     );
	    		System.out.println("Quantidade: " + item.getQuantidade());
	    		System.out.println("------------------------------------");	
	    		
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
		System.out.println("------------------------------------");
		System.out.println("Código: " + item.getCodigo()    );
		System.out.println("Produto: "  + item.getProduto()   );
		System.out.println("Preço: "    + item.getPreco()     );
		System.out.println("Quantidade: " + item.getQuantidade());
		System.out.println("------------------------------------\n");
	    	}
	     }
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
	
	public static void resetarVending(ArrayList<Produtos> items) {
			for(Produtos item : items) {
				 item.setProduto(" ");
				 item.setPreco(0);
				 item.setQuantidade(0);
			}
			 System.out.println("Vending Machine resetada com sucesso!");
	}
	
	public static void deletarItem(ArrayList<Produtos> items) {
		Scanner scn = new Scanner(System.in);
		Scanner scn2 = new Scanner(System.in);
		
		System.out.println("Digite o código do produto que deseja deletar: ");
		 int selecionar_item = scn2.nextInt();
		 
		 for(Produtos item : items) {
			 if(item.getCodigo() == selecionar_item) {
				 System.out.println("\n------------------------------------");	
				 System.out.println("Código: " + item.getCodigo()    );
				 System.out.println("Produto: "  + item.getProduto()   );
				 System.out.println("Preço: "    + item.getPreco()     );
				 System.out.println("Quantidade: " + item.getQuantidade());
				 System.out.println("------------------------------------");
			
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
	
	public static void listarItems(ArrayList<Produtos> items) {
		 System.out.println("Listando items...");
		 String lista_items = "Código\t\tProduto\t\t\tPreço - R$\tQuantidade\n";
		 for(Produtos item : items) {
			 lista_items += item.getCodigo()+"\t\t"+item.getProduto()+"\t\t\t"+item.getPreco()+"\t\t"+item.getQuantidade()+"\n";
		 }
		 System.out.println(lista_items);
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
}