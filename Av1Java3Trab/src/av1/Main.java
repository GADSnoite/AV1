package av1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int opcao = -1;
		String chassi = null;
		Scanner sc = new Scanner(System.in);
		Loja lj = new Loja();
		do{
			System.out.println("Escolha uma opção:");
			System.out.println("[0]- FIM");
			System.out.println("[1]- adicionar Carro");
			System.out.println("[2]- adicionar Moto");
			System.out.println("[3]- pesquisar Carro por chassi");
			System.out.println("[4]- perquisar Moto por chassi");
			System.out.println("[5]- listar estoque de Carros");
			System.out.println("[6]- listar estoque de Motos");
			System.out.println("[7]- salvar estoque em arquivo");
			System.out.println("[8]- recuperar estoque de arquivo");
			try{
				opcao = sc.nextInt();
			}catch(InputMismatchException e){
				System.out.println("ERRO- Tipo incorreto: "+e);
				System.exit(1);
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
					System.out.println("Insira um chassi válido:");
					try{
						chassi = sc.nextLine();
					}catch(InputMismatchException e){
						System.out.println("ERRO- Tipo incorreto: "+e);
						break;
					}
					lj.pesquisarCarro(chassi);
					break;
				case 4:
					System.out.println("Insira um chassi válido:");
					try{
						chassi = sc.nextLine();
					}catch(InputMismatchException e){
						System.out.println("ERRO- Tipo incorreto: "+e);
						break;
					}
					lj.pesquisarMoto(chassi);
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
	}

}