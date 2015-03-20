package av1;

import java.util.InputMismatchException;
import java.util.Scanner;

import enums.OpcoesMenu;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Integer opcao = -1;
		Scanner sc = new Scanner(System.in);
		Loja lj = new Loja();
		do{
			
			System.out.println("Escolha uma opção:");
			for (OpcoesMenu op : OpcoesMenu.values()) {
				System.out.println(op.toString());
			}
			
			try {
				opcao = sc.nextInt();
			} catch (InputMismatchException e) {
				throw new RuntimeException("Tipo inserido inválido!!!!");
			}
			
			switch(opcao){
				case 0:
					break;
				case 1:
					lj.adicionarCarro();
					break;
				case 2:
					lj.adicionarMoto();
					break;
				case 3:
					lj.pesquisarCarro();
					break;
				case 4:
					lj.pesquisarMoto();
					break;
				case 5:
					lj.listarEstoqueDeCarros();
					break;
				case 6:
					lj.listarEstoqueDeMotos();
					break;
				case 7:
					lj.salvarEstoque(lj);
					break;
				case 8:
					lj.recuperarEstoque(lj);
					break;
				default:
					System.out.println("Opção inválida.");
					break;
			}
			
		}while(opcao != 0);
		
		sc.close();
		
	}

}