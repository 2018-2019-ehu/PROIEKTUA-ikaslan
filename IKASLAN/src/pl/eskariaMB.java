package pl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped


public class eskariaMB {
	
	private int egoera;
	private String mezua;
	
	public int getEgoera() {
		return egoera;
	}
	public void setEgoera(int egoera) {
		this.egoera = egoera;
	}
	public String getMezua() {
		return mezua;
	}
	public void setMezua(String mezua) {
		this.mezua = mezua;
	}
	

}
