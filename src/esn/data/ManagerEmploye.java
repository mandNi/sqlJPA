package esn.data;

import java.time.LocalDate;

import javax.persistence.*;

import esn.jpa.EntitySingleton;

public class ManagerEmploye {

    private EntityManager persistance;

    public ManagerEmploye() {
        this.persistance=EntitySingleton.getManager();
    }

    public Employe ajouterEmploye(String nom, String prenom, String email, LocalDate dateEmbauche, Float salaire) throws AppliException {
        Employe en = new Employe();
        en.setNom(nom);
        en.setPrenom(prenom);
        en.setEmail(email);
        en.setDateEmbauche(dateEmbauche);
        en.setSalaire(salaire);
        try {
            persistance.persist(en);
        }catch(Exception e) {
            throw new AppliException(e);
        }
        return en;
    }

}
