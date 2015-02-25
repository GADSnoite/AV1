package av1;

public class Carro extends Veiculo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cambio;
	private float motorizacao;
	
	public String getCambio() {
		return cambio;
	}
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	public float getMotorizacao() {
		return motorizacao;
	}
	public void setMotorizacao(float motorizacao) {
		this.motorizacao = motorizacao;
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
