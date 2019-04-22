package pl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class publikazioaMB {
	
	private String titulua;
	private String deskribapena;
	public String getTitulua() {
		return titulua;
	}
	public void setTitulua(String titulua) {
		this.titulua = titulua;
	}
	public String getDeskribapena() {
		return deskribapena;
	}
	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}
	
	

}
