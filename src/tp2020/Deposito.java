package tp2020;

import java.util.ArrayList;

public class Deposito {
		
	private ArrayList <Paquete> paquetes;
	private Integer numDeposito;
	private double costoPorTonelada;
	private double capacidad;
	private boolean frigorifico;
	private boolean propio;
	
	public Deposito (double capacidad, boolean frigorifico, boolean propio) {
		
		if ( capacidad<0)
			throw new RuntimeException ("Valor de variable invalido");
		this.capacidad = capacidad;
		this.paquetes = new ArrayList<Paquete>();
		this.frigorifico = frigorifico;
		this.propio = propio;
		
	}
	//////////////Getters & Setters///////////////

	public Integer getNumDeposito() {
		return numDeposito;
	}

	protected void setNumDeposito(Integer numDeposito) {
		this.numDeposito = numDeposito;
	}

	public double getCostoDeposito() {
		return costoPorTonelada;
	}

	protected void setCostoDeposito(double costoPorTonelada) {
		this.costoPorTonelada = costoPorTonelada;
	}

	public boolean isRefrigeracion() {
		return frigorifico;
	}
 
	protected void setRefrigeracion(boolean refrigeracion) {
		this.frigorifico = frigorifico;
	}

	public boolean isDepositoPropio() {
		return propio;
	}

	protected void setDepositoPropio(boolean depositoPropio) {
		this.propio = propio;
	}
	
//////////////Funciones TP///////////////
	
	
	
	public boolean incorporarPaquete (String destino, double peso, double volumen,
			boolean frio) { 
		System.out.println("volumen: " +volumen + "   capacidad: " +capacidad);
		System.out.println("frio: " +frio + "   frigorifico: " +frigorifico);
		
		if (capacidad < volumen || frio != frigorifico)
			return false; 
		
		Paquete paq = new Paquete (destino, peso, volumen, frio);
		capacidad=capacidad - volumen;
		paquetes.add(paq);
		return true;
	}
	
	public void eliminarPaquete () {  //DESARROLLAR
		
	}
	
	public void cargarTransporte () {  
		
	}
	
}
