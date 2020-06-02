package fr.miage.orleans.aar.tp7.backend.modele;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "findAllCompte", query = "select c from Compte c")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    private Client titulaire;

    private double solde;

    @Temporal(TemporalType.TIME)
    private Date dateOuverture;

    public Compte(Client client, double solde, Date now) {
        this.titulaire = client;
        this.solde = solde;
        this.dateOuverture = now;
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