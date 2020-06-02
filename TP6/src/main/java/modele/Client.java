package modele;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

/*@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter*/
@Entity
public class Client {

    @Id //@GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String nom;

    private String prenom;

    private String adresse;

    @OneToMany(mappedBy="titulaire",cascade = CascadeType.PERSIST)
    private Collection<Compte> comptes;

//posibilite heritage detype
    // eee

    public Client(long id, String nom, String prenom, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.comptes=new ArrayList<>();
    }

    public void addCompte(Compte client){
        this.comptes.add(client);
    }




    public Client(long id, String nom, String prenom, String adresse, Collection<Compte> comptes) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.comptes = comptes;
    }

    public Client() {
        this(-1,"abdallah","malik","19 rue clovis hughes");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Collection<Compte> getComptes() {
        return comptes;
    }

    @LazyCollection(LazyCollectionOption.FALSE)
    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }
}
