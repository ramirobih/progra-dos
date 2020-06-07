package tp2020;

public class Flete extends Transporte{
	
	private int cantAcompañantes;
	private double costoPorAcompañante;
	
	
		
	public Flete(String idTransporte, double cargaMax, double volumenMax,
			boolean frigorifico, double costoKm, int cantAcom, double costoPorAcomp) {
		
		super(idTransporte, cargaMax, volumenMax, frigorifico, costoKm);
		this.cantAcompañantes = cantAcompañantes;
		this.costoPorAcompañante = costoPorAcompañante;

	}

	@Override
	double obtenerCostoViaje(String idTransporte) { //COMPLETAR
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
