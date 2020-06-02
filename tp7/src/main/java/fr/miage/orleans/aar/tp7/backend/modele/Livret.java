package fr.miage.orleans.aar.tp7.backend.modele;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import java.util.Date;

@Entity
@NoArgsConstructor
@NamedQuery(name = "findAllLivret", query = "select l from Livret l")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Livret extends Compte {

    private double tauxInteret;

    public Livret(Client client, double solde, Date now, double taux){
        super(client, solde, now);
        this.tauxInteret = taux;
    }
}
