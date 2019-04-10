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
		//ansattEAO.utListingAvAnsatte();
		
		//avd.utlistingAvAlleAnsatteIAvdeling(4);
		
		avd.oppdaterAnsattAvdeling(3, 4);
		
	System.out.println(ansattEAO.finnAnsattMedID(3));
	
	//avd.oppdaterAnsattAvdeling(10, 4);
	
	
	System.out.println(ansattEAO.finnAnsattMedID(11));
	
	
	
	System.out.println(ansattEAO.finnAnsattMedID(14));
	
	System.out.println(ansattEAO.finnAnsattMedID(4));
	
	System.out.println(ansattEAO.finnAnsattMedID(13));
	
	System.out.println(ansattEAO.finnAnsattMedID(7));
	
	System.out.println(ansattEAO.finnAnsattMedID(8));
	
	
	
	
	}

}
