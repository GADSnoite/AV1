package av1;

public class Motocicleta extends Veiculo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cilindrada, capacidadeTanque;

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public int getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(int capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}
	
	@Override
	public String toString() {
		return 	"Montadora: " + montadora + 
				"\nModelo: " + modelo + 
				"\nTipo: " + tipo + 
				"\nCor: " + cor +
				"\n\r";
	}
	
}