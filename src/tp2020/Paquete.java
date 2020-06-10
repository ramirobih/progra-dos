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


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paquete other = (Paquete) obj;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (frio != other.frio)
			return false;
		if (Double.doubleToLongBits(peso) != Double.doubleToLongBits(other.peso))
			return false;
		if (Double.doubleToLongBits(volumen) != Double.doubleToLongBits(other.volumen))
			return false;
		return true;
	}
	
	
	
	
}
