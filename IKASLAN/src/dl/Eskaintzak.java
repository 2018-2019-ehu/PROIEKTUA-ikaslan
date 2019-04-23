package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Eskaintzak database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Eskaintzak.findAll", query="SELECT e FROM Eskaintzak e"),
	@NamedQuery(name="Eskaintzak.findArloaEnpresa",query="SELECT e FROM Eskaintzak e WHERE e.arloa = :arloa and e.enpresa.izena= :izena"),
	@NamedQuery(name="Eskaintzak.findArloa",query="SELECT e FROM Eskaintzak e WHERE e.arloa =:arloa"),
	@NamedQuery(name="Eskaintzak.findEnpresa",query="SELECT e FROM Eskaintzak e WHERE e.enpresa.izena= :izena"),
	@NamedQuery(name="Eskaintzak.findEnpresaLana",query="SELECT e FROM Eskaintzak e WHERE e.enpresa.idEnpresa= :id")
})
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

	@Column(name="Arloa")
	private String arloa;

	@Column(name="Soldata")
	private String soldata;

	//uni-directional many-to-one association to Enpresa
	@ManyToOne
	@JoinColumn(name="Enpresa_idEnpresa")
	private Enpresa enpresa;

	public Eskaintzak() {
	}
	public Eskaintzak(String deskribapena,String iraupena,String lekua,String ordutegia,String arloa,String soldata,Enpresa enpresa) {
		this.deskribapena=deskribapena;
		this.iraupena=iraupena;
		this.lekua=lekua;
		this.ordutegia=ordutegia;
		this.arloa=arloa;
		this.soldata=soldata;
		this.enpresa=enpresa;
		
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

	public String getArloa() {
		return this.arloa;
	}

	public void seArloa(String arloa) {
		this.arloa = arloa;
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