package servlets;

import modele.Competence;
import modele.CompetenceMenbre;
import modele.Membre;
import modele.Projet;
import modelespring.facade2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "MaServlet" ,urlPatterns = "/Controlleur")
public class MaServlet extends HttpServlet {



    @Autowired
    private modelespring.facade1 facade;

    @Autowired
    private facade2 facade2;

    private  int testco=0;


    private HttpSession session;



    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {


        String todo = request.getParameter("todo");
        if(todo==null){
            if(session==null){

                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);

            }else{
                request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request,response);

            }
        }
        System.out.println(todo);
        System.out.println();




        switch (todo) {

            case "finitionutilisateur":

                String log = request.getParameter("login");
                String mdp = request.getParameter("mdp");
                String surnom = request.getParameter("surnom");
                Membre membres = new Membre(log, mdp, surnom);
                facade.getMembres().add(membres);
                System.out.println("nous sommes ici");
                request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request, response);

                break;
            case "creerutilisateur":
                request.getRequestDispatcher("WEB-INF/creerUtilisateur.jsp").forward(request, response);

                break;

            case "finitionprojet":

                String[] selections = request.getParameterValues("liste");
                List<Competence> list = new ArrayList<>();
                for (int i = 0; i < selections.length; i++) {
                    for (Competence competence : facade.getCompetences()) {
                        if (selections[i].equals(competence.getIntituleC())) {
                            list.add(competence);

                        }
                    }

                }

                Projet projet = new Projet();
                projet.setDirigePar((Membre) session.getAttribute("menbre"));
                projet.getNecessite().addAll(list);
                projet.setIntituleP(request.getParameter("intitule"));
                projet.setDescriptionP(request.getParameter("description"));


                Membre membre = (Membre) session.getAttribute("menbre");
                membre.getResponsable().add(projet);

                for (Competence competence : list) {
                    competence.getRequisePour().add(projet);
                }
                traitement(request, response);
                facade.getProjets().add(projet);
                request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request, response);



                break;

            case "deconnexion":
                session.invalidate();
                testco=0;
                session = null;
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);

                break;


            case "login":
                if(testco!=0){
                    request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request, response);

                }else{
                    request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);

                }



                break;

            case "creerprojet":

                request.setAttribute("competences", facade.getCompetences());
                request.getRequestDispatcher("WEB-INF/ajoutProjet.jsp").forward(request, response);


                break;
            case "ajouterCompetences":
                List<Competence> competences = facade.getCompetences();
                membre = (Membre) session.getAttribute("menbre");
                // competences.removeAll(membre.getTypeCompetence());
                request.setAttribute("competences", competences);


                request.getRequestDispatcher("WEB-INF/ajoutCompetences.jsp").forward(request, response);

                break;

            case "ajoutFini":

                System.out.println("ici");
                String nom = request.getParameter("competencesMembres");
                System.out.println("commp =" + nom);


                Competence competence = facade.getCompetencesParIntitule(nom);
                membre = (Membre) session.getAttribute("menbre");
                if (!membre.getTypeCompetence().contains(competence)){
                    int niveau = Integer.parseInt(request.getParameter("niveau"));
                String commentaire = request.getParameter("commentaire");
                CompetenceMenbre competenceMenbre = new CompetenceMenbre(membre, competence, niveau, commentaire);

                membre.getDeclare().add(competenceMenbre);
                competence.getComprend().add(competenceMenbre);
                     }
                request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request,response);

                traitement(request,response);
                request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request,response);








                break;
            case "menu":
                    System.out.println("iciiiii");
                request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request,response);
                    break;
            case "acceuil":


                String login=request.getParameter("login");
                String password=request.getParameter("password");
                if(facade.connexion(login,password)){
                    testco=1;
                    session=request.getSession();
                    request.setAttribute("login",login);
                     membre=facade.trouverMembre(login,password);
                    session.setAttribute("menbre",membre);

                    traitement(request,response);
                    /*

                    Collection<Projet> projetDirige=facade.projetDirige(membre);
                    request.setAttribute("dirige",projetDirige);
                    session.setAttribute("dirige",projetDirige);

                    Collection<Projet>ProjetParticipe=facade.projetpParticipe(membre);
                    request.setAttribute("participe",ProjetParticipe);
                    System.out.println("vos participations:"+ProjetParticipe);

                    session.setAttribute("participe",projetDirige);




                    List<CompetenceMenbre> competencesUtilisateur=membre.getDeclare();
                    request.setAttribute("competences",competencesUtilisateur);
                    session.setAttribute("competences",competencesUtilisateur);




                    List<Projet>acompetence=facade.projetAcompetence(facade.getProjets(),membre);
                    request.setAttribute("acompetences",acompetence);
                    session.setAttribute("acompetences",acompetence);



                    List<Projet>apascompetence=facade.apascompetences(facade.getProjets(),membre);
                    request.setAttribute("autre",apascompetence);
                    session.setAttribute("autre",apascompetence);

*/
                    request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request,response);
              }else{
                    request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);
                }
                break;


            default:


                if(session==null){

                    request.getRequestDispatcher("WEB-INF/login.jsp").forward(request,response);

                }else{
                    request.getRequestDispatcher("WEB-INF/acceuil.jsp").forward(request,response);

                }

        }


    }



    public void traitement( HttpServletRequest request, HttpServletResponse response){

        if(session.getAttribute("menbre")!=null) {
            Membre membre=(Membre)session.getAttribute("menbre");
            Collection<Projet> projetDirige = facade.projetDirige(membre);
            request.setAttribute("dirige", projetDirige);
            session.setAttribute("dirige", projetDirige);

            Collection<Projet> ProjetParticipe = facade.projetpParticipe(membre);
            request.setAttribute("participe", ProjetParticipe);
            System.out.println("vos participations:" + ProjetParticipe);

            session.setAttribute("participe", projetDirige);


            List<CompetenceMenbre> competencesUtilisateur = membre.getDeclare();
            request.setAttribute("competences", competencesUtilisateur);
            session.setAttribute("competences", competencesUtilisateur);


            List<Projet> acompetence = facade.projetAcompetence(facade.getProjets(), membre);
            request.setAttribute("acompetences", acompetence);
            session.setAttribute("acompetences", acompetence);


            List<Projet> apascompetence = facade.apascompetences(facade.getProjets(), membre);
            request.setAttribute("autre", apascompetence);
            session.setAttribute("autre", apascompetence);
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,config.getServletContext());


        facade2.checked();
    }

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doPost(request, response);
    }
}
