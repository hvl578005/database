package data1.hib.no;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AvdelingEAO {
	
private EntityManagerFactory ems;
	
	public AvdelingEAO () {
		ems = Persistence.createEntityManagerFactory("ansattPU_JPA");
	}
	
	public Avdeling finnAvdelingMedid(int avdelingid) {
		
		EntityManager em = ems.createEntityManager();
		Avdeling avdeling;

		try {
			avdeling = em.find(Avdeling.class, avdelingid);

		} finally {
			em.close();
		}
		return avdeling;
	
	

}
}
