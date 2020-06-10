package tp2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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

	
	
	public boolean isFrigorifico() {
		return frigorifico;
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
 

	public boolean isDepositoPropio() {
		return propio;
	}

	
//////////////Funciones TP///////////////
	
	
	 
	public boolean incorporarPaquete (String destino,
			double peso, double volumen, boolean frio) { 
		
		//System.out.println("volumen: " +volumen + "   capacidad: " +capacidad);
		//System.out.println("frio: " +frio + "   frigorifico: " +frigorifico);
		
		if (capacidad < volumen || frio != frigorifico)
			return false; 
		
		Paquete paq = new Paquete (destino, peso, volumen, frio);
		capacidad=capacidad - volumen;
		paquetes.add(paq);		
		return true; 
	} 
	
	
	public double cargarTransporte (Transporte transp) {  
		
		double volumenCargado = 0;
		double pesoCargado = 0;
		
		
		Iterator<Paquete> paq=paquetes.iterator();
		
		while( paq.hasNext()) {
			Paquete p=paq.next();
			if (p.getDestino()==transp.getDestino()) {
				if (transp.cargarTransporte(p)) {
					paq.remove();
					volumenCargado = volumenCargado + p.getVolumenPaquete();
					pesoCargado = pesoCargado + p.getPesoPaquete();
					
				}	
			}
		} 
		
		
		if (pesoCargado>=1000) {				
			double ret=Math.floor(pesoCargado/1000); //redondeo para abajo
			transp.setCostoCargaDep(costoPorTonelada*ret);		
		}
		
		return volumenCargado;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(". Es deposito propio : ");
		sb.append(isDepositoPropio());
		sb.append(". Es frigorifico: ");
		sb.append(isFrigorifico());
		sb.append(". \n");
		return sb.toString();
	}	
}
