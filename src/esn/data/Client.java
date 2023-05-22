package esn.data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@PrimaryKeyJoinColumn (name ="id_personne")
public class Client extends Personne {

    private static final long serialVersionUID = 1L;

    @Column
    private String societe;
    public String getSociete() { return this.societe;}
    public void setSociete(String societe) { this.societe = societe;}


    @Column
    private String role;
    public String getRole() { return this.role;}
    public void setRole(String role) { this.role = role;}

	
    @Column
    private String telephone;
    public String getTelephone() { return this.telephone;}
    public void setTelephone(String telephone) { this.telephone = telephone;}

    
    @OneToMany
    @JoinColumn(name = "id_personne")
    private Set<Projet> projects = new HashSet<Projet>();
    public void addProjet(Projet p) {this.projects.add(p); }
    public void removeProjet(Projet p) {this.projects.remove(p);}
    public Set<Projet> getProjects() {return this.projects ; }
    
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Employe)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client : " + getNom() + " " + getPrenom() + " " + getRole();
    }
    public Client() {
        super();
    }
}
