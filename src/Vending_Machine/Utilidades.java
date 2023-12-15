package Vending_Machine;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Utilidades {
	
	
	public static void criarItems(ArrayList<Produtos> items) {
		
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
		 System.out.print("------------------------------------------------------------------\n");
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

        } catch (IOException e) {
            e.printStackTrace();
        }
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
		Scanner scn2 = new Scanner(System.in);

		boolean autorizacao = true;
		while(autorizacao == true) {
			System.out.println("\nLogin:");
			String login = scn2.nextLine();
			 
			System.out.printf("("+login+") Senha: ");
			String senha = scn2.nextLine();
			 
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
		 Scanner scn2 = new Scanner(System.in);
		 
			 System.out.println("<1> - Atualizar item\n"       +
			 		        	"<2> - Listar items\n"         +
			 		        	"<3> - Deletar item\n"         +
			                    "<4> - Salvar\n"               +
			 		        	"<5> - Sair sem salvar\n"      +
			                    "<6> - Resetar vending machine");
			 
			 String opcao = scn2.nextLine(); 	
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
	
	public static void atualizarEstoque(ArrayList<Produtos> items, ArrayList<Integer> lista_quantidade,ArrayList<Integer> lista_compras) {
		for (int i = 0; i < lista_quantidade.size(); i++) {
			for (Produtos item : items) {
				if (lista_compras.get(i) == item.getCodigo()) {
					int atualizar_estoque = item.getQuantidade() - lista_quantidade.get(i) ;
					item.setQuantidade(atualizar_estoque);
				}
			}
		}
	}
	
	public static void pagarPix(ArrayList<Produtos> items, ArrayList<Integer> lista_quantidade,ArrayList<Integer> lista_compras) {
		Scanner scn2 = new Scanner(System.in);
		System.out.println("Chave pix: 0115");
		System.out.println("Chave:");
		scn2.nextLine();
		System.out.println("...");
		System.out.println("Pagamento realizado!");
		System.out.println("Obrigado pela compra volte sempre!");
		
		Utilidades.atualizarEstoque(items,lista_quantidade,lista_compras);
	}
	
	public static void pagarDebito(ArrayList<Produtos> items, ArrayList<Integer> lista_quantidade,ArrayList<Integer> lista_compras) {
		Scanner scn2 = new Scanner(System.in);
		System.out.println("Insira o cartão...");
		System.out.println("Senha: ");
		scn2.nextLine();
		System.out.println("...");
		System.out.println("Autorizado!");
		System.out.println("Obrigado pela compra volte sempre!");
		
		Utilidades.atualizarEstoque(items,lista_quantidade,lista_compras);
	}
	
	public static void pagarDinheiro(Double total,ArrayList<Produtos> items, ArrayList<Integer> lista_quantidade,ArrayList<Integer> lista_compras) {
		Scanner scn2 = new Scanner(System.in);
		Double troco = 0.0;
		boolean pagar = true;
		while (pagar == true) {
		System.out.println("Cédulas aceitas: 2 - 5 - 10 - 20 - 50 - 100\n" +
						   "Valor do pagamento: ");
		Double pagamento = scn2.nextDouble();  
	
			if (pagamento < total) {
				System.out.println("Pagamento insuficiente!");
				continue;
			}
			
			troco = pagamento - total;
		
			
			
			if (troco > 50) {
				System.out.println("Troco acima do limite!");
				continue;
				
			}
			else if (troco > 0) {
				System.out.println("Aqui está seu troco: R$ " + troco);
				System.out.println("Obrigado pela compra volte sempre!");
			}
			
			else {
				System.out.println("Obrigado pela compra volte sempre!");
			}
			pagar = false;
			}
		
		Utilidades.atualizarEstoque(items,lista_quantidade,lista_compras);
	}
	
	public static String metodoPagamento(String lista_items, Double total) {
		Scanner scn2 = new Scanner(System.in);
		System.out.println("------------------------------------------------------------------");
		System.out.println(lista_items);
		System.out.println("Valor total: R$ " + total);
		System.out.println("------------------------------------------------------------------\n");
		
		System.out.println("Qual o método de pagamento?\n" +
						   "D - Dinheiro \nCD - Cartão de débito \nPIX - Pix\n" +
						   "Troco máximo de R$ 50,00\n");
		String metodo = scn2.nextLine();
		
		return metodo;
	}
	
	public static String realizarCompra(ArrayList<Produtos> items, ArrayList<Integer> lista_quantidade,ArrayList<Integer> lista_compras, String lista_items, Double preco,Double total) {
		Scanner scn = new Scanner(System.in);
		Scanner scn2 = new Scanner(System.in);
		
		String continuar_compra = "S";
		vendingMachineLoop:
		while(continuar_compra.equalsIgnoreCase("S")) {
			
		
		System.out.println("------------------------------------------------------------------");
		System.out.println("*************************Vending Machine**************************");
		System.out.println("------------------------------------------------------------------\n");
		Utilidades.listarItems(items);
		System.out.println("Digite o código do item que deseja comprar: ");
		int selecionar_compra = scn.nextInt(); 
		System.out.println("\nQuantidade: ");
		int quantidade = scn.nextInt(); 
		
		for (Produtos item : items) {
			if(selecionar_compra == item.getCodigo()) {
				if(quantidade > item.getQuantidade()) {
					System.out.println("\nQuantidade indisponível!\n");
					continue vendingMachineLoop;
				}
				else {
					lista_compras.add(selecionar_compra);
					lista_quantidade.add(quantidade);
					lista_items += item.getCodigo()+"\t\t"+item.getProduto()+"\t\t\t"+item.getPreco() * quantidade+"\t\t"+quantidade+"\n";
					preco = item.getPreco() * quantidade; 
					
				}
			}
		}
		total = total + preco;
		System.out.println("\n<S> - Para adicionar mais items ao carrinho\n"+
						     "<N> - Para finalizar a compra");
		continuar_compra = scn2.nextLine();
		}
		
		return continuar_compra;
	}
}
