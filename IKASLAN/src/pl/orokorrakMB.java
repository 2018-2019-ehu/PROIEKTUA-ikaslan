package pl;

import java.io.IOException;

import javax.ejb.EJB;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import bl.zerbitzuEJB;
import dl.Enpresa;
import dl.Ikaslea;
import java.io.Serializable;


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
					return "errorea";
				}
			}
			else
			{
				return "errorea";
			}
			
			
		}
		else if(log.getA()==2){
			
			e=ejb.enpresaLogin(log.getUsernameLog());
			if(e!=null)
			{
				if(log.getPasahitzaLog().equals(e.getPasahitza()))
				{
					return "enpresa";
				}
				else
				{
					return "errorea";
				}
				
			}
			else if(e==null)
			{
				return "errorea";
			}
		}
		return "hasiera";
			
			
		
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
	
	
	
	

}
