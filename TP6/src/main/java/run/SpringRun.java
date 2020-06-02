package run;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import facade.BanqueService;
import modele.*;

public class SpringRun {
    // couche service : SPRING
    private static BanqueService service;
    // constructeur
    public static void main(String[] args) throws ParseException {
        // configuration de l'application
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("spring-config.xml");
        // récupération de la couche service
        service = (BanqueService) ctx.getBean("banqueService");
        // on vide la base
        clean();
        // on la remplit
        fill();
        // on vérifie visuellement
        dumpClients();
        dumpComptes();
        dumpLivrets();
        dumpClientsComptes();
        virement();
        dumpComptes();
    }
    private static void virement() {
        service.virement(198, 205, 690.00);
    }
    // affichage contenu table Client
    private static void dumpClients() {
        System.out.format("[Clients]%n");
        for (Client c : service.getAllClients()) {
            System.out.print(c);
            Client c2 = service.getClient(c.getId());
            System.out.println("|"+c2);
        }
    }
    // affichage contenu table Livret
    private static void dumpLivrets() {
        System.out.format("[Livrets]%n");
        for (Livret a : service.getAllLivrets()) {
            System.out.println(a);
        }
    }
    // affichage des comptes
    private static void dumpComptes() {
        System.out.format("[Compte]%n");
        for (Compte a : service.getAllComptes()) {
            System.out.println(a);
        }
    }
    // affichage des clients, avec leurs comptes respectifs
    private static void dumpClientsComptes() {
        System.out.println("[Clients/comptes]");
        for (Client p : service.getAllClients()) {
            for (Compte a : service.getComptesOfClient(p.getId())) {
                System.out.format("[%s,%s]%n", p.getNom(), a.getId());
            }
        }
    }
    // remplissage tables
    public static void fill() throws ParseException {
        // crï¿½ation Clients
        Client c1 = new Client(1003, "Martin", "Paul", "Orléans");
        Client c2 = new Client(1015, "Dupont", "Sylvie", "Olivet");
        Client c3 = new Client(1109, "Dupond", "Henri", "La ferté");

        // ajout des Comptes/Livrets
        c1.addCompte(new Compte(198,c1,2300.0,new SimpleDateFormat("dd/MM/yy").parse("31/01/2010")));
        c2.addCompte(new Compte(203,c2,5440.0,new SimpleDateFormat("dd/MM/yy").parse("05/07/2001")));
        c2.addCompte(new Livret(205,c2, 655.0,new SimpleDateFormat("dd/MM/yy").parse("05/07/2011"),0.05));
        c3.addCompte(new Compte(243,c3, 450.0,new SimpleDateFormat("dd/MM/yy").parse("25/12/2013")));
        // persistance des Clients avec leurs comptes/livrets
        service.saveClients(c1,c2,c3);
    }
    // supression de tous les clients
    public static void clean() {
        // on supprime ttes les Clients et donc toutes les Comptes
        for (Client Client : service.getAllClients()) {
            service.deleteClient(Client.getId());
        }
    }
}