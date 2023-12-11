package Vending_Machine;

import java.util.ArrayList;

public class Utilidades {
	public static void criarItems(ArrayList<Produtos> items) {
		System.out.println("Criando items...");
		for (int i = 1; i < 11; i++) {
			int codigo = i;
			String produto = "";
			Double preco = 0.0;
			int quantidade = 0;
			
			Produtos item = new Produtos(codigo, produto, preco, quantidade);
			items.add(item);
			
		}
	}
}
