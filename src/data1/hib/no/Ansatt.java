package data1.hib.no;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (schema = "oblig3", name ="Ansatt")
public class Ansatt {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private LocalDate ansettelsesDato;
	private String stilling;
	private String maanedslonn;
	
	@ManyToOne
	@JoinColumn(name = "avdelingid", referencedColumnName = "avdelingid")
	private Avdeling avdeling;
	
	public Ansatt (int id, String brukernavn, String fornavn, String etternavn, LocalDate ansettelsesdato, String stilling, String maanedslonn) {
		this.id = id;
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansettelsesDato = ansettelsesdato;
		this.stilling = stilling;
		this.maanedslonn = maanedslonn;
	}
	
	public Ansatt() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public LocalDate getAnsettelsesDato() {
		return ansettelsesDato;
	}

	public void setAnsettelsesDato(LocalDate ansettelsesDato) {
		this.ansettelsesDato = ansettelsesDato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public String getMaanedslonn() {
		return maanedslonn;
	}

	public void setMaanedslonn(String maanedslonn) {
		this.maanedslonn = maanedslonn;
	}
	
	

	@Override
	public String toString() {
		return "Ansatt [id=" + id + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn=" + etternavn
				+ ", ansettelsesDato=" + ansettelsesDato + ", stilling=" + stilling + ", maanedslonn=" + maanedslonn
				+ "]";
	}
	

	
	
	

}
