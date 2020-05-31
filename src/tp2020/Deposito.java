package tp2020;

import java.util.ArrayList;

public class Deposito {
		
	private ArrayList <Paquete> paquetes;
	private Integer numDeposito;
	private Integer costoDeposito;
	private boolean refrigeracion;
	private boolean depositoPropio;
	
	public Deposito (Integer numDeposito, Integer costoDeposito, boolean refrigeracion, boolean depositoPropio) {
		
		if ( numDeposito<0)
			throw new RuntimeException ("Valor de variable invalido");
		if ( costoDeposito<0)
			throw new RuntimeException ("Valor de variable invalido");
		this.paquetes = new ArrayList<Paquete>();
		this.numDeposito = numDeposito;
		this.costoDeposito = costoDeposito;
		this.refrigeracion = refrigeracion;
		this.depositoPropio = depositoPropio;
		
	}
	//////////////Getters & Setters///////////////

	public Integer getNumDeposito() {
		return numDeposito;
	}

	protected void setNumDeposito(Integer numDeposito) {
		this.numDeposito = numDeposito;
	}

	public Integer getCostoDeposito() {
		return costoDeposito;
	}

	protected void setCostoDeposito(Integer costoDeposito) {
		this.costoDeposito = costoDeposito;
	}

	public boolean isRefrigeracion() {
		return refrigeracion;
	}

	protected void setRefrigeracion(boolean refrigeracion) {
		this.refrigeracion = refrigeracion;
	}

	public boolean isDepositoPropio() {
		return depositoPropio;
	}

	protected void setDepositoPropio(boolean depositoPropio) {
		this.depositoPropio = depositoPropio;
	}
	
//////////////Funciones TP///////////////
	
	public boolean incorporarPaquete( String destino, 
			Integer volumen, Integer peso, boolean refrigeracion) { 
		//DESARROLLAR
		return false;
	}
	
	public void eliminarPaquete () {  //Al cargar paquete al camion eliminar del deposito
		//DESARROLLAR
	}
	
	
}
