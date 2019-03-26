package pl;

import javax.enterprise.context.RequestScoped;

import javax.inject.Named;
import java.io.Serializable;

@RequestScoped
@Named
public class AuxMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int kontuaSortuAux;
	
	

	public int getKontuaSortuAux() {
		return kontuaSortuAux;
	}

	public void setKontuaSortuAux(int kontuaSortuAux) {
		this.kontuaSortuAux = kontuaSortuAux;
	}

}
