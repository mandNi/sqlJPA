package esn.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Personne  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Seq_Personne")
	@SequenceGenerator(name="Seq_Personne", sequenceName="Seq_Personne", allocationSize=1)
	@Column(name = "id_personne")
	private Long id;
	public void setId(Long id) {this.id = id ; }
	public Long getId() { return this.id; }

	@Column
    private String nom;
    public void setNom(String n) { this.nom = n; }
    public String getNom() { return this.nom; }

    @Column
    private String prenom;
    public void setPrenom(String p) { this.prenom = p; }
    public String getPrenom() { return this.prenom; }

    @Column
    private String email;
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email;}

    public Personne() {  }
}
