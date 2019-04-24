package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Eskariak database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Eskariak.findAll", query="SELECT e FROM Eskariak e"),
	@NamedQuery(name="Eskariak.findIkasle", query="SELECT e FROM Eskariak e WHERE e.ikaslea.nan = :nan"),
	@NamedQuery(name="Eskariak.findEnpresa", query="SELECT e FROM Eskariak e WHERE e.eskaintzak.enpresa.idEnpresa = :id")
	
})

public class Eskariak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEskariak;
	
	private int egoera;
	
	private String mezua;
	

	//uni-directional many-to-one association to Eskaintzak
	@ManyToOne
	@JoinColumn(name="Eskaintzak_idEskaintzak")
	private Eskaintzak eskaintzak;

	//uni-directional many-to-one association to Ikaslea
	@ManyToOne
	@JoinColumn(name="Ikaslea_NAN")
	private Ikaslea ikaslea;
	
	

	public Eskariak() {
	}
	
	public Eskariak(int idEskaria, Ikaslea ikasle,String mezua)
	{
		this.idEskariak=idEskaria;
		this.ikaslea=ikasle;
		this.egoera=0;
		this.mezua="Oraindik ez duzu mezurik jaso eskari honen inguruan";
	}

	public int getIdEskariak() {
		return this.idEskariak;
	}

	public void setIdEskariak(int idEskariak) {
		this.idEskariak = idEskariak;
	}

	public Eskaintzak getEskaintzak() {
		return this.eskaintzak;
	}

	public void setEskaintzak(Eskaintzak eskaintzak) {
		this.eskaintzak = eskaintzak;
	}

	public Ikaslea getIkaslea() {
		return this.ikaslea;
	}

	public void setIkaslea(Ikaslea ikaslea) {
		this.ikaslea = ikaslea;
	}

	public int getEgoera() {
		return egoera;
	}

	public void setEgoera(int egoera) {
		this.egoera = egoera;
	}

	public String getMezua() {
		return mezua;
	}

	public void setMezua(String mezua) {
		this.mezua = mezua;
	}

	
	

}