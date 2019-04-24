package bl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import dl.Enpresa;
import dl.Eskaintzak;
import dl.Eskariak;
import dl.Ikaslea;
import dl.Publikazioa;


@Singleton
@LocalBean
public class zerbitzuEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	public void enpresaGehitu(Enpresa e){
	//---------------------------------------------------	
		try{
			em.createNamedQuery("Enpresa.findUsern").setParameter("username", e.getUsername()).getSingleResult();
		
			
    		
    		
    	}
		catch (NoResultException exc) {
			// TODO: handle exception
		
			em.persist(e);//Enpresa jadanik existitzen dela dioen errorea falta da!
    	}
	//----------------------------------------------------	
	}
	public void ikasleaGehitu(Ikaslea i){
	//----------------------------------------------------
		if(em.find(Ikaslea.class, i.getNan())==null)//Ez badu aurkitzen, gorde
		{
			em.persist(i);
		}
		else//Aurkitzen badu NAN hori duen ikaslerik
		{
			//Ikaslea existitzen dela dioen errorea!
		}
	}
	//----------------------------------------------------

	public Ikaslea ikasleaLogin(String username) {
		
		try
		{
			Ikaslea i = (Ikaslea)em.createNamedQuery("Ikaslea.findUser").setParameter("username",username).getSingleResult();
			return i;
		}
		catch(Exception e)
		{
			return null;
		}
		
		
		
	}
	public Enpresa enpresaLogin(String username)
	{
		try
		{
			Enpresa e=(Enpresa)em.createNamedQuery("Enpresa.findUsern").setParameter("username", username).getSingleResult();
			return e;
		}
		catch(Exception e)
		{
			return null;
		}
	}
	public Ikaslea ikasleaAldatuDB(Ikaslea i,String id){
		
		Ikaslea ikasDB = em.find(Ikaslea.class, id);
		if(i.getIzena().length()==0){
			ikasDB.setIzena(i.getIzena());
		}
		if(i.getUsername().length()==0){
			ikasDB.setUsername(i.getUsername());
		}
		return ikasDB;
		
		
	}
	//----------------------------------------------------------------------
	 @SuppressWarnings("unchecked")
	 public List<Eskaintzak> getListEskaintzak()
	  {
		 	List<Eskaintzak> eskaintzak=(List<Eskaintzak>)em.createNamedQuery("Eskaintzak.findAll").getResultList();
	    	return eskaintzak;
	  }
	 
	 @SuppressWarnings("unchecked")
	 public List<Ikaslea> getListIkasleak()
	  {
		 	List<Ikaslea> ikasleak=(List<Ikaslea>)em.createNamedQuery("Ikaslea.findAll").getResultList();
	    	return ikasleak;
	  }
	 @SuppressWarnings("unchecked")
	 public List<Enpresa> getListEnpresak()
	  {
		 	List<Enpresa> enpresak=(List<Enpresa>)em.createNamedQuery("Enpresa.findAll").getResultList();
	    	return enpresak;
	  }
	 @SuppressWarnings("unchecked")
	 public List<Eskariak> getListEskariak()
	  {
		 	List<Eskariak> eskariak=(List<Eskariak>)em.createNamedQuery("Eskariak.findAll").getResultList();
	    	return eskariak;
	  }
	 
	 public void eskariaGehitu(Eskariak eskari)
	 {
		 em.persist(eskari);
	 }
	 public Eskaintzak getEskaintza(int idEskaintza)
	 {
		 Eskaintzak eskaintza=em.find(Eskaintzak.class, idEskaintza);
		 return eskaintza;
	 }
	 @SuppressWarnings("unchecked")
	 public List<Eskaintzak> getEskaintzaArloaEnpresa(String arloa,String enpresa)
	  {
		 	List<Eskaintzak> eskaintzak=(List<Eskaintzak>)em.createNamedQuery("Eskaintzak.findArloaEnpresa").setParameter("arloa", arloa).setParameter("izena", enpresa).getResultList();
	    	return eskaintzak;
	  }
	 @SuppressWarnings("unchecked")
	 public List<Eskaintzak> getEskaintzaArloa(String arloa)
	  {
		 	List<Eskaintzak> eskaintzak=(List<Eskaintzak>)em.createNamedQuery("Eskaintzak.findArloa").setParameter("arloa", arloa).getResultList();
	    	return eskaintzak;
	  }
	 @SuppressWarnings("unchecked")
	 public List<Eskaintzak> getEskaintzaEnpresa(String enpresa)
	  {
		 	List<Eskaintzak> eskaintzak=(List<Eskaintzak>)em.createNamedQuery("Eskaintzak.findEnpresa").setParameter("izena",enpresa).getResultList();
	    	return eskaintzak;
	  }
	 
		
	 public void publikazioaGehitu(Publikazioa p){
		 em.persist(p);
	 }
	 
	 
	 public void eskaintzaGehitu(Eskaintzak eskaintza){
		 em.persist(eskaintza);
	 }
	 
	 @SuppressWarnings("unchecked")
	public List<Publikazioa> irakurriPubli(){
		 return (List<Publikazioa>)em.createNamedQuery("Publikazioa.findAll").getResultList();
	 }
	 public Publikazioa publikazioaBilatu(int id){
		 return em.find(Publikazioa.class, id);
	 }
	 public void ikasleaEzab(String nan){
		 em.remove(em.find(Ikaslea.class, nan));
	 }
	 public void enpresaEzab(int id){
		 
		 em.remove(em.find(Enpresa.class, id));
		 
	 }
	 @SuppressWarnings("unchecked")
	public List<Eskariak> ikasleEskariakBilatu(String nan){
		 
		 return (List<Eskariak>)em.createNamedQuery("Eskariak.findIkasle").setParameter("nan",nan).getResultList();
	 }
	 public void eskariaEzab(int id){
		 
		 em.remove(em.find(Eskariak.class, id));
		 
	 }
	 @SuppressWarnings("unchecked")
	public List<Publikazioa> enpresaPublikazioaBilatu(int id){
		 
		 return (List<Publikazioa>)em.createNamedQuery("Publikazioa.findEnpresa").setParameter("id", id).getResultList();
	 }
	 public void ezabatuPub(int id){
		 
		em.remove(em.find(Publikazioa.class, id));
		 
	 }
	 @SuppressWarnings("unchecked")
	public List<Eskaintzak> enpresaLanakBilatu(int id){
		 
		 return (List<Eskaintzak>)em.createNamedQuery("Eskaintzak.findEnpresaLana").setParameter("id", id).getResultList();
		 
	 }
	 public void eskaintzaEzabatu(int id){
		 em.remove(em.find(Eskaintzak.class,id));
	 }
	 @SuppressWarnings("unchecked")
	public List<Ikaslea> ikasleIkasketaContains(String ikas){
		 
		 return em.createNamedQuery("Ikaslea.findIkasketak").setParameter("ikas", '%'+ikas+'%').getResultList();
		 
	 }
	 @SuppressWarnings("unchecked")
	public List<Ikaslea> ikasleArloa(String arloa){
		 return em.createNamedQuery("Ikaslea.findArloa").setParameter("arloa", arloa).getResultList();
	 }
	 @SuppressWarnings("unchecked")
	public List<Ikaslea> ikasleArloaIkas(String arloa,String ikas){
		 return em.createNamedQuery("Ikaslea.findArloaIkas").setParameter("arloa", arloa).setParameter("ikas", '%'+ikas+'%').getResultList();
	 }
	 @SuppressWarnings("unchecked")
	public List<Eskariak> enpresaEskaBilatu(int id){
		 
		 return em.createNamedQuery("Eskariak.findEnpresa").setParameter("id", id).getResultList();
	 }
	 
	 public void eskariaAlda(int id,int egoera,String mezua){
		 
		 Eskariak e = em.find(Eskariak.class, id);
		 e.setEgoera(egoera);
		 e.setMezua(mezua);
	 }
}
