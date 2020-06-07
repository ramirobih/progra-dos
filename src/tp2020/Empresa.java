package tp2020;

import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {
	
	private ArrayList <Deposito> depositos;
	private ArrayList <Deposito> depositosTercerizado;
	private HashMap <String, Transporte> transportes;
	private HashMap <String, Viaje> viajes;	
	private HashMap <Viaje, Transporte> transportesEnViaje;	
	private String nombreEmpresa;
	private String cuitEmpresa;
	
	public Empresa(String cuitEmpresa, String nombreEmpresa) {
		super();
		this.depositos = new ArrayList <Deposito>();
		this.depositosTercerizado = new ArrayList <Deposito>();
		this.transportes = new HashMap <String, Transporte>();;
		this.viajes = new HashMap <String, Viaje>();;
		this.transportesEnViaje = new HashMap <Viaje, Transporte>();
		this.nombreEmpresa = nombreEmpresa;
		this.cuitEmpresa = cuitEmpresa;
	}
	
	/////////////////////////////////METODOS////////////////////////////////////
	
	public int agregarDeposito (double capacidad, boolean frigorifico, boolean propio) { //COMPLETAR v 1.0
		
		Deposito dep = new Deposito (capacidad, frigorifico, propio);
		depositos.add(dep);
		return depositos.size();
	}
	
	public int agregarDepTercerizFrio (double capacidad, double costoPorTonelada) {       //COMPLETAR v 1.0
		
		Deposito dep = new Deposito (capacidad, true, false);
		dep.setCostoDeposito(costoPorTonelada);
		return depositosTercerizado.size();
	}
	
	void agregarDestino (String destino, int km) {  //COMPLETAR v 1.0
		
		if (viajes.containsKey(destino))
			throw new RuntimeException ("El destino ya esta creado");
		Viaje dest = new Viaje (destino, km);			
		viajes.put(destino, dest);
	}
	
	void agregarTrailer(String idTransp, double cargaMax, double capacidad,
			boolean frigorifico, double costoKm, double segCarga) {  //COMPLETAR v 1.0
		
		Trailer trail = new Trailer (idTransp, cargaMax, capacidad, frigorifico, costoKm, segCarga);
		transportes.put(idTransp, trail);
	}
	
	void agregarMegaTrailer(String idTransp, double cargaMax, double capacidad, boolean frigorifico,
			double costoKm, double segCarga, double costoFijo, double comida) {							//COMPLETAR v 1.0					
		
		Megatrailer megat = new Megatrailer (idTransp, cargaMax,
				capacidad, frigorifico, costoKm, segCarga, costoFijo, comida);
		transportes.put(idTransp, megat);
	}
	
	void agregarFlete(String idTransp, double cargaMax, double capacidad, double
			costoKm, int acomp, double costoPorAcom) {								//COMPLETAR v 1.0
		
		Flete flet = new Flete (idTransp, cargaMax, capacidad, false, costoKm, acomp, costoPorAcom);
		transportes.put(idTransp, flet);
		
	}
	
	void asignarDestino(String idTransp, String destino) {  //COMPLETAR v 1.0
		
		if (transportes.containsKey(idTransp)  && viajes.containsKey(destino)) {
			transportes.get(idTransp).asignarDestino(destino);
		}		
		
	}
	
	boolean incorporarPaquete(String destino, double peso, double volumen, boolean frio) { //COMPLETAR v1.0
		
		for (Deposito dep: depositos) {			
			if (dep.incorporarPaquete(destino, peso, volumen, frio)==true)
				return true;					
		}
		return false;
		
	}
	
	double cargarTransporte(String idTransp) { //COMPLETAR 
		return 0;
	}
	
	void iniciarViaje(String idTransp) {    	//COMPLETAR
		
	}
	
	void finalizarViaje(String idTransp) {		//COMPLETAR
		
	}
	
	double obtenerCostoViaje(String idTransp) {		//COMPLETAR
		return 0;
	}
	
	String obtenerTransporteIgual(String idTransp) {
		return null;
	}
	
	
}
