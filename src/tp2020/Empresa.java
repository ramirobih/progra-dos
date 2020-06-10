package tp2020;

import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {
	
	private ArrayList <Deposito> depositos;
	private ArrayList <Deposito> depositosTercerizado;
	private HashMap <String, Transporte> transportes;
	private HashMap <String, Viaje> viajes;	
	private HashMap <String, Transporte > transportesEnViaje;	
	private String nombreEmpresa;
	private String cuitEmpresa;
	
	public Empresa(String cuitEmpresa, String nombreEmpresa) {
		super();
		this.depositos = new ArrayList <Deposito>();
		this.depositosTercerizado = new ArrayList <Deposito>();
		this.transportes = new HashMap <String, Transporte>();
		this.viajes = new HashMap <String, Viaje>();
		this.transportesEnViaje = new HashMap <String, Transporte >();
		if ( nombreEmpresa==null)
			throw new RuntimeException ("Valor de variable invalido");
		this.nombreEmpresa = nombreEmpresa;
		if ( cuitEmpresa==null)
			throw new RuntimeException ("Valor de variable invalido");
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
		depositosTercerizado.add(dep);
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
			transportes.get(idTransp).asignarDestino(viajes.get(destino));
		}		
		else
			throw new RuntimeException("No se encontro el transporte o destino"); 
	}
	 
	boolean incorporarPaquete(String destino, double peso, double volumen, boolean frio) { //COMPLETAR v1.1
		
		for (Deposito dep: depositos) {										//Recorro primero los dep propios
			if (dep.incorporarPaquete(destino, peso, volumen, frio)==true)
				return true;					
		}
		for (Deposito dep: depositosTercerizado) {							//Recorro desp los terc
			if (dep.incorporarPaquete(destino, peso, volumen, frio)==true)
				return true;					
		}
		return false;
		
	} 
	
	double cargarTransporte(String idTransp) { //COMPLETAR 
		
		double volumenCargado=0;
		
		Transporte transp = transportes.get(idTransp);
		if (transp.isEnViaje())
			throw new RuntimeException("El transporte esta en viaje");
		if (transp.getDestino()==null)
			throw new RuntimeException("El transporte no tiene destino asignado");
		
		for (Deposito dep : depositos) { 
			volumenCargado+=dep.cargarTransporte(transp);
		}
		for (Deposito depTer : depositosTercerizado) {
			volumenCargado+=depTer.cargarTransporte(transp);
		}
		return volumenCargado; 
	}
	
	void iniciarViaje(String idTransp) {    	//COMPLETAR v 1.2
		if (transportes.containsKey(idTransp)) {
			transportes.get(idTransp).iniciarViaje();
			transportesEnViaje.put(idTransp, transportes.get(idTransp)); //Ingreso a diccionario el viaje iniciado
		}	
		else 
			throw new RuntimeException ("El transporte no pertenece a la Flota");
		
	}
	
	void finalizarViaje(String idTransp) {		//COMPLETAR v 1.1
		if (transportes.containsKey(idTransp)) {
			transportes.get(idTransp).finalizarViaje();
			transportesEnViaje.remove(idTransp);
		}	
		else
			throw new RuntimeException ("El transporte no pertenece a la Flota");
	}
	
	double obtenerCostoViaje(String idTransp) {		//COMPLETAR v 1.2
		
		if (!transportesEnViaje.containsKey(idTransp))
			throw new RuntimeException ("El transporte no esta en viaje");
		
		return transportesEnViaje.get(idTransp).obtenerCostoViaje();
		 
	}
	
	//Devuelve igual trasnp de flota, Iguales si: Mismo tipo transp- mismo destino - misma carga paq
	//return null si no hay
	
	public String obtenerTransporteIgual(String idTransp) {
		
		Transporte t = transportes.get(idTransp);
		
		for(Transporte transp : transportes.values()) {
			if (t.equals(transp) && t.getIdTransporte() != transp.getIdTransporte())
				return transp.getIdTransporte();
		}			
		 
		return null;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Empresa: ");
		sb.append(nombreEmpresa);
		sb.append(", CUIT: ");
		sb.append(cuitEmpresa);
		sb.append(".\n");
		for (Transporte transp : transportes.values()) 
			sb.append(transp.toString());
		/*
		for (Deposito dep : depositos){
			sb.append("Numero de Deposito: "+ depositos.indexOf(dep)+1);
			sb.append(dep.toString());
		}
		for (Deposito depTerc : depositosTercerizado) {
			sb.append("Numero de Deposito: "+ depositosTercerizado.indexOf(depTerc)+1);
			sb.append(depTerc.toString());
		}*/
		return sb.toString();
		/*return "Empresa [Depositos=" + depositos + ", depositosTercerizado=" + depositosTercerizado + ", transportes="
				+ transportes + ", Viajes=" + viajes + ", transportesEnViaje=" + transportesEnViaje + ", nombreEmpresa="
				+ nombreEmpresa + ", cuitEmpresa=" + cuitEmpresa + "]";*/
	}
	
	
	
	
}
