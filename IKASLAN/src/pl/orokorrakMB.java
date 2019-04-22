package pl;

import java.io.IOException;

import javax.ejb.EJB;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


import bl.zerbitzuEJB;
import dl.Enpresa;
import dl.Eskaintzak;
import dl.Eskariak;
import dl.Ikaslea;
import dl.Publikazioa;

import java.io.Serializable;

import java.util.List;


@SessionScoped
@Named
public class orokorrakMB implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public orokorrakMB() {
		// TODO Auto-generated constructor stub
	}
	
	@EJB
	private zerbitzuEJB ejb;
	Ikaslea i;
	Enpresa e;
	Publikazioa pub;
	private boolean eskaintzakAgertu=false;
	private String arloa= "Denak";
	private String enpresa= "Denak";
	Eskariak eskari;
	
	/////Datu basea betetzeko:
	public void enpresaGorde(EnpresaMB en) throws IOException{ 
		
		Enpresa e = new Enpresa(en.getIzena(),en.getArloa(),en.getDeskribapena(),en.getUsername(),en.getPasahitza());
		ejb.enpresaGehitu(e);
		//FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        //FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
	}
	
	public void ikasleaGorde(ikasleaMB ikaslea){
		Ikaslea ikas = new Ikaslea(ikaslea.getNAN(),ikaslea.getIzena(),ikaslea.getEmail(),ikaslea.getUsername(),ikaslea.getPasahitza());
		ejb.ikasleaGehitu(ikas);
		
	}
	
	////Login eta logout funtzioak
	public String login(loginMB log){
		
		if(log.getA()==1){
			
			i=ejb.ikasleaLogin(log.getUsernameLog());
			if(i!=null)
			{
			
				if(log.getPasahitzaLog().equals(i.getPasahitza())){
					return "ikasleaHome";
				}else{
					return "erroreaPasahitza";
				}
			}
			else
			{
				return "erroreaErabiltzailea";
			}
			
			
		}
		else{
			
			e=ejb.enpresaLogin(log.getUsernameLog());
			if(e!=null)
			{
				if(log.getPasahitzaLog().equals(e.getPasahitza()))
				{
					return "enpresaHome";
				}
				else
				{
					return "erroreaPasahitza";
				}
				
			}
			else
			{
				return "erroreaErabiltzailea";
			}
		}
		
			
			
		
	}
	public void logout() throws IOException{
		
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
       
	}

	//Datu basea betetzeko
	public void ikasleaAldatu(ikasleaMB ikaslea){
		
		Ikaslea ialdatu = new Ikaslea(ikaslea.getNAN(),ikaslea.getIzena(),ikaslea.getEmail(),ikaslea.getUsername(),ikaslea.getPasahitza());		
		i=ejb.ikasleaAldatuDB(ialdatu,i.getNan());
		
	}
	public Ikaslea getI() {
		return i;
	}

	public void setI(Ikaslea i) {
		this.i = i;
	}
	
	//-------------------------------------------------------------------
	public List<Ikaslea> getListIkasle()
	{
		List<Ikaslea> ikasle=ejb.getListIkasleak();
		return ikasle;
	}
	public List<Eskaintzak> getListEskaintzak()
	{
		List<Eskaintzak> eskaintzak;
		if(arloa.equals("Denak"))
		{
			if(enpresa.equals("Denak"))
			{
				eskaintzak=ejb.getListEskaintzak();//Bilatu denak
			}
			else
			{
				eskaintzak=ejb.getEskaintzaEnpresa(enpresa);//bilatu enpresa
			}
		}
		else
		{
			if(enpresa.equals("Denak"))
			{
				eskaintzak=ejb.getEskaintzaArloa(arloa);//bilatu arloa
			}
			else
			{
				eskaintzak=ejb.getEskaintzaArloaEnpresa(arloa, enpresa);//bilatu arloaEnpres
			}
		}
		
		
		return eskaintzak;
	}
	public List<Enpresa> getListEnpresak()
	{
		List<Enpresa> enpresak=ejb.getListEnpresak();
		return enpresak;
	}
	public List<Eskariak> getListEskariak()
	{
		List<Eskariak> eskariak=ejb.getListEskariak();
		return eskariak;
	}
	
	public void eskariaGehitu(int idEskaintzak)
	{
		
		Eskariak eskaria=new Eskariak();
		Eskaintzak eskaintza=ejb.getEskaintza(idEskaintzak);
		eskaria.setEskaintzak(eskaintza);
		eskaria.setIkaslea(i);
		eskari=eskaria;
		ejb.eskariaGehitu(eskaria);
	}

	public boolean getEskaintzakAgertu() {
		return eskaintzakAgertu;
	}

	public void setAgertu() {
		this.eskaintzakAgertu = true;
	}

	public String getArloa() {
		return arloa;
	}

	public void setArloa(String arloa) {
		this.arloa = arloa;
	}

	public String getEnpresa() {
		return enpresa;
	}

	public void setEnpresa(String enpresa) {
		this.enpresa = enpresa;
	}
	public void publikazioaGorde(publikazioaMB pub){
		
		Publikazioa pubDB = new Publikazioa(pub.getTitulua(),pub.getDeskribapena(),e);
		ejb.publikazioaGehitu(pubDB);
	}
	public void eskaintzaGorde(eskaintzaMB esk){
		Eskaintzak eska = new Eskaintzak(esk.getDeskribapena(),esk.getIraupena(),esk.getLekua(),esk.getOrdutegia(),esk.getArloa(),esk.getSoldata(),e);
		ejb.eskaintzaGehitu(eska);
	}
	public List<Publikazioa> irakurriPub(){
		return ejb.irakurriPubli();
	}
	
	public void pubBista(int id){
		pub = ejb.publikazioaBilatu(id);
		
	}

	public Publikazioa getPub() {
		return pub;
	}

	public void setPub(Publikazioa pub) {
		this.pub = pub;
	}
	
	
	public List<Eskaintzak> lanaBilatu(){
		
		eskaintzakAgertu=true;
		return getListEskaintzak();
		
		
	}

	public Eskariak getEskari() {
		return eskari;
	}

	public void setEskari(Eskariak eskari) {
		this.eskari = eskari;
	}
	
	public void ikasleaEzabatu(String nan){
		ejb.ikasleaEzab(nan);
	}
	public void enpresaEzabatu(int id){
		ejb.enpresaEzab(id);
		
	}

	public Enpresa getE() {
		return e;
	}

	public void setE(Enpresa e) {
		this.e = e;
	}
	
}
