package esn.data;

import javax.persistence.*;
import java.util.Set;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;


@Entity
public class Projet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Seq_Projet")
	@SequenceGenerator(name="Seq_Projet", sequenceName="Seq_Projet", allocationSize=1)
	@Column(name = "id_projet")
	private Long id;
	public void setId(Long id) {this.id = id ; }
	public Long getId() { return this.id; }

	@Column
	private String nom;
	public String getNom() { return this.nom; }
	public void setNom(String nom) { this.nom = nom;}

	@Column
	private LocalDate dateDebut;
	public LocalDate getDateDebut() { return this.dateDebut;}
	public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut;}

	@Column
	private LocalDate dateFin;
	public LocalDate getDateFin() { return this.dateFin; }
	public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin;}
	
	
	@ManyToOne
	@JoinColumn(name = "id_personne")
	private Client client;
	public void setClient(Client c) {this.client = c ; }
	public Client getClient() {return this.client ; }
	
	
	
	@ManyToMany ()
	@JoinTable ( name = "participer", joinColumns = @JoinColumn ( name = "id_projet") ,
	inverseJoinColumns = @JoinColumn ( name = "id_personne"))
	private Set<Personne> employes = new HashSet<Personne>();
	public void addEmploye(Personne emp) {this.employes.add(emp); }
	public void removeEmploye(Personne emp) {this.employes.remove(emp); }
	public Set<Personne> getEmployes() {return this.employes ; }
	
	

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Projet)) {
			return false;
		}
		Projet other = (Projet) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Projet : " + getNom() + " " + getDateDebut() + " " + getDateFin();
	}

}
