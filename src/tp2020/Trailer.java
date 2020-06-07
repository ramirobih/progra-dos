package tp2020;

public class Trailer extends Transporte {
	
	private double segCarga;

	
	public Trailer(String idTransp, double cargaMax, double capacidad, boolean frigorifico, double costoKm, double segCarga) {
		
		super(idTransp, cargaMax, capacidad, frigorifico, costoKm);
		this.segCarga = segCarga;
		
		
	}

	@Override
	double obtenerCostoViaje(String idTransporte) { //COMPLETAR
		return 0;
		
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
