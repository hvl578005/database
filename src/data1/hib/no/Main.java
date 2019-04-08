package data1.hib.no;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import data1.hib.no.Ansatt;

import java.time.LocalDate;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		AvdelingEAO avd = new AvdelingEAO();
		
		
		
		AnsattEAO ansattEAO = new AnsattEAO();
		
		ansattEAO.leggTilAnsatt("ins", "Hans", "Mørk", LocalDate.parse("2019-01-01"), "kokk", "40000", 1);
		
		ansattEAO.utListingAvAnsatte();
		
	}

}
