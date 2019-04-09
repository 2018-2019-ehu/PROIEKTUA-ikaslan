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
					return "enpresa";
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
		List<Eskaintzak> eskaintzak=ejb.getListEskaintzak();
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
	
	
	

}
