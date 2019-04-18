package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Eskariak database table.
 * 
 */
@Entity
@NamedQuery(name="Eskariak.findAll", query="SELECT e FROM Eskariak e")
public class Eskariak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEskariak;

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
	
	public Eskariak(int idEskaria, Ikaslea ikasle)
	{
		this.idEskariak=idEskaria;
		this.ikaslea=ikasle;
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

}