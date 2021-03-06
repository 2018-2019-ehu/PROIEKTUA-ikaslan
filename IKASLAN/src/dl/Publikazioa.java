package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Publikazioa database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Publikazioa.findAll", query="SELECT p FROM Publikazioa p"),
	@NamedQuery(name="Publikazioa.findEnpresa", query="SELECT p FROM Publikazioa p WHERE p.enpresa.idEnpresa= :id")
})

public class Publikazioa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPublikazioa;

	@Column(name="Deskribapena")
	private String deskribapena;

	private String titulua;

	//uni-directional many-to-one association to Enpresa
	@ManyToOne
	@JoinColumn(name="Enpresa_idEnpresa")
	private Enpresa enpresa;

	public Publikazioa() {
	}
	public Publikazioa( String titulua,String deskribapena, Enpresa enpresa) {
		this.titulua=titulua;
		this.deskribapena=deskribapena;
		this.enpresa=enpresa;
		
	}

	public int getIdPublikazioa() {
		return this.idPublikazioa;
	}

	public void setIdPublikazioa(int idPublikazioa) {
		this.idPublikazioa = idPublikazioa;
	}

	public String getDeskribapena() {
		return this.deskribapena;
	}

	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}

	public String getTitulua() {
		return this.titulua;
	}

	public void setTitulua(String titulua) {
		this.titulua = titulua;
	}

	public Enpresa getEnpresa() {
		return this.enpresa;
	}

	public void setEnpresa(Enpresa enpresa) {
		this.enpresa = enpresa;
	}

}