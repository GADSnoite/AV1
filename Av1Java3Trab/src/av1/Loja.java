package av1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import enums.CambioCarro;
import enums.CapacidadeTanque;
import enums.CilindradaMoto;
import enums.Cor;
import enums.ModeloCarro;
import enums.ModeloMoto;
import enums.MontadoraDeCarro;
import enums.MontadoraDeMoto;
import enums.Precos;
import enums.TipoVeiculo;

@SuppressWarnings("resource")
public class Loja implements Serializable {
	static final long serialVersionUID = 1L;
	String endereco, nome;
	ArrayList<Carro> estoqueCarros = new ArrayList<Carro>();// melhor do que
															// array primitivo,
															// não especifica
															// tamanho
	ArrayList<Motocicleta> estoqueMotos = new ArrayList<Motocicleta>();

	void adicionarCarro() {

		@SuppressWarnings("unused")
		Map<String, Object> veiculo = new HashMap<String, Object>();
		Map<String, String> carro = new HashMap<String, String>();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Insira o chassi:");
			carro.put("Chassi", sc.nextLine());
			// teste
			System.out.println("Insira a montadora:");
			for (MontadoraDeCarro montadora : MontadoraDeCarro.values()) {
				System.out.println(montadora.toString());
			}
			carro.put("Montadora",
					MontadoraDeCarro.values()[sc.nextInt()].toString());

			System.out.println("Insira o modelo:");
			for (ModeloCarro modelo : ModeloCarro.values()) {
				System.out.println(modelo.toString());
			}
			carro.put("Modelo", ModeloCarro.values()[sc.nextInt()].toString());

			System.out.println("Insira o tipo de carro:");
			for (TipoVeiculo tipo : TipoVeiculo.values()) {
				System.out.println(tipo.toString());
			}
			carro.put("Tipo", TipoVeiculo.values()[sc.nextInt()].toString());

			System.out.println("Insira a cor do carro:");
			for (Cor cor : Cor.values()) {
				System.out.println(cor.toString());
			}
			carro.put("Cor", Cor.values()[sc.nextInt()].toString());

			System.out.println("Insira o cambio:");
			for (CambioCarro cambio : CambioCarro.values()) {
				System.out.println(cambio.toString());
			}
			carro.put("Cambio", CambioCarro.values()[sc.nextInt()].toString());

			System.out.println("Insira o preço:");
			for (Precos preco : Precos.values()) {
				System.out.println(preco.toString());
			}
			carro.put("Preco", Precos.values()[sc.nextInt()].toString());

		} catch (InputMismatchException e) {
			System.out.println("ERRO- Tipo incorreto: " + e);
			System.exit(1);
		}
		// estoqueCarros.add(nc);
		System.out.println("Carro adicionado.");
		System.out.println("---------------------------");
	}

	void adicionarMoto() {

		//Map<String, Object> veiculo = new HashMap<String, Object>();
		Map<String, String> moto = new HashMap<String, String>();
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Insira o chassi:");
			moto.put("Chassi", sc.nextLine());
			// teste
			System.out.println("Insira a montadora:");
			for (MontadoraDeMoto montadoramoto : MontadoraDeMoto.values()) {
				System.out.println(montadoramoto.toString());
			}
			moto.put("Montadora",
					MontadoraDeMoto.values()[sc.nextInt()].toString());

			System.out.println("Insira o modelo:");
			for (ModeloMoto modelomoto : ModeloMoto.values()) {
				System.out.println(modelomoto.toString());
			}
			moto.put("Modelo", ModeloMoto.values()[sc.nextInt()].toString());

			System.out.println("Insira a cor da moto:");
			for (Cor cor : Cor.values()) {
				System.out.println(cor.toString());
			}
			moto.put("Cor", Cor.values()[sc.nextInt()].toString());

			System.out.println("Insira o preço:");
			for (Precos preco : Precos.values()) {
				System.out.println(preco.toString());
			}
			moto.put("Preco", Precos.values()[sc.nextInt()].toString());

			System.out.println("Insira a cilindrada:");
			for (CilindradaMoto cilindrada : CilindradaMoto.values()) {
				System.out.println(cilindrada.toString());
			}
			moto.put("Cilindrada",
					CilindradaMoto.values()[sc.nextInt()].toString());

			System.out.println("Insira a capacidade do tanque:");
			for (CapacidadeTanque capacidade_tanque : CapacidadeTanque.values()) {
				System.out.println(capacidade_tanque.toString());
			}
			moto.put("Capacidade do tanque",
					CapacidadeTanque.values()[sc.nextInt()].toString());

		} catch (InputMismatchException e) {
			System.out.println("ERRO- Tipo incorreto: " + e);
			System.exit(1);
		}
		// estoqueCarros.add(nc);
		System.out.println("Moto adicionado.");
		System.out.println("---------------------------");
	}

	void pesquisarCarro() {
		// como o código do chassi é unico, a pesquisa é feita com base nele
		System.out.println("Insira um chassi válido:");
		Scanner sc = new Scanner(System.in);
		String c = sc.nextLine();
		int i = 0;
		while (i < estoqueCarros.size()) {
			String chassi = estoqueCarros.get(i).getChassi();
			if (c.equals(chassi)) {
				System.out.println("Carro encontrado. Código do chassi: "
						+ chassi);
				System.out.println("---------------------------");
				System.out.println(estoqueCarros.get(i).toString());
			} else {
				System.out.println("Carro não encontrado.");
				System.out.println("---------------------------");
			}
			i++;
		}
	}

	void pesquisarMoto() {
		// como o código do chassi é unico, a pesquisa é feita com base nele
		System.out.println("Insira um chassi válido:");
		Scanner sc = new Scanner(System.in);
		String m = sc.nextLine();
		int i = 0;
		while (i <= estoqueMotos.size()) {
			String chassi = estoqueMotos.get(i).getChassi();
			if (m.equals(chassi)) {
				System.out.println("Moto encontrada. Código do chassi: "
						+ chassi);
				System.out.println("---------------------------");
				estoqueMotos.get(i);
			}
			i++;
		}
		System.out.println("Moto não encontrada.");
		System.out.println("---------------------------");
	}

	void listarEstoqueDeMotos() {// nome alterado para seguir camelcase
		if (estoqueMotos.size() == 0) {
			System.out.println("Não há motos no estoque.");
			System.out.println("---------------------------------------");
		} else {
			System.out.println(estoqueMotos.size() + " Motos em estoque.");
			for (int i = 0; i < estoqueMotos.size(); i++) {
				System.out.println("---------------------------------------");
				System.out.println("Moto na posição " + i);
				Motocicleta m = estoqueMotos.get(i);
				System.out.println("Chassi " + m.getChassi());
			}
			System.out.println("---------------------------------------");
		}
	}

	void listarEstoqueDeCarros() {// nome alterado para seguir camelcase
		if (estoqueCarros.size() == 0) {
			System.out.println("Não há Carros no estoque.");
			System.out.println("---------------------------------------");
		} else {
			System.out.println(estoqueCarros.size() + " Carros em estoque.");
			for (int i = 0; i < estoqueCarros.size(); i++) {
				System.out.println("---------------------------------------");
				System.out.println("Carro na posição " + i);
				Carro c = estoqueCarros.get(i);
				System.out.println("Chassi: " + c.getChassi());
			}
			System.out.println("---------------------------------------");
		}
	}

	void salvarEstoque(Loja lj) {
		try {
			FileOutputStream arquivo = new FileOutputStream("estoque.ser");
			ObjectOutputStream out = new ObjectOutputStream(arquivo);
			out.writeObject(lj);
			out.close();
			arquivo.close();
			System.out.printf("Estoque foi salvo. [estoque.ser]");
			System.out.println("---------------------------");
		} catch (IOException i) {
			System.out.println("Erro ao salvar estoque: ");
			i.printStackTrace();
			System.out.println("---------------------------");
		}
	}

	void recuperarEstoque(Loja lj) {
		try {
			FileInputStream arquivo = new FileInputStream("estoque.ser");
			ObjectInputStream in = new ObjectInputStream(arquivo);
			lj = (Loja) in.readObject();
			in.close();
			arquivo.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
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
