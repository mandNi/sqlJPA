package esn.data;

import javax.persistence.EntityManager;

import esn.jpa.EntitySingleton;

public class ESN {

    private EntityManager persistance;
    private ManagerClient mc;
    private ManagerProjet mp;
    private ManagerEmploye me;
    //private ManagerDepartement md;

    public ESN() {
        this.persistance=EntitySingleton.getManager();
        this.mc = new ManagerClient();
        this.mp = new ManagerProjet();
        this.me = new ManagerEmploye();
        //this.md = new ManagerDepartement();
    }

    public void debuter() {
        this.persistance.getTransaction().begin();
    }

    public ManagerClient getManagerClient() {
        return mc;
    }

    public ManagerProjet getManagerProjet() {
        return mp;
    }

    public ManagerEmploye getManagerEmploye() {
        return me;
    }

    public void valider() {
        this.persistance.getTransaction().commit();

    }
}
