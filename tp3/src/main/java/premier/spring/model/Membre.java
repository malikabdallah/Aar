package premier.spring.model;

import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


public class Membre {


    @Size(min = 5,message = "Au - 5 caractères...")
    private String login;

    @Size(min = 5,message = "Au - 5 caractères...")
    private String motdepasse;
    private String surnom;
    private List<Projet> responsable=new ArrayList<>();
    private List<Projet> participe=new ArrayList<>();
    private List<CompetenceMenbre> declare=new ArrayList<>();




    // Constructeurs

    public Membre() {
        responsable=new ArrayList<>();
        participe=new ArrayList<>();
    }

    public Membre(String login, String motdepasse, String surnom) {
        this();
        this.login = login;
        this.motdepasse = motdepasse;
        this.surnom = surnom;
    }

    public void ajouterCompetenceMenbre(CompetenceMenbre competenceMenbre){
        this.declare.add(competenceMenbre);
    }

    public void participe(Projet projet){
        this.participe.add(projet);
    }

    public void dirige(Projet projet){
        this.responsable.add(projet);
    }

    // Getters / setters

    public String getLogin() {
        return login;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public List<Projet> getResponsable() {
        return responsable;
    }

    public void setResponsable(List<Projet> responsable) {
        this.responsable = responsable;
    }

    public List<Projet> getParticipe() {
        return participe;
    }

    public void setParticipe(List<Projet> participe) {
        this.participe = participe;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<CompetenceMenbre> getDeclare() {
        return declare;
    }

    public List<Competence> getTypeCompetence()
    {
        List<Competence>liste=new ArrayList<>();
        for(CompetenceMenbre competence:this.getDeclare()){
            liste.add(competence.getDeType());
        }
        return liste;
    }


    public void setDeclare(List<CompetenceMenbre> declare) {
        this.declare = declare;
    }



}

