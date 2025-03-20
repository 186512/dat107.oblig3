package oblig3;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;


public class AnsattDAO {
	
	 private EntityManagerFactory emf;
	 
	 
	 public AnsattDAO() {
	        emf = Persistence.createEntityManagerFactory("AnsattPU");
	    }
	 
	 public Ansatt HentAnsattId(int ansattId) {
		 
	        EntityManager em = emf.createEntityManager();
	        try {
	      
	      
	        	return em.find(Ansatt.class, ansattId);
	        	
	        } finally {
	            em.close();
	        }
	    
		 
	 }
	 public Ansatt soekEtterBrukernavn(String brukernavn) {
		 
		 EntityManager em = emf.createEntityManager();
		 try {
				
			 return em.createQuery("SELECT a FROM Ansatt a WHERE a.brukernavn = :brukernavn", Ansatt.class)
	                 .setParameter("brukernavn", brukernavn)
	                 .getSingleResult();
			 
	    } catch (NoResultException e) {
	    	
	        return null;  
	        
		}finally { 	 
			em.close();
		 }
			 
	 }
	
	 
	 
	 public List<Ansatt> hentAlleAnsatte(EntityManager em) {
		    return em.createQuery("SELECT a FROM Ansatt a", Ansatt.class)
		    .getResultList();
	 }
	    
		 
	 
	 public void nyAnsatt(Ansatt ansatt) {
		   EntityManager em = emf.createEntityManager();
	        try {
	        	em.getTransaction();
	        	em.persist(ansatt);
	        	em.getTransaction().commit();
	        }
	        catch (PersistenceException e){
	        	em.getTransaction().rollback();
	        	e.printStackTrace();
	     
	        } finally {
	            em.close();
	        }
		 
		 
	 
	    
		 
	 }
	 public void oppdaterEksiterendeAnsatt(int ansattId, Ansatt oppdatertAnsatt) {
		 
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
			try {
				transaction.begin();
				
				Ansatt eksisterendeAnsatt = em.find(Ansatt.class, ansattId);
				
				if(eksisterendeAnsatt != null) {
					eksisterendeAnsatt.setansattId(oppdatertAnsatt.getAnsattId());
					eksisterendeAnsatt.setFornavn(oppdatertAnsatt.getFornavn());
					eksisterendeAnsatt.setEtternavn(oppdatertAnsatt.getEtternavn());
					eksisterendeAnsatt.setAnsettelsesdato(oppdatertAnsatt.getAnsettelsesdato());
					eksisterendeAnsatt.setStilling(oppdatertAnsatt.getStilling());
					eksisterendeAnsatt.setMaanedslonn(oppdatertAnsatt.getMaanedslonn());
					
					em.merge(eksisterendeAnsatt);
				}else {
					System.out.println("Ansatt med ID " + ansattId + " finnes ikke.");
				}
				
				transaction.commit();
				
			} catch(PersistenceException e) {
				if(transaction.isActive()) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
			finally {
				
				em.close();
			}
		  
	 }
	 
	
	

}

