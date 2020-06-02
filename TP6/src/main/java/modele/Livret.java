package modele;


import javax.persistence.Entity;
import java.util.Date;

/*@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter*/
@Entity
public class Livret extends Compte {
    private double tauxInteret;

    public Livret(long id, Client titulaire, double solde, Date dateOuverture, double tauxInteret) {
        super(id, titulaire, solde, dateOuverture);
        this.tauxInteret = tauxInteret;
    }

    public Livret() {

    }


    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }
}
