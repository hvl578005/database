package data1.hib.no;

import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


public class AnsattEAO {
	
	private EntityManagerFactory emf;
	
	public AnsattEAO () {
		emf = Persistence.createEntityManagerFactory("ansattPU_JPA");
	}
	
	public Ansatt finnAnsattMedID(int ID) {
		
		EntityManager em = emf.createEntityManager();
		Ansatt ansatt;

		try {
			ansatt = em.find(Ansatt.class, ID);

		} finally {
			em.close();
		}
		return ansatt;
	}
	
	
	public List<Ansatt> finnAnsattMedBrukernavn(String brukernavn) {
		EntityManager em = emf.createEntityManager();
		
		List<Ansatt> ansatt;
		
		try {
			TypedQuery<Ansatt> query = em.createQuery(
					"SELECT t FROM Ansatt t WHERE t.brukernavn LIKE :brukernavn", Ansatt.class);
			query.setParameter("brukernavn", brukernavn);
			ansatt = query.getResultList();
		} finally {
			em.close();
		}
		return ansatt;
	
	}
	
	
	public List<Ansatt> utListingAvAnsatte() {
		
		EntityManager em = emf.createEntityManager();
		
		List<Ansatt> ansatte;
		
		try {
			TypedQuery<Ansatt> query = em.createQuery(
					"SELECT t FROM Ansatt t", Ansatt.class);
			ansatte = query.getResultList();	
			System.out.println(ansatte.toString());
			
		} finally {
			em.close();
		}
		return ansatte;
	}
	
	
	public void oppdaterAnsattLonn(int id, String maanedslonn) {
		EntityManager em = emf.createEntityManager();
		Ansatt ansatt;
		
		
		try {
			ansatt = em.find(Ansatt.class, id);
			em.getTransaction().begin();
			ansatt.setMaanedslonn(maanedslonn);
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
	
	
	public void leggTilAnsatt(String brukernavn, String fornavn, String etternavn,
			LocalDate ansettelsesdato, String stilling, String maanedslonn, int avdelingid) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Ansatt ansatt = new Ansatt();
		ansatt.setBrukernavn(brukernavn);
		ansatt.setFornavn(fornavn);
		ansatt.setEtternavn(etternavn);
		ansatt.setAnsettelsesDato(ansettelsesdato);
		ansatt.setStilling(stilling);
		ansatt.setMaanedslonn(maanedslonn);
		ansatt.setAvdelingid(avdelingid);
		
		try {
			tx.begin();
			em.persist(ansatt);
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			if (tx.isActive()) {
				tx.rollback();
			}
		} finally {
			em.close();
		 
		}
	}
	

}
