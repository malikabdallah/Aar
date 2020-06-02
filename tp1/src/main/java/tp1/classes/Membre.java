package tp1.classes;

import java.util.ArrayList;
import java.util.Collection;

public class Membre {
    private String login;
    private String motdepasse;
    private String surnom;
    private Collection<Projet> responsable=new ArrayList<>();
    private Collection<Projet> participe=new ArrayList<>();
    private Collection<CompetenceMenbre>declare=new ArrayList<>();

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

    public Collection<Projet> getResponsable() {
        return responsable;
    }

    public void setResponsable(Collection<Projet> responsable) {
        this.responsable = responsable;
    }

    public Collection<Projet> getParticipe() {
        return participe;
    }

    public void setParticipe(Collection<Projet> participe) {
        this.participe = participe;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Collection<CompetenceMenbre> getDeclare() {
        return declare;
    }

    public void setDeclare(Collection<CompetenceMenbre> declare) {
        this.declare = declare;
    }
}
