package pl;




import javax.enterprise.context.RequestScoped;


import javax.inject.Named;



@RequestScoped
@Named
public class EnpresaMB  {

	private String izena;
	private String arloa;
	private String deskribapena;
	private String username;
	private String pasahitza;
	
	public EnpresaMB(){
		
	}
	
	public EnpresaMB(String izena,String arloa,String deskribapena,String username,String pasahitza){
		
		this.izena=izena;
		this.arloa=arloa;
		this.deskribapena=deskribapena;
		this.username=username;
		this.pasahitza=pasahitza;
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

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getArloa() {
		return arloa;
	}

	public void setArloa(String arloa) {
		this.arloa = arloa;
	}

	public String getDeskribapena() {
		return deskribapena;
	}

	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}
	
	
	
	
}
