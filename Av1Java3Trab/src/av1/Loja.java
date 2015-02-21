package av1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Loja {
	String endereco, nome;
	ArrayList<Carro> estoqueCarros = new ArrayList<Carro>();//melhor do que array primitivo, não especifica tamanho
	ArrayList<Motocicleta> estoqueMotos = new ArrayList<Motocicleta>();
	
	void adicionarCarro(){
		/*cria a instancia de carro, 
		 * recebe do usuario os valores a serem inseridos,
		 * e utiliza os setters
		 * adiciona o objeto ao vetor
		 */
		Carro nc = new Carro();
		Scanner sc = new Scanner(System.in);
		try{
			System.out.println("Insira o chassi:");
			nc.setChassi(sc.nextLine());
			System.out.println("Insira a montadora:");
			nc.setMontadora(sc.nextLine());
			System.out.println("Insira o modelo:");
			nc.setModelo(sc.nextLine());
			System.out.println("Insira o tipo de carro:");
			nc.setTipo(sc.nextLine());
			System.out.println("Insira a cor do carro:");
			nc.setCor(sc.nextLine());
			System.out.println("Insira o cambio:");
			nc.setCambio(sc.nextLine());
			
			System.out.println("Insira o preço:");
			nc.setPreco(sc.nextFloat());
			System.out.println("Insira o motorização:");
			nc.setMotorizacao(sc.nextFloat());
			
		}catch(InputMismatchException e){
			System.out.println("ERRO- Tipo incorreto: "+e);
			System.exit(1);
		}
		estoqueCarros.add(nc);
	}
	
	void adicionarMoto(){
		/*cria a instância de moto
		 * recebe do usuario os valores a serem inseridos,
		 * utiliza os setters
		 * adiciona o objeto ao vetor
		 */
		Motocicleta nm = new Motocicleta();
		Scanner sc = new Scanner(System.in);
		try{
			System.out.println("Insira o chassi:");
			nm.setChassi(sc.nextLine());
			System.out.println("Insira a montadora:");
			nm.setMontadora(sc.nextLine());
			System.out.println("Insira o modelo:");
			nm.setModelo(sc.nextLine());
			System.out.println("Insira o tipo de moto:");
			nm.setTipo(sc.nextLine());
			System.out.println("Insira a cor da moto:");
			nm.setCor(sc.nextLine());
			
			System.out.println("Insira a cilindrada:");
			nm.setCilindrada(sc.nextInt());
			System.out.println("Insira a capacidade do tanque:");
			nm.setCapacidadeTanque(sc.nextInt());
			
			System.out.println("Insira o preço:");
			nm.setPreco(sc.nextFloat());
		
		}catch(InputMismatchException e){
			System.out.println("ERRO- Tipo incorreto: "+e);
			System.exit(1);
		}
		estoqueMotos.add(nm);
	}
	
}