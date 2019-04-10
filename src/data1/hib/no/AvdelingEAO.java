package data1.hib.no;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
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
	
	
	public void oppdaterAnsattAvdeling(int id, int avdelingid) {
		
		boolean sjefer = false;
		
		EntityManager em = ems.createEntityManager();
		Ansatt ansatt = new Ansatt();
		Avdeling avd = new Avdeling();
		AnsattEAO ansEAO = new AnsattEAO();
		AvdelingEAO avdEAO = new AvdelingEAO();
		
		ansatt.setId(id);
		ansatt = ansEAO.finnAnsattMedID(id);
		avd.setAvdelingid(ansatt.getAvdelingid());
		avd = avdEAO.finnAvdelingMedid(avdelingid);
		int sjefid = avd.getSjefid();
		Ansatt sjef = ansEAO.finnAnsattMedID(sjefid);
		
		if (sjef.getId() == id) {
			System.out.println("Personen kan ikke endre avdeling siden den er sjef.");
			sjefer = true;
		} else {
			try {
				ansatt = em.find(Ansatt.class, id);
				em.getTransaction().begin();
				ansatt.setAvdelingid(avdelingid);
				em.merge(ansatt);
				em.getTransaction().commit();
				} catch (Throwable e) {
				e.printStackTrace();
				if (em.getTransaction().isActive()) {
					em.getTransaction().rollback();
				}
			} finally {
				em.close();
			}
			
		}
}
	
	public void leggTilAvdeling(String navn, int sjefid) {
		EntityManager em = ems.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		boolean eksisterer = false;
		
		Avdeling avdeling = new Avdeling();
		avdeling.setNavn(navn);
		avdeling.setSjefid(sjefid);
		Ansatt ansat = new Ansatt();
		ansat.setId(avdeling.getSjefid());
		AnsattEAO eao = new AnsattEAO();
		ansat = eao.finnAnsattMedID(ansat.getId());
		
		for (int i = 1; i<100; i++) {
			if (i == sjefid) {
				eksisterer = true;
			} else {
				i++;
			}
		}
		
		if (eksisterer = true) {
			try {
				tx.begin();
				em.persist(avdeling);
				tx.commit();
				tx.begin();
				ansat.setAvdelingid(avdeling.getAvdelingid());
				em.merge(ansat);
				tx.commit();
			} catch (Throwable e) {
				e.printStackTrace();
				if (tx.isActive()) {
					tx.rollback();
				}
			} finally {
				em.close();
			 
			}
		} else if (eksisterer = false) {
			System.out.println("Den ansatte eksisterer ikke.");
		}
		
		
	}
	
	
	
		
	}
	
	
