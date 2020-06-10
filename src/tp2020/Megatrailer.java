package tp2020;

public class Megatrailer extends Transporte {
	
	private double seguroCarga;
	private double costoFijo;
	private double costoComida;
	
	

	public Megatrailer(String idTransporte, double cargaMax, double volumenMax, 
			boolean frigorifico, double costoKm, double seguroCarga, double costoFijo, double costoComida ) {
		
		super(idTransporte, cargaMax, volumenMax, frigorifico, costoKm, "Megatrailer");
		if ( seguroCarga<=0)
			throw new RuntimeException ("Valor de variable invalido");
		this.seguroCarga = seguroCarga;
		if ( costoFijo<=0)
			throw new RuntimeException ("Valor de variable invalido");
		this.costoFijo = costoFijo;
		if ( costoComida<=0)
			throw new RuntimeException ("Valor de variable invalido");
		this.costoComida = costoComida;
	}
	
	//Trailer Comun: destino < 500km
	//Megatrailer : destino > 500km
		
	@Override
	void asignarDestino(Viaje viaje) {
		if (viaje.getDistanciaKm()<=500)
			throw new RuntimeException("El transporte no puede realizar el viaje");
		viajeDestino = viaje;
	}		
	
	
	//Costo fijo x viaje + costo x Km de viaje + gasto comida + segCarga
	
	public double obtenerCostoViaje() {
		
		return costoFijo 
				+(getCostoKm()*getViajeDestino().getDistanciaKm())+ costoComida+ seguroCarga+costoCargaDep;
		
	}
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("ID: ");
		sb.append(getIdTransporte());
		sb.append(". Tipo de transporte:  Megatrailer ");
		sb.append(". Esta en viaje: ");
		sb.append(isEnViaje());
		sb.append(". \n");
		return sb.toString();
	//return "Trailer [segCarga=" + segCarga + "]";
}
	
}
