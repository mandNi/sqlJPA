package esn.data;

import javax.persistence.*;

import esn.jpa.EntitySingleton;

import java.time.LocalDate;
import java.util.List;

public class ManagerProjet {

    private EntityManager persistance;

    // requête pour obtenir la liste des projets
    private TypedQuery<Projet> qlesprojets;

    public ManagerProjet() {
        this.persistance=EntitySingleton.getManager();
        // modifier la chaîne premier paramètre de la méthode createQuery en donnant la bonne requête JPQL
        this.qlesprojets = this.persistance.createQuery("select p from Projet p", Projet.class);
    }

    public Projet ajouterProjet(String nom, LocalDate dateDebut, LocalDate dateFin) throws AppliException {
        Projet p = new Projet();
        p.setNom(nom);
        p.setDateDebut(dateDebut);
        p.setDateFin(dateFin);
        try {
            persistance.persist(p);
            
        } catch(Exception e) {
            throw new AppliException(e);
        }
        return p;
    }

    public void gererParClient(Projet p, Client c) throws AppliException {
    	
    	p.setClient(c);
    	c.addProjet(p);
    	
    	try {
    		
    		this.persistance.persist(p);
    		this.persistance.persist(c);
    		
    	} catch (Exception ex) {
    		
    		throw new AppliException(ex);
    	}
    }

    public void affecterEmploye(Projet p, Employe e) throws AppliException {
    	
    	p.addEmploye(e);
    	e.addProjet(p);
    	
    	try {
    		
    		this.persistance.persist(e);
    		this.persistance.persist(p);
    		
    	} catch (Exception ex) {
    		
    		throw new AppliException(ex);
    	}
    }
    
    public List<Projet> lesProjets( ) {
    	return this.qlesprojets.getResultList();
    }
}
