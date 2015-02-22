package av1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class Loja implements java.io.Serializable{
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
		System.out.println("Carro adicionado.");
		System.out.println("---------------------------");
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
		System.out.println("Moto adicionada.");
		System.out.println("---------------------------");
	}

	Carro pesquisarCarro(String c){
		//como o código do chassi é unico, a pesquisa é feita com base nele
		int i=0;
		while(i<= estoqueCarros.size()){
			String chassi = estoqueCarros.get(i).getChassi();
			if(c.equals(chassi)){
				System.out.println("Carro encontrado. Código do chassi: "+chassi);
				System.out.println("---------------------------");
				return estoqueCarros.get(i);
			}
			i++;
		}
		System.out.println("Carro não encontrado.");
		System.out.println("---------------------------");
		return null;
	}
	
	Motocicleta pesquisarMoto(String m){
		//como o código do chassi é unico, a pesquisa é feita com base nele
		int i=0;
		while(i<= estoqueMotos.size()){
			String chassi = estoqueMotos.get(i).getChassi();
			if(m.equals(chassi)){
				System.out.println("Moto encontrada. Código do chassi: "+chassi);
				System.out.println("---------------------------");
				return estoqueMotos.get(i);
			}
			i++;
		}
		System.out.println("Moto não encontrada.");
		System.out.println("---------------------------");
		return null;
	}

	void listarEstoqueDeMotos(){//nome alterado para seguir camelcase
		if(estoqueMotos.size() == 0){
			System.out.println("Não há motos no estoque.");
			System.out.println("---------------------------------------");
		}else{
			System.out.println(estoqueMotos.size()+" Motos em estoque.");
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
			System.out.println("---------------------------------------");
		}else{
			System.out.println(estoqueCarros.size()+" Carros em estoque.");
			for(int i=0; i<estoqueCarros.size(); i++){
				System.out.println("---------------------------------------");
				System.out.println("Carro na posição "+i);
				Carro c = estoqueCarros.get(i);
				System.out.println("Chassi: "+c.getChassi());
			}
			System.out.println("---------------------------------------");
		}
	}
	
	void salvarEstoque(Loja lj){
	      try{
	         FileOutputStream arquivo =
	         new FileOutputStream("estoque.ser");
	         ObjectOutputStream out = new ObjectOutputStream(arquivo);
	         out.writeObject(lj);
	         out.close();
	         arquivo.close();
	         System.out.printf("Estoque foi salvo. [estoque.ser]");
	         System.out.println("---------------------------");
	      }catch(IOException i){
	    	  System.out.println("Erro ao salvar estoque: ");
	          i.printStackTrace();
	          System.out.println("---------------------------");
	      }
	}

	void recuperarEstoque(Loja lj){
	      try{
	         FileInputStream arquivo = new FileInputStream("estoque.ser");
	         ObjectInputStream in = new ObjectInputStream(arquivo);
	         lj = (Loja) in.readObject();
	         in.close();
	         arquivo.close();
	      }catch(IOException i){
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c){
	         System.out.println("Classe não encontrada.");
	         System.out.println("---------------------------");
	         c.printStackTrace();
	         return;
	      }
	      System.out.println("Estoque encontrado.");
	      System.out.println("---------------------------");
	      lj.listarEstoqueDeCarros();
	}
	
}
