package premier.spring.services;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import premier.spring.model.*;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Service
public class UserService {





   public List<Projet> projets;
    List<Membre> membres ;
    List<Competence> competences ;
    Collection<CompetenceMenbre> competenceMenbres ;




    @PostConstruct
    public void fillUsers() {
        /*users=new ArrayList<>();
        Membre u;
        u=new Membre("malik","malik","malik");
        users.add(u);*/







        projets=new ArrayList<>();
        membres = new ArrayList<>();
        competences = new ArrayList<>();
        competenceMenbres = new ArrayList<>();




        Membre membre1=new Membre("malik","malik","malik");
        Membre membre2=new Membre("gyldan","gyldan","gyldan");
        Membre membre3=new Membre("Jean","Jean","Jean");
        Membre membre4=new Membre("bilye","bilye","bilye");


        Competence competence1=new Competence("spring","savoir utiliser le framework spring");
        Competence competence2=new Competence("symfony","savoir utiliser le framework symfony");
        Competence competence3=new Competence("django","savoir utiliser le framework djagon");
        Competence competence4=new Competence("javaee","savoir utiliser le langage java ee");
        Competence competence5=new Competence("php","savoir utiliser le langage php");
        Competence competence6=new Competence("python","savoir utiliser le langage python");


        Projet projet1=new Projet("ecommerce spring","creer un ecommerce avec spring ");
        Projet projet2=new Projet("ecommerce symfony","creer un ecommerce avec symfony ");
        Projet projet4=new Projet("ecommerce symfony","creer un ecommerce avec en symfony(2) ");

        Projet projet3=new Projet("ecommerce django","creer un ecommerce avec djagon ");


        projet1.neccesite(competence1);
        projet1.neccesite(competence4);
        projet2.neccesite(competence2);
        projet2.neccesite(competence5);
        projet3.neccesite(competence6);
        projet3.neccesite(competence3);
        projet4.neccesite(competence2);
        projet4.neccesite(competence5);



        CompetenceMenbre competenceMenbre1=new CompetenceMenbre(membre1,competence1,5,"senior developpeur spring");
        CompetenceMenbre competenceMenbre2=new CompetenceMenbre(membre1,competence4,5,"senior developpeur jee");
        CompetenceMenbre competenceMenbre3=new CompetenceMenbre(membre1,competence5,3,"bonne connaissance en php");
        competence1.comprend(competenceMenbre1);
        competence4.comprend(competenceMenbre2);
        competence5.comprend(competenceMenbre3);

        membre1.ajouterCompetenceMenbre(competenceMenbre1);
        membre1.ajouterCompetenceMenbre(competenceMenbre2);
        membre1.ajouterCompetenceMenbre(competenceMenbre3);
        membre1.dirige(projet1);
        membre1.participe(projet2);
        /* HAHA*/
        membre1.participe(projet3);
        projet3.contribuer(membre1);

        projet1.setDirigePar(membre1);
        projet1.contribuer(membre2);



        CompetenceMenbre competenceMenbre4=new CompetenceMenbre(membre2,competence4,3,"junior developpeur jee");
        CompetenceMenbre competenceMenbre5=new CompetenceMenbre(membre2,competence5,5,"senior developpeur php");
        CompetenceMenbre competenceMenbre6=new CompetenceMenbre(membre2,competence2,5,"senior developpeur symfony");
        competence4.comprend(competenceMenbre4);
        competence5.comprend(competenceMenbre5);
        competence2.comprend(competenceMenbre6);

        membre2.ajouterCompetenceMenbre(competenceMenbre4);
        membre2.ajouterCompetenceMenbre(competenceMenbre5);
        membre2.ajouterCompetenceMenbre(competenceMenbre6);
        membre2.dirige(projet2);
        membre2.participe(projet1);
        membre2.participe(projet4);
        projet2.setDirigePar(membre2);
        projet2.contribuer(membre1);
        projet4.contribuer(membre2);






        CompetenceMenbre competenceMenbre7=new CompetenceMenbre(membre3,competence4,3,"junior developpeur jee");
        CompetenceMenbre competenceMenbre8=new CompetenceMenbre(membre3,competence5,5,"senior developpeur php");
        CompetenceMenbre competenceMenbre9=new CompetenceMenbre(membre3,competence2,5,"senior developpeur symfony");
        competence4.comprend(competenceMenbre7);
        competence5.comprend(competenceMenbre8);
        competence2.comprend(competenceMenbre9);

        membre3.ajouterCompetenceMenbre(competenceMenbre7);
        membre3.ajouterCompetenceMenbre(competenceMenbre8);
        membre3.ajouterCompetenceMenbre(competenceMenbre9);
        membre3.dirige(projet4);
        projet4.setDirigePar(membre3);





        CompetenceMenbre competenceMenbre10=new CompetenceMenbre(membre3,competence3,3,"SENIOR developpeur djangon");
        CompetenceMenbre competenceMenbr11=new CompetenceMenbre(membre3,competence6,5,"senior developpeur python");
        competence3.comprend(competenceMenbre10);
        competence6.comprend(competenceMenbr11);

        membre3.ajouterCompetenceMenbre(competenceMenbre10);
        membre3.ajouterCompetenceMenbre(competenceMenbr11);
        membre3.dirige(projet4);
        projet4.setDirigePar(membre3);













        membres.add(membre1);
        membres.add(membre2);
        membres.add(membre3);
        membres.add(membre4);


        projets.add(projet1);
        projets.add(projet2);
        projets.add(projet3);
        projets.add(projet4);


        competences.add(competence1);
        competences.add(competence2);
        competences.add(competence3);
        competences.add(competence4);
        competences.add(competence5);
        competences.add(competence6);




        competenceMenbres.add(competenceMenbre1);
        competenceMenbres.add(competenceMenbre2);
        competenceMenbres.add(competenceMenbre3);
        competenceMenbres.add(competenceMenbre4);
        competenceMenbres.add(competenceMenbre5);
        competenceMenbres.add(competenceMenbre6);
        competenceMenbres.add(competenceMenbre7);
        competenceMenbres.add(competenceMenbre8);
        competenceMenbres.add(competenceMenbre9);
        competenceMenbres.add(competenceMenbre10);
        competenceMenbres.add(competenceMenbr11);






    }

    public Membre exists(String login,String pass) {
        for(Membre membre:membres){
            if(membre.getLogin().equals(login) && membre.getMotdepasse().equals(pass)){
                System.out.println("trouver");
                System.out.println("user :"+membre.getLogin()+" "+membre.getMotdepasse());
                System.out.println("user :"+login+" "+pass);


                return  membre;
            }
        }
        return null;
    }









    public Collection<Projet> projetpParticipe(Membre membre) {


        Collection<Projet>participe=new ArrayList<>();
        for (Projet projet : membre.getParticipe()) {
            ((ArrayList<Projet>) participe).add(projet);
        }

        return participe;


    }





    public Collection<Projet> projetDirige(Membre membre) {
        Collection<Projet>dirige=new ArrayList<>();
        for (Projet projet:membre.getResponsable()){
            dirige.add(projet);
        }
        return dirige;
    }


    public Membre trouverMembre(String login, String password) {
        for(Membre membre:membres){
            if(membre.getLogin().equals(login) && membre.getMotdepasse().equals(password)){
                return membre;
            }
        }
        return null;
    }

    public List<Projet> projetAcompetence(List<Projet> liste,Membre membreutilisateur) {
        List<Projet>dirige=new ArrayList<>();
        List<Projet>participe=new ArrayList<>();
        List<Projet>acompetence=new ArrayList<>();
        List<Projet>autre=new ArrayList<>();

        List<Competence>competencesUtilisateur=new ArrayList<>();
        for(CompetenceMenbre competenceMenbre:membreutilisateur.getDeclare()){
            competencesUtilisateur.add(competenceMenbre.getDeType());
        }
        for(Projet projet:liste){
            boolean trouve=false;
            if(projet.getDirigePar()==membreutilisateur) {
                dirige.add(projet);
                trouve=true;
            }
            if(!trouve) {
                for (Membre membre : projet.getContributionDe()) {
                    if (membre == membreutilisateur) {
                        participe.add(projet);
                        trouve=true;
                        break;

                    }


                }
            }

            if(!trouve){
                for(Competence competence1:projet.getNecessite()){
                    for(Competence competence2:competencesUtilisateur){
                        if(competence1.equals(competence2)){
                            acompetence.add(projet);
                            trouve=true;
                            break;
                        }
                    }

                    if(trouve){
                        break;
                    }
                }
            }

            if(!trouve){
                autre.add(projet);
            }


        }

        return acompetence;
    }

    public List<Projet> apascompetences(List<Projet> liste, Membre membreutilisateur) {

        List<Projet>dirige=new ArrayList<>();
        List<Projet>participe=new ArrayList<>();
        List<Projet>acompetence=new ArrayList<>();
        List<Projet>autre=new ArrayList<>();

        List<Competence>competencesUtilisateur=new ArrayList<>();
        for(CompetenceMenbre competenceMenbre:membreutilisateur.getDeclare()){
            competencesUtilisateur.add(competenceMenbre.getDeType());
        }
        for(Projet projet:liste){
            boolean trouve=false;
            if(projet.getDirigePar()==membreutilisateur) {
                dirige.add(projet);
                trouve=true;
            }
            if(!trouve) {
                for (Membre membre : projet.getContributionDe()) {
                    if (membre == membreutilisateur) {
                        participe.add(projet);
                        trouve=true;
                        break;

                    }


                }
            }

            if(!trouve){
                for(Competence competence1:projet.getNecessite()){
                    for(Competence competence2:competencesUtilisateur){
                        if(competence1.equals(competence2)){
                            acompetence.add(projet);
                            trouve=true;
                            break;
                        }
                    }

                    if(trouve){
                        break;
                    }
                }
            }

            if(!trouve){
                autre.add(projet);
            }


        }

        return autre;

    }


    public List<Competence> getCompetenceMembre(Membre membre) {
        List<Competence>competences=new ArrayList<>();
        for(CompetenceMenbre competenceMenbre:membre.getDeclare()){
            competences.add(competenceMenbre.getDeType());
        }
        return competences;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public Competence getCompetencesParIntitule(String nom) {
        for(Competence competence:this.competences){
            if(competence.getIntituleC().equals(nom)){
                return competence;
            }
        }
        return null;
    }

    public List<Membre> getMembres() {
        return this.membres;
    }


    public Membre getMembreParLogin(String login) {
        for(Membre membre:this.getMembres()){
            if(membre.getLogin().equals(login)){
                return membre;
            }
        }
        return  null;
    }
}
