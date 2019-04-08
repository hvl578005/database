package data1.hib.no;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (schema ="oblig3", name = "Avdeling")
public class Avdeling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdelingid;
	
	private String navn;
	private int sjefid;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name = "sjefid", referencedColumnName = "id")
	private Ansatt ansatt;
	
	@OneToMany(mappedBy = "Avdeling", fetch = FetchType.EAGER)
	private List <Ansatt> ansatte;

	public void leggTilAnsatt(Ansatt ansatt) {
		ansatte.add(ansatt);
	}
	
	public Avdeling (int avdelingid, String navn, int sjefid) {
		this.avdelingid = avdelingid;
		this.navn = navn;
		this.sjefid = sjefid;
	}
	
	public Avdeling () {	
	}

	public int getAvdelingid() {
		return avdelingid;
	}

	public void setAvdelingid(int avdelingid) {
		this.avdelingid = avdelingid;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getSjefid() {
		return sjefid;
	}

	public void setSjefid(int sjefid) {
		this.sjefid = sjefid;
	}

	@Override
	public String toString() {
		return "Avdeling [avdelingid=" + avdelingid + ", navn=" + navn + ", sjefid=" + sjefid + "]";
	}
	
	
	
	

}
