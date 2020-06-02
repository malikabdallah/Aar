package modelespring;

import modele.Competence;
import modele.CompetenceMenbre;
import modele.Membre;
import modele.Projet;

import java.util.Collection;
import java.util.List;

public interface facade1 {




    List<Projet>getProjets();


    boolean connexion(String login,String password);
    Collection<Projet> projetpParticipe(Membre membre);
    Collection<Projet> projetDirige(Membre membre);

    Membre trouverMembre(String login, String password);


    List<Projet> projetAcompetence(List<Projet>liste,Membre membre);

    List<Projet>apascompetences(List<Projet>liste,Membre membre);

    List<Competence> getCompetenceMembre(Membre membre);

    List<Competence> getCompetences();

    Competence getCompetencesParIntitule(String nom);

    List<Membre>getMembres();
}
