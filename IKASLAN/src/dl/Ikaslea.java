package dl;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Ikaslea database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Ikaslea.findAll", query="SELECT i FROM Ikaslea i"),
	@NamedQuery(name="Ikaslea.findUser", query="SELECT i FROM Ikaslea i WHERE i.username = :username")
			})


public class Ikaslea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="NAN")
	private String nan;

	@Column(name="Abizena")
	private String abizena;

	@Column(name="Arloa")
	private String arloa;

	@Column(name="Email")
	private String email;

	@Column(name="Ikasketak")
	private String ikasketak;

	@Column(name="Izena")
	private String izena;

	@Temporal(TemporalType.DATE)
	@Column(name="JaiotzeData")
	private Date jaiotzeData;

	private String pasahitza;

	private String username;

	public Ikaslea() {
	}
	public Ikaslea(String nan,String izena,String email,String username,String pasahitza) {
		this.nan=nan;
		this.izena=izena;
		this.email=email;
		this.username=username;
		this.pasahitza=pasahitza;
	}

	public String getNan() {
		return this.nan;
	}

	public void setNan(String nan) {
		this.nan = nan;
	}

	public String getAbizena() {
		return this.abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public String getArloa() {
		return this.arloa;
	}

	public void setArloa(String arloa) {
		this.arloa = arloa;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIkasketak() {
		return this.ikasketak;
	}

	public void setIkasketak(String ikasketak) {
		this.ikasketak = ikasketak;
	}

	public String getIzena() {
		return this.izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public Date getJaiotzeData() {
		return this.jaiotzeData;
	}

	public void setJaiotzeData(Date jaiotzeData) {
		this.jaiotzeData = jaiotzeData;
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