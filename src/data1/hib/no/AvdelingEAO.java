package data1.hib.no;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	
	
	public List<Ansatt> utlistingAvAlleAnsatteIAvdeling(int avdelingid) {
		Avdeling avd = new Avdeling();
		avd.setAvdelingid(avdelingid);
		avd = finnAvdelingMedid(avdelingid);
		
		AnsattEAO ansattEAO = new AnsattEAO();
		Ansatt sjef = new Ansatt();
		sjef.setId(avd.getSjefid());
		sjef = ansattEAO.finnAnsattMedID(sjef.getId());
		
		
		EntityManager em = ems.createEntityManager();
		List<Ansatt> ansatteiAvdeling;
		
		try {
			TypedQuery<Ansatt> query = em.createQuery(
					"SELECT t FROM Ansatt t WHERE t.avdelingid = :avdelingid", Ansatt.class);
					query.setParameter("avdelingid", avdelingid);
			ansatteiAvdeling = query.getResultList();
			System.out.println(ansatteiAvdeling.toString());		
		} finally {
			em.close();
		}
		
		System.out.println("Sjef i avdelingen er: " + sjef.toString());
		
			
		return ansatteiAvdeling;
		
	}
	
	
	
	
	
	
	
	
	
}
