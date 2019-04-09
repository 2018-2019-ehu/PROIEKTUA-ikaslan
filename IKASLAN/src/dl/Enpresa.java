package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Enpresa database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Enpresa.findAll", query="SELECT e FROM Enpresa e"),
	@NamedQuery(name="Enpresa.findUser", query="SELECT e FROM Enpresa e WHERE e.username = :username")
			})
public class Enpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEnpresa;

	@Column(name="Arloa")
	private String arloa;

	@Column(name="Deskribapena")
	private String deskribapena;

	@Column(name="Izena")
	private String izena;

	private String pasahitza;

	private String username;

	public Enpresa() {
	}
	
	public Enpresa(String izena,String arloa,String deskribapena,String username,String pasahitza) {
		
		this.izena=izena;
		this.arloa=arloa;
		this.deskribapena=deskribapena;
		this.username=username;
		this.pasahitza=pasahitza;
	}

	public int getIdEnpresa() {
		return this.idEnpresa;
	}

	public void setIdEnpresa(int idEnpresa) {
		this.idEnpresa = idEnpresa;
	}

	public String getArloa() {
		return this.arloa;
	}

	public void setArloa(String arloa) {
		this.arloa = arloa;
	}

	public String getDeskribapena() {
		return this.deskribapena;
	}

	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}

	public String getIzena() {
		return this.izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getPasahitza() {
		return this.pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}