package entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Message {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;


    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    private String contenu;




    @ManyToOne
   // @JoinColumn(name = "LOGIN")
    private Utilisateur autheur;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Utilisateur getAutheur() {
        return autheur;
    }

    public void setAutheur(Utilisateur utilisateur) {
        this.autheur = utilisateur;
    }
}
