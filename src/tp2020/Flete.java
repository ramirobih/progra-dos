package tp2020;

public class Flete extends Transporte{
	
	private int cantAcompañantes;
	private double costoPorAcompañante;
	
	
		
	public Flete(String idTransporte, double cargaMax, double volumenMax,
			boolean frigorifico, double costoKm, int cantAcom, double costoPorAcomp) {
		
		super(idTransporte, cargaMax, volumenMax, frigorifico, costoKm, "Flete");
		if ( cantAcompañantes<0)
			throw new RuntimeException ("Valor de variable invalido");
		this.cantAcompañantes = cantAcom;
		if ( costoPorAcomp<=0)
			throw new RuntimeException ("Valor de variable invalido");
		this.costoPorAcompañante = costoPorAcomp;

	}
	
	
	 
	//Trailer Comun: destino < 500km
	//Megatrailer : destino > 500km
		
	public int getCantAcompañantes() {
		return this.cantAcompañantes;
	}



	public double getCostoPorAcompañante() {
		return this.costoPorAcompañante;
	}



	@Override
	void asignarDestino(Viaje viaje) {

		viajeDestino = viaje;
	}
	
	//Si carga de depTerc, se suma costoCargaDep + costoKm * viaje.distanciaKm
	//Costo fijo x cantAcomp 

	public double obtenerCostoViaje() { //COMPLETAR v 1.0
		
		return costoCargaDep 
				+(getCostoKm()*getViajeDestino().getDistanciaKm())
				+getCantAcompañantes()*getCostoPorAcompañante();
		
	
	}
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("ID: ");
		sb.append(getIdTransporte());
		sb.append(". Tipo de transporte:  Flete ");
		sb.append(". Esta en viaje: ");
		sb.append(isEnViaje());
		sb.append(". \n");
		return sb.toString();
	//return "Trailer [segCarga=" + segCarga + "]";
}
	
}
