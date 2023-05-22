package esn.data;

import javax.persistence.*;

import esn.jpa.EntitySingleton;

public class ManagerClient {

    private EntityManager persistance;
    
    public ManagerClient() {
        this.persistance=EntitySingleton.getManager();
    }

    public Client ajouterClient(String nom, String prenom, String email, String societe, String role, String tel) throws AppliException {
        Client cl = new Client();
        cl.setNom(nom);
        cl.setPrenom(prenom);
        cl.setEmail(email);
        cl.setRole(role);
        cl.setSociete(societe);
        cl.setTelephone(tel);
        try {
            persistance.persist(cl);
        }catch(Exception e) {
            throw new AppliException(e);
        }
        return cl;
    }
    
}
