package enums;

public enum OpcoesMenu {
	FIM("[0]- FIM"),
	ADD_CAR("[1]- adicionar Carro"),
	ADD_MOTO("[2]- adicionar Moto"),
	FIND_CHASSI_CAR("[3]- pesquisar Carro por chassi"),
	FIND_CHASSI_MOTO("[4]- perquisar Moto por chassi"),
	LIST_CAR("[5]- listar estoque de Carros"),
	LIST_MOTO("[6]- listar estoque de Motos"),
	SAVE_FILE("[7]- salvar estoque em arquivo"),
	RET_FILE("[8]- recuperar estoque de arquivo");
	
	private final String menu;

	private OpcoesMenu(String menu) {
		this.menu = menu;
	}
	
	@Override
	public String toString() {
		return this.menu;
	}
}
