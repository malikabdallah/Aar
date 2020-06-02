package modele;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Compte {

   // @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private long id;

    @ManyToOne
    private Client titulaire;
    private double solde;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOuverture;

    public Compte(long id, Client titulaire, double solde, Date dateOuverture) {
        this.id = id;
        this.titulaire = titulaire;
        this.solde = solde;
        this.dateOuverture = dateOuverture;
    }

    public Compte() {
    }


    public long getId() {
        return id;
    }

    public Client getTitulaire() {
        return titulaire;
    }

    public double getSolde() {
        return solde;
    }

    public Date getDateOuverture() {
        return dateOuverture;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitulaire(Client titulaire) {
        this.titulaire = titulaire;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setDateOuverture(Date dateOuverture) {
        this.dateOuverture = dateOuverture;
    }
}
