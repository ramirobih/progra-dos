package tp2020;

public class Megatrailer extends Transporte {
	
	private double seguroCarga;
	private double costoFijo;
	private double costoComida;
	
	

	public Megatrailer(String idTransporte, double cargaMax, double volumenMax, 
			boolean frigorifico, double costoKm, double seguroCarga, double costoFijo, double costoComida ) {
		
		super(idTransporte, cargaMax, volumenMax, frigorifico, costoKm);
		this.seguroCarga = seguroCarga;
		this.costoFijo = costoFijo;
		this.costoComida = costoComida;
	}


	@Override
	double obtenerCostoViaje(String idTransporte) {
		return 0;
		// TODO Auto-generated method stub
		
	}


	@Override
	void iniciarViaje(String idTransp) {
		// TODO Auto-generated method stub
		
	}


	@Override
	void finalizarViaje(String idTransp) {
		// TODO Auto-generated method stub
		
	}	
	
	
}
