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

	Carro pesquisarCarro(String c){
		//como o código do chassi é unico, a pesquisa é feita com base nele
		int i=0;
		while(i<= estoqueCarros.size()){
			String chassi = estoqueCarros.get(i).getChassi();
			if(c.equals(chassi)){
				System.out.println("Carro encontrado. Código do chassi: "+chassi);
				return estoqueCarros.get(i);
			}
			i++;
		}
		System.out.println("Carro não encontrado.");
		return null;
	}
	
	Motocicleta pesquisarMoto(String m){
		//como o código do chassi é unico, a pesquisa é feita com base nele
		int i=0;
		while(i<= estoqueMotos.size()){
			String chassi = estoqueMotos.get(i).getChassi();
			if(m.equals(chassi)){
				System.out.println("Moto encontrada. Código do chassi: "+chassi);
				return estoqueMotos.get(i);
			}
			i++;
		}
		System.out.println("Moto não encontrada.");
		return null;
	}
	
	void listarEstoqueDeMotos(){//nome alterado para seguir camelcase
		if(estoqueMotos.size() == 0){
			System.out.println("Não há motos no estoque.");
			
		}else{
			for(int i=0; i<estoqueMotos.size(); i++){
				System.out.println("---------------------------------------");
				System.out.println("Moto na posição "+i);
				Motocicleta m = estoqueMotos.get(i);
				System.out.println("Chassi "+m.getChassi());
			}
			System.out.println("---------------------------------------");
		}
	}
	
	void listarEstoqueDeCarros(){//nome alterado para seguir camelcase
		if(estoqueCarros.size() == 0){
			System.out.println("Não há Carros no estoque.");
			
		}else{
			for(int i=0; i<estoqueCarros.size(); i++){
				System.out.println("---------------------------------------");
				System.out.println("Carro na posição "+i);
				Carro c = estoqueCarros.get(i);
				System.out.println("Chassi: "+c.getChassi());
			}
			System.out.println("---------------------------------------");
		}
	}
}
