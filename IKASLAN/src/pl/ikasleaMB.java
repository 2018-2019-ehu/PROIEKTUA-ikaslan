package pl;



import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

@RequestScoped
@Named
public class ikasleaMB {


	private String NAN;
	private String izena;
	private String email;
	private String username;
	private String pasahitza;
	
	public ikasleaMB(){
		
	}
	public ikasleaMB(String NAN,String izena,String email,String username,String pasahitza){
		this.NAN=NAN;
		this.izena=izena;
		this.email=email;
		this.username=username;
		this.pasahitza=pasahitza;
	}
	public String getNAN() {
		return NAN;
	}
	public void setNAN(String nAN) {
		NAN = nAN;
	}
	public String getIzena() {
		return izena;
	}
	public void setIzena(String izena) {
		this.izena = izena;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasahitza() {
		return pasahitza;
	}
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}
	
}
