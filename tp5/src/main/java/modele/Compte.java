package modele;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/*@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter*/
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
}
