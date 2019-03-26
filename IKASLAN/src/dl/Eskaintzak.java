package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Eskaintzak database table.
 * 
 */
@Entity
@NamedQuery(name="Eskaintzak.findAll", query="SELECT e FROM Eskaintzak e")
public class Eskaintzak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idEskaintzak;

	@Column(name="Deskribapena")
	private String deskribapena;

	@Column(name="Iraupena")
	private String iraupena;

	@Column(name="Lekua")
	private String lekua;

	@Column(name="Ordutegia")
	private String ordutegia;

	@Column(name="Postua")
	private String postua;

	@Column(name="Soldata")
	private String soldata;

	//uni-directional many-to-one association to Enpresa
	@ManyToOne
	@JoinColumn(name="Enpresa_idEnpresa")
	private Enpresa enpresa;

	public Eskaintzak() {
	}

	public int getIdEskaintzak() {
		return this.idEskaintzak;
	}

	public void setIdEskaintzak(int idEskaintzak) {
		this.idEskaintzak = idEskaintzak;
	}

	public String getDeskribapena() {
		return this.deskribapena;
	}

	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}

	public String getIraupena() {
		return this.iraupena;
	}

	public void setIraupena(String iraupena) {
		this.iraupena = iraupena;
	}

	public String getLekua() {
		return this.lekua;
	}

	public void setLekua(String lekua) {
		this.lekua = lekua;
	}

	public String getOrdutegia() {
		return this.ordutegia;
	}

	public void setOrdutegia(String ordutegia) {
		this.ordutegia = ordutegia;
	}

	public String getPostua() {
		return this.postua;
	}

	public void setPostua(String postua) {
		this.postua = postua;
	}

	public String getSoldata() {
		return this.soldata;
	}

	public void setSoldata(String soldata) {
		this.soldata = soldata;
	}

	public Enpresa getEnpresa() {
		return this.enpresa;
	}

	public void setEnpresa(Enpresa enpresa) {
		this.enpresa = enpresa;
	}

}