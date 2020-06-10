package tp2020;

public class Trailer extends Transporte {
	
	private double segCarga;

	
	public Trailer(String idTransp, double cargaMax,
			double capacidad, boolean frigorifico, double costoKm, double segCarga) {
		
		super(idTransp, cargaMax, capacidad, frigorifico, costoKm, "Trailer");
		if ( segCarga<=0)
			throw new RuntimeException ("Valor de variable invalido");
		this.segCarga = segCarga;
		
		
	}	
	
	double obtenerCostoViaje() { //COMPLETAR v 1.1
		
		return segCarga + (getCostoKm()*getViajeDestino().getDistanciaKm())+getCostoCargaDep();
		 
	}
	//Trailer Comun: destino < 500km
	//Megatrailer : destino > 500km
	
	
	void asignarDestino(Viaje viaje) {
		if (viaje.getDistanciaKm()>500)
			throw new RuntimeException("El transporte no puede realizar el viaje");
		viajeDestino = viaje;
		
	}

	@Override
	public String toString() {
		
			StringBuilder sb = new StringBuilder();
			sb.append("ID: ");
			sb.append(getIdTransporte());
			sb.append(". Tipo de transporte:  Trailer ");
			sb.append(". Esta en viaje: ");
			sb.append(isEnViaje());
			sb.append(". \n");
			return sb.toString();
		//return "Trailer [segCarga=" + segCarga + "]";
	}	
	
	

}
