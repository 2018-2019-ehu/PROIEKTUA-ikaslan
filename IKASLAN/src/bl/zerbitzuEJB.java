package bl;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dl.Enpresa;
import dl.Ikaslea;

@Singleton
@LocalBean
public class zerbitzuEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	public void enpresaGehitu(Enpresa e){
		
		em.persist(e);
		
	}
	public void ikasleaGehitu(Ikaslea i){
		em.persist(i);
	}

	public Ikaslea ikasleaLogin(String username){
		
		Ikaslea i = (Ikaslea)em.createNamedQuery("Ikaslea.findUser").setParameter("username",username).getSingleResult();
		
		return i;
		
	}
	public Enpresa enpresaLogin(String username)
	{
		Enpresa e=(Enpresa)em.createNamedQuery("Enpresa.findUser").setParameter("username", username).getSingleResult();
		return e;
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
}
