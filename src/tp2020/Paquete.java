package tp2020;

public class Paquete {
	
	private Integer pesoPaquete;
	private Integer volumenPaquete;
	private String destino;
	private boolean refrigeracion;
	
	public Paquete () {
		
		if ( pesoPaquete<0)
			throw new RuntimeException ("Valor de variable invalido");
		if ( volumenPaquete<0)
			throw new RuntimeException ("Valor de variable invalido");
		if ( destino==null)
			throw new RuntimeException ("Valor de variable invalido");
		this.pesoPaquete = pesoPaquete;
		this.volumenPaquete = volumenPaquete;
		this.destino = destino;
		this.refrigeracion = refrigeracion;
	}
	//////////////Getters & Setters///////////////

	public Integer getPesoPaquete() {
		return pesoPaquete;
	}

	protected void setPesoPaquete(Integer pesoPaquete) {
		this.pesoPaquete = pesoPaquete;
	}

	public Integer getVolumenPaquete() {
		return volumenPaquete;
	}

	protected void setVolumenPaquete(Integer volumenPaquete) {
		this.volumenPaquete = volumenPaquete;
	}

	public String getDestino() {
		return destino;
	}

	protected void setDestino(String destino) {
		this.destino = destino;
	}

	public boolean isRefrigeracion() {
		return refrigeracion;
	}

	protected void setRefrigeracion(boolean refrigeracion) {
		this.refrigeracion = refrigeracion;
	}
	
	
	
}
