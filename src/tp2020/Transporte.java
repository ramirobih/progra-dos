package tp2020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public abstract class Transporte {
	
	private ArrayList <Paquete> cargaPaquetes;
	private String idTransporte;
	private double cargaMax;	//peso
	private double capacidad;	//volumen
	private boolean frigorifico;
	private double costoKm; 
	private String destino;
	private boolean enViaje;
	protected Viaje viajeDestino;
	protected double costoCargaDep;
	protected String tipoTransp;
	
	public Transporte (String idTransporte, double cargaMax,
			double capacidad, boolean frigorifico, double costoKm, String tipoTransp) {
		this.cargaPaquetes = new ArrayList<Paquete>();
		this.idTransporte = idTransporte;
		this.cargaMax = cargaMax;
		this.capacidad = capacidad;
		this.frigorifico = frigorifico;
		this.costoKm = costoKm;
		this.costoCargaDep = 0;
		
	}	
	

	public String getDestino() {
		return viajeDestino.getDestino();
	}

	
	
	public String getTipoTransp() {
		return tipoTransp;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getIdTransporte() {
		return idTransporte;
	}


	public double getCostoCargaDep() {
		return costoCargaDep;
	}


	protected void setCostoCargaDep(double costoCargaDep) {
		this.costoCargaDep = costoCargaDep;
	}


	public double getCostoKm() {
		return costoKm;
	}


	public Viaje getViajeDestino() {
		return viajeDestino;
	}


	public void setViajeDestino(Viaje viajeDestino) {
		this.viajeDestino = viajeDestino;
	}

	
	public boolean isEnViaje() {
		return enViaje;
	}
	 
	
	//Trailer Comun: destino < 500km
	//Megatrailer : destino > 500km
	

	public void setEnViaje(boolean enViaje) {
		this.enViaje = enViaje;
	}


	abstract void asignarDestino(Viaje destino);
	
	abstract double obtenerCostoViaje ();
	
	public boolean cargarTransporte (Paquete paq) {
		
		if (paq.isRefrigeracion()==frigorifico && 
				paq.getPesoPaquete()<=this.cargaMax && paq.getVolumenPaquete()<=this.capacidad) {
			
			this.cargaMax = this.cargaMax - paq.getPesoPaquete();
			this.capacidad = this.capacidad - paq.getVolumenPaquete();
			cargaPaquetes.add(paq);
			return true;
		}
		return false;	 
	}
	
	
	
	void ordenarPaquetes() {
		
		Collections.sort(cargaPaquetes, new Comparator<Paquete>() {
	        @Override
	        public int compare(Paquete paq2, Paquete paq1)
	        {
	        	
	        	if(paq1.getVolumenPaquete()<paq2.getVolumenPaquete())
	                return -1;
	        	else if(paq2.getVolumenPaquete()<paq1.getVolumenPaquete())
	                return 1;
	        	return 0;
	        }
	    });
	}
	
	public void iniciarViaje () {					//COMPLETAR v 1.1
		if (cargaPaquetes.size()==0 )
			throw new RuntimeException ("El transporte esta vacio");
		
		this.enViaje=true;
	}
	
	
	
	public void finalizarViaje () {					//COMPLETAR  v 1.3
		
		vaciarCarga();				//Vacion la carga
		setDestino(null);			//Elimino destino	
		setViajeDestino(null);		//Elimino viaje
		setEnViaje(false);			//Actualizo estado
		
	}

	public void vaciarCarga () {		//COMPLETAR v 1.1
	
		double capacidadLiberada=0;
		
		for (Paquete p: cargaPaquetes) {
			capacidadLiberada = capacidadLiberada + p.getVolumenPaquete();  
		}
		this.capacidad= this.capacidad + capacidadLiberada;			//Seteo a capacidad inicial del transp
		cargaPaquetes.clear();										//vacio carga de paquetes
	}	
			
	
	 	
	public boolean equals(Object obj) {
			
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transporte other = (Transporte) obj;
		ordenarPaquetes();
		other.ordenarPaquetes();
		if (cargaPaquetes == null) {
			if (other.cargaPaquetes != null)
				return false;
		} else if (!cargaPaquetes.equals(other.cargaPaquetes))
			return false;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (tipoTransp == null) {
			if (other.tipoTransp != null)
				return false;
		} else if (!tipoTransp.equals(other.tipoTransp))
			return false;
		return true;
	}	 
	  
	
	
}
