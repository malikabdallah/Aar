package modelespring;

import modele.Competence;
import modele.CompetenceMenbre;
import modele.Membre;
import modele.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class  facade2impl implements  facade2 {


    @Autowired
    private modelespring.facade1 facade;


    @Override
    public void checked() {
        for(Membre membre:facade.getMembres()){
            List<Competence>list=new ArrayList<>();
            for(CompetenceMenbre competenceMenbre:membre.getDeclare()){
                list.add(competenceMenbre.getDeType());
            }
            for(Projet projet:membre.getParticipe()){
                boolean estcompetent=false;

                for(Competence competence:projet.getNecessite()){
                    if(list.contains(competence)){
                        estcompetent=true;
                    }
                }
                if(estcompetent==false){
                    projet.getContributionDe().remove(membre);
                    membre.getParticipe().remove(projet);
                }
            }


        }
    }
}
