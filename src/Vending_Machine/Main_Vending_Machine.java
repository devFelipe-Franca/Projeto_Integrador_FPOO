package Vending_Machine;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;


public class Main_Vending_Machine {
	public static void main(String[] args) {
		
		ArrayList<Produtos> items = new ArrayList<>();
		ArrayList<Integer> lista_compras = new ArrayList<>();
		ArrayList<Integer> lista_quantidade = new ArrayList<>();
		
		Scanner scn = new Scanner(System.in);
		Scanner scn2 = new Scanner(System.in);
		
		System.out.println("<1> - Para iniciar compras.\n");
		
		String autenticacao = scn2.nextLine(); 
		
		switch(autenticacao) {
			
			case "000":
				 
				 Utilidades.autorizacao();
				 
				 Utilidades.lerCSV(items);
				 boolean menu_ = true;
				 while(menu_ == true) {
					 
					 String opcao = Utilidades.menu();
					 
					 if(opcao.equals("1")) {
						 Utilidades.atualizarItem(items);
					 }
					 
					 else if(opcao.equals("2")) {
						 System.out.println("Listando items...");
						 Utilidades.listarItems(items);
					 }
			
					 else if(opcao.equals("3")) {
						 Utilidades.deletarItem(items); 
					 } 
					 
					 else if(opcao.equals("4")) {  
						 Utilidades.salvarCSV(items);
					     System.out.println("Salvando e saindo...");
						 menu_ = false;
					 }
					 
					 else if(opcao.equals("5")) {  
					   	System.out.println("Saindo sem salvar...");
					   	menu_ = false;
					 }
					
					 else if(opcao.equals("6")) {
					  	Utilidades.resetarVending(items);
					 } 
				 }
				 break;
			case "1":	
				Utilidades.lerCSV(items);
				
				Double total = 0.0;
				Double preco = 0.0;
				String lista_items = "Código\t\tProduto\t\t\tSubtotal - R$\tQuantidade\n";
				
				String continuar_compra = Utilidades.realizarCompra(items, lista_quantidade, lista_compras, lista_items, preco, total);
				if(continuar_compra.equalsIgnoreCase("N")) {
					String metodo = Utilidades.metodoPagamento(lista_items, total);
										
					switch(metodo) {
					
					case "D":
						Utilidades.pagarDinheiro(total, items, lista_quantidade, lista_compras);
						Utilidades.salvarCSV(items);
						break;
					
					case "CD" :
						Utilidades.pagarDebito(items, lista_quantidade, lista_compras);
						Utilidades.salvarCSV(items);
						break;
						
					case "PIX" :
						Utilidades.pagarPix(items, lista_quantidade, lista_compras);
						Utilidades.salvarCSV(items);
						break;
					}
			}
		}	
	}
}