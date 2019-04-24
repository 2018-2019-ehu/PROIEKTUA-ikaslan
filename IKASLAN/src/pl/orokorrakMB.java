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
import java.util.ArrayList;
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
	private String arloikaslea = "Denak";
	private String ikasketak;
	Eskariak eskari;
	private boolean ikasleakAgertu=false;

	/////Datu basea betetzeko:
	public void enpresaGorde(EnpresaMB en) throws IOException{ 
		
		Enpresa e = new Enpresa(en.getIzena(),en.getArloa(),en.getDeskribapena(),en.getUsername(),en.getPasahitza());
		ejb.enpresaGehitu(e);
		//FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        //FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
	}
	
	public void ikasleaGorde(ikasleaMB ikaslea){
		
		Ikaslea ikas = new Ikaslea(ikaslea.getNAN(),ikaslea.getIzena(),ikaslea.getEmail(),ikaslea.getUsername(),ikaslea.getPasahitza(),ikaslea.getAbizena(), ikaslea.getJaiotzedata(),ikaslea.getIkasketak(),ikaslea.getArloa());
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
		
		//Ikaslea ialdatu = new Ikaslea(ikaslea.getNAN(),ikaslea.getIzena(),ikaslea.getEmail(),ikaslea.getUsername(),ikaslea.getPasahitza());		
		//i=ejb.ikasleaAldatuDB(ialdatu,i.getNan());
		
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
	public List<Eskariak> ikasleEskaBilatu(String nan){
		
		return ejb.ikasleEskariakBilatu(nan);
	}
	public void eskariaEzabatu(int id){
		ejb.eskariaEzab(id);
	}
	public List<Publikazioa> enpresaPubBilatu(int id){
		
		return ejb.enpresaPublikazioaBilatu(id);
		
	}
	public void enpresaPubEzabatu(int id){
		ejb.ezabatuPub(id);
	}
	public List<Eskaintzak> enpresaLanBilatu(int id){
		
		return ejb.enpresaLanakBilatu(id);
		
	}
	public void eskaintzaEzab(int id){
		ejb.eskaintzaEzabatu(id);
		
	}

	public String getArloikaslea() {
		return arloikaslea;
	}

	public void setArloikaslea(String arloikaslea) {
		this.arloikaslea = arloikaslea;
	}

	public String getIkasketak() {
		return ikasketak;
	}

	public void setIkasketak(String ikasketak) {
		this.ikasketak = ikasketak;
	}
	public List<String> ikaslearloenLista(){
		
		List<Ikaslea> ikasleak = ejb.getListIkasleak();
		List<String> arloak = new ArrayList<>();
		
		for(int c=0;c<ikasleak.size();c=c+1){
			
			if(!arloak.contains(ikasleak.get(c).getArloa()))
			{
				arloak.add(ikasleak.get(c).getArloa());
			}
			
		}
		return arloak;
	}
	public List<String> lanarloenLista(){
		
		List<Eskaintzak> eskaintzak = ejb.getListEskaintzak();
		List<String> arloak = new ArrayList<>();
		
		for(int c=0;c<eskaintzak.size();c=c+1){
		
			if(!arloak.contains(eskaintzak.get(c).getArloa()))
			{
				
				arloak.add(eskaintzak.get(c).getArloa());
			}
			
		}
		return arloak;
	}
	public List<Ikaslea> getListIkasleak(){
		List<Ikaslea> iList = new ArrayList<>();
		if(arloikaslea.equals("Denak"))
		{
			if(ikasketak.isEmpty())
			{
				iList=ejb.getListIkasleak();//Bilatu denak
			}
			else
			{
				iList=ejb.ikasleIkasketaContains(ikasketak);
			}
		}
		else
		{
			if(ikasketak.isEmpty())
			{
				iList= ejb.ikasleArloa(arloikaslea);//bilatu arloa ikaslea
			}
			else
			{
				iList=ejb.ikasleArloaIkas(arloikaslea, ikasketak);
			}
		}
		
	
		return iList;
	}
	public List<Ikaslea> ikasleaBilatu(){
		ikasleakAgertu=true;
		return getListIkasleak();
	}

	public boolean isIkasleakAgertu() {
		return ikasleakAgertu;
	}

	public void setIkasleakAgertu(boolean ikasleakAgertu) {
		this.ikasleakAgertu = ikasleakAgertu;
	}
	
	public List<Eskariak> enpresaEskariakBilatu(int id){
		
		return ejb.enpresaEskaBilatu(id);
		
	}
	
	public void eskariaAldatu(eskariaMB eskaria,int id){
		System.out.println(eskaria.getEgoera());
		System.out.println(eskaria.getMezua());
		System.out.println(id);
		ejb.eskariaAlda(id, eskaria.getEgoera(), eskaria.getMezua());
		
	}
	
}
