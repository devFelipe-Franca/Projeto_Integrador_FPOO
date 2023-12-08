package Vending_Machine;
import java.util.*;


public class Main_Vending_Machine {
	public static void main(String[] args) {
		
		ArrayList<Produtos> items = new ArrayList<>();
		
		Scanner scn = new Scanner(System.in);
		Scanner scn2 = new Scanner(System.in);
		
		System.out.println("<1> - Entrar como administrador\n" +
						   "<2> - Entrar como usuário\n"       );
		
		String autenticacao = scn.nextLine(); 
		
		switch(autenticacao) {
			
		 case "1":
			 boolean autorizacao = true;
			 while(autorizacao == true) {
				 System.out.println("\nLogin:");
				 String login = scn.nextLine();
				 
				 System.out.printf("("+login+") Senha: ");
				 String senha = scn.nextLine();
				 
				 if(login.equals("admin") & senha.equals("admin")) {
					 System.out.println("\nVocê entrou como administrador!");
					 autorizacao = false;
				 }
				 else {
					 System.out.println("Login incorreto!");
					 
				 }
			 }
			 boolean menu = true;
			 while(menu == true) {
				 System.out.println("<1> - Atualizar item\n"       +
				 		        	"<2> - Listar items\n"         +
				 		        	"<3> - Deletar item\n"         +
				                    "<4> - Salvar\n"               +
				 		        	"<5> - Sair sem salvar"        +
				                    "<6> - resetar vending machine");
		   
				 String opcao = scn.nextLine(); 
				 
				 if(opcao.equals("1")) {
					 
					 System.out.println("Digite o código do produto que deseja atualizar: ");
					 int selecionar_item = scn2.nextInt();
					 
					 for(Produtos item : items) {
						 if(item.getCodigo() == selecionar_item) {
							 System.out.println("\n------------------------------------");	
							 System.out.println("Código: " + item.getCodigo()    );
							 System.out.println("Produto: "  + item.getProduto()   );
							 System.out.println("Preço: "    + item.getPreco()     );
							 System.out.println("Quantidade: " + item.getQuantidade());
							 System.out.println("------------------------------------");	
							 
							 atualizarItem(item);
							 
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
				 
				 else if(opcao.equals("2")) {
					 System.out.println("Listando items...");
					 String lista_items = "Código\t\tProduto\t\t\tPreço - R$\tQuantidade\n";
					 for(Produtos item : items) {
						 lista_items += item.getCodigo()+"\t\t"+item.getProduto()+"\t\t\t"+item.getPreco()+"\t\t"+item.getQuantidade()+"\n";
					 }
					 System.out.println(lista_items);
				 }

				 else if(opcao.equals("3")) {
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
			 }
		}
	}
	public static void atualizarItem(Produtos item) {
		Scanner scn = new Scanner(System.in);
		Scanner scn2 = new Scanner(System.in);
		
		System.out.println("\nDigite o código do produto: ");
		int codigo = scn.nextInt();
		
		System.out.println("\nDigite o nome do produto: ");
		String produto = scn2.nextLine();
		
		System.out.println("\nDigite o preço do produto: ");
		Double preco = scn.nextDouble();
		
		System.out.println("\nDigite a quantidade em estoque: ");
		int quantidade = scn.nextInt();
		
		item.setProduto(produto);
		item.setPreco(preco);
		item.setQuantidade(quantidade);
	}
}