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
						 menu_ = false;
						 break;
					 }
					 
					 else if(opcao.equals("5")) {  
					   	System.out.println("Saindo sem salvar...");
					   	menu_ = false;
						break;
						
					 }
					
					 else if(opcao.equals("6")) {
					  	Utilidades.resetarVending(items);
					 } 
				 }
				
			case "1":	
				
				System.out.println("Digite o código do item que deseja comprar: ");
				int selecionar_compra = scn.nextInt(); 
				
				
		  	}
	}
}