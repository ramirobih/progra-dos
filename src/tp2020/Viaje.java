package tp2020;

public class Viaje {
	
	private String destino;
	private Integer distanciaKm;
	
	public Viaje (String destino, Integer distanciaKm){
		
		if ( destino==null)
			throw new RuntimeException ("Valor de variable invalido");
		if ( distanciaKm<1)
			throw new RuntimeException ("Valor de variable invalido");
		this.destino = destino;
		this.distanciaKm = distanciaKm;
		
	}

	public String getDestino() { 
		return destino;
	}

	
	public Integer getDistanciaKm() {
		return distanciaKm;
	}

	
}
