package bl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dl.Enpresa;
import dl.Eskaintzak;
import dl.Eskariak;
import dl.Ikaslea;


@Singleton
@LocalBean
public class zerbitzuEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	public void enpresaGehitu(Enpresa e){
	//---------------------------------------------------	
		try
    	{
    		em.createNamedQuery("IkasleaEntity.findUser").setParameter("username", e.getUsername()).getSingleResult();
    		
    		//Enpresa jadanik existitzen dela dioen errorea falta da!
    	}
    	catch(Exception o)
		{
    		em.persist(e);//Soilik gorde na hori ez badago
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
			Enpresa e=(Enpresa)em.createNamedQuery("Enpresa.findUser").setParameter("username", username).getSingleResult();
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
	 
		
	 
	 
	 
	 
	 
}
