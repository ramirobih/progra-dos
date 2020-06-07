package tp2020;

public class Paquete {
	
	private double peso;
	private double volumen;
	private String destino;
	private boolean frio;
	
	public Paquete (String destino, double peso, double volumen, boolean frio) { 
		
		if ( peso<0)
			throw new RuntimeException ("Valor de variable invalido");
		if ( volumen<0)
			throw new RuntimeException ("Valor de variable invalido");
		if ( destino==null)
			throw new RuntimeException ("Valor de variable invalido");
		this.peso = peso;
		this.volumen = volumen;
		this.destino = destino;
		this.frio = frio;
	}
	//////////////Getters & Setters///////////////

	public double getPesoPaquete() {
		return peso;
	}

	protected void setPesoPaquete(double peso) {
		this.peso = peso;
	}

	public double getVolumenPaquete() {
		return volumen;
	}

	protected void setVolumenPaquete(double volumen) {
		this.volumen = volumen;
	}

	public String getDestino() {
		return destino;
	}

	protected void setDestino(String destino) {
		this.destino = destino;
	}

	public boolean isRefrigeracion() {
		return frio;
	}

	protected void setRefrigeracion(boolean frio) {
		this.frio = frio;
	}
	
	
	
}
