package pl;





import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

@RequestScoped
@Named
public class ikasleaMB {


	private String NAN;
	private String izena;
	private String abizena;
	private String email;
	private String jaiotzedata;
	private String username;
	private String pasahitza;
	private String ikasketak;
	private String arloa;
	public ikasleaMB(){
		
	}
	public ikasleaMB(String NAN,String izena,String email,String username,String pasahitza,String abizena,String jaiotzedata,String ikasketak,String arloa){
		this.NAN=NAN;
		this.izena=izena;
		this.email=email;
		this.username=username;
		this.pasahitza=pasahitza;
		this.abizena=abizena;
		this.jaiotzedata=jaiotzedata;
		this.ikasketak=ikasketak;
		this.arloa=arloa;
	}
	public String getNAN() {
		return NAN;
	}
	public void setNAN(String nAN) {
		NAN = nAN;
	}
	
	public String getAbizena() {
		return abizena;
	}
	public void setAbizena(String abizena) {
		this.abizena = abizena;
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
	public String getJaiotzedata() {
		return jaiotzedata;
	}
	public void setJaiotzedata(String jaiotzedata) {
		this.jaiotzedata = jaiotzedata;
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
	public String getIkasketak() {
		return ikasketak;
	}
	public void setIkasketak(String ikasketak) {
		this.ikasketak = ikasketak;
	}
	public String getArloa() {
		return arloa;
	}
	public void setArloa(String arloa) {
		this.arloa = arloa;
	}
	
	
}
