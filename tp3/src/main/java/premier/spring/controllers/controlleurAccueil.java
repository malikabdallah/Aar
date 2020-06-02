package premier.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import premier.spring.model.Competence;
import premier.spring.model.CompetenceMenbre;
import premier.spring.model.Membre;
import premier.spring.model.Projet;
import premier.spring.services.UserService;
import sun.plugin2.main.client.WMozillaServiceDelegate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@Controller
@SessionAttributes("login")
@RequestMapping("/")
public class controlleurAccueil {



    @Autowired
    UserService userService;


    @PostMapping("projetfini")
    public String projetCreation(@SessionAttribute("login")String login, Model model, HttpServletRequest request){


        String[] selections = request.getParameterValues("liste");
        List<Competence> list = new ArrayList<>();
        for (int i = 0; i < selections.length; i++) {
            for (Competence competence : userService.getCompetences()) {
                if (selections[i].equals(competence.getIntituleC())) {
                    list.add(competence);

                }
            }

        }

        Projet projet = new Projet();
        Membre membre=userService.getMembreParLogin(login);
        projet.setDirigePar(membre);
        projet.getNecessite().addAll(list);
        projet.setIntituleP(request.getParameter("intitule"));
        projet.setDescriptionP(request.getParameter("description"));



        membre.getResponsable().add(projet);

        for (Competence competence : list) {
            competence.getRequisePour().add(projet);
        }
        traitement(membre, model);
        userService.projets.add(projet);


        return "home";
    }


    @PostMapping("/ajouterCompetences")
    public String ajoutCompetences (@SessionAttribute("login") String login, Model model, HttpServletRequest request){
        String nom=request.getParameter("competencesMembres");
        Competence competence=userService.getCompetencesParIntitule(nom);
        Membre membre=userService.getMembreParLogin(login);
        int niveau=Integer.parseInt(request.getParameter("niveau"));
        String commentaire=request.getParameter("commentaire");
        CompetenceMenbre competenceMenbre=new CompetenceMenbre(membre,competence,niveau,commentaire);

        boolean t=true;
        System.out.println("compentence selected "+nom);
        for(CompetenceMenbre competenceMenbre1:membre.getDeclare()){
            System.out.println(competenceMenbre1.getDeType().getIntituleC());
            if(competenceMenbre1.getDeType().getIntituleC().equals(competence.getIntituleC())){
                t=false;
                System.out.println("trouve");
            }
        }
        if(t==true){
            membre.getDeclare().add(competenceMenbre);
            competence.getComprend().add(competenceMenbre);
            model.addAttribute("login",membre.getLogin());
            model.addAttribute("userName", membre.getLogin());
        }

        this.traitement(membre,model);


        return "home";


    }




    @PostMapping("creationUtilisateur")
    public String creerUtilisateur(@Valid @ModelAttribute("membre")Membre membre,BindingResult result,Model model,@SessionAttribute("login") String login){
        if (result.hasErrors()) {
            model.addAttribute("membre",membre);
            return "creerUtilisateur";
        }

        userService.getMembres().add(membre);
        Membre membre1=userService.getMembreParLogin(login);
        this.traitement(membre1,model);
        return "home";

    }


    @GetMapping("creerutilisateur")
    public String creerUtilisateur(Model model){

        model.addAttribute("membre",new Membre());
        return "creerUtilisateur";
    }

    public  void traitement(Membre membre, Model model){

        Collection<Projet> projetDirige = userService.projetDirige(membre);
        model.addAttribute("dirige",projetDirige);

        Collection<Projet> ProjetParticipe = userService.projetpParticipe(membre);
        model.addAttribute("participe",ProjetParticipe);
        List<CompetenceMenbre> competencesUtilisateur = membre.getDeclare();
        model.addAttribute("competences",competencesUtilisateur);
        List<Projet> acompetence = userService.projetAcompetence(userService.projets, membre);
        model.addAttribute("acompetences",acompetence);
        List<Projet> apascompetence = userService.apascompetences(userService.projets, membre);
        model.addAttribute("apascompetences",apascompetence);
    }



    @RequestMapping(value = "/ajouterCompetences",method = RequestMethod.GET)
    public String ajoutCompetences (@SessionAttribute("login") String login,Model model){

        model.addAttribute("liste",this.userService.getCompetences());
        return "ajoutCompetences";
    }




    @GetMapping("home")
    public String retourmenu(@SessionAttribute("login")String login,Model model){
        if(login==null){
            return "login";
        }
        Membre membre=userService.getMembreParLogin(login);
        this.traitement(membre,model);
        return "home";
    }




    @GetMapping("creerprojet")
    public String creerProjet(@SessionAttribute("login")String login,Model model){
        if(login==null){
            return "login";
        }
        Membre membre=userService.getMembreParLogin(login);
        this.traitement(membre,model);
        model.addAttribute("competences",this.userService.getCompetences());
        return "creationprojet";
    }

    @RequestMapping(value="/",method = RequestMethod.GET)
        public String home(  Model model) {

            model.addAttribute("membre",new Membre());

            return "login";
        }



    @RequestMapping(value="/connexion", method = RequestMethod.POST)
    public String user(@Valid @ModelAttribute("membre") Membre membre, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("membre",membre);
            return "login";
        }



        String a=membre.getLogin();
        String b=membre.getMotdepasse();
        System.out.println(membre.getLogin());
        System.out.println(membre.getMotdepasse());
        System.out.println("******************");
        Membre membre1=userService.exists(a,b);
        if (membre1 == null) {
            //       result.addError(new FieldError("user","login","Utilisateur inconnu"));
            result.addError(new FieldError("Membre","login","Utilisateur inconnu"));
            result.addError(new FieldError("Membre","motdepasse","Utilisateur inconnu"));
            model.addAttribute("membre",membre);


            return "login";
        }

        model.addAttribute("login",membre.getLogin());
        model.addAttribute("userName", membre.getLogin());
        this.traitement(membre1,model);

        return "home";
    }



    @RequestMapping()
    public void mamethode(@SessionAttribute("login") String login){

    }



    @GetMapping("/deconnexion")
    public String deconnexion(@SessionAttribute("login") String login, Model model, HttpSession session){
        //session.removeAttribute("login");
        model.addAttribute("membre",new Membre());
        return "login";

    }

}
