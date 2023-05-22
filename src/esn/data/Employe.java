package esn.data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;


@Entity
@PrimaryKeyJoinColumn (name ="id_personne")
public class Employe  extends Personne {

	
	@Column
    private LocalDate dateEmbauche;
    public LocalDate getDateEmbauche() { return this.dateEmbauche; }
    public void setDateEmbauche (LocalDate dateEmbauche) { this.dateEmbauche = dateEmbauche;}


    @Column
    private Float salaire;   
    public Float getSalaire() { return this.salaire;}
    public void setSalaire (Float salaire) { this.salaire = salaire;}

	
    
    
    @ManyToMany(mappedBy = "employes")
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employe)) {
            return false;
        }
        Employe other = (Employe) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employe : " + getNom() + " " + getPrenom();
    }

    public Employe() {
    	super();
    }
}
