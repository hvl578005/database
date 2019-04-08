package data1.hib.no;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import data1.hib.no.Ansatt;

import java.time.LocalDate;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		
		/*AnsattEAO ansattEAO = new AnsattEAO();
		Ansatt ansatt = ansattEAO.finnAnsattMedID(123456);
		System.out.println(ansatt);
		/*Ansatt ansatt1 = ansattEAO.finnAnsattMedBrukernavn("aaa");
		System.out.println(ansatt1);*/
		
		/*List<Ansatt> ansatte = ansattEAO.utListingAvAnsatte();
		System.out.println("Utlisting av ansatte:");
		System.out.println("   " + ansatte);
		
		List<Ansatt> brukernavn = ansattEAO.finnAnsattMedBrukernavn("kbh");
		System.out.println("Ansatt med brukernavn: kbh");
		System.out.println("   " + brukernavn);
		
		Ansatt ansatt2 = ansattEAO.finnAnsattMedID(123456);
		System.out.println(ansatt2);
		ansattEAO.oppdaterAnsattLonn(123456, "100 000");
		System.out.println(ansatt2);
		
		ansattEAO.leggTilAnsatt("tst", "Tiril", "Ericson", LocalDate.parse("2019-04-03"), "Konsulent", "50 000");
		System.out.println(ansattEAO.finnAnsattMedBrukernavn("tst"));*/
		
		AvdelingEAO avdelingEAO = new AvdelingEAO();
		Avdeling avdeling = avdelingEAO.finnAvdelingMedid(3);
		System.out.println(avdeling);
		

	}

}
