package pl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class eskaintzaMB {
	

	private String deskribapena;
	private String iraupena;
	private String lekua;
	private String ordutegia;
	private String arloa;
	private String soldata;

	public String getDeskribapena() {
		return deskribapena;
	}
	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}
	public String getIraupena() {
		return iraupena;
	}
	public void setIraupena(String iraupena) {
		this.iraupena = iraupena;
	}
	public String getLekua() {
		return lekua;
	}
	public void setLekua(String lekua) {
		this.lekua = lekua;
	}
	public String getOrdutegia() {
		return ordutegia;
	}
	public void setOrdutegia(String ordutegia) {
		this.ordutegia = ordutegia;
	}
	public String getArloa() {
		return arloa;
	}
	public void setArloa(String arloa) {
		this.arloa = arloa;
	}
	public String getSoldata() {
		return soldata;
	}
	public void setSoldata(String soldata) {
		this.soldata = soldata;
	}
	
	

}
