package tp2020;

public abstract class Transporte {
	
	private String idTransporte;
	private double cargaMax;
	private double volumenMax;
	private boolean frigorifico;
	private double costoKm;
	private String destino;
	private boolean enViaje;
	
	
	public Transporte (String idTransporte, double cargaMax,
			double volumenMax, boolean frigorifico, double costoKm) {
		
		this.idTransporte = idTransporte;
		this.cargaMax = cargaMax;
		this.volumenMax = volumenMax;
		this.frigorifico = frigorifico;
		this.costoKm = costoKm;
		
	}
	
	public void asignarDestino(String destino) {
		this.destino = destino;
	}
	
	abstract double obtenerCostoViaje (String idTransporte);
	
	abstract void iniciarViaje (String idTransp);

	abstract void finalizarViaje (String idTransp);

	
}
