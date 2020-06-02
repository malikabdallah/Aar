package demo;

import modele.Client;
import modele.Compte;
import modele.Livret;
import org.eclipse.persistence.internal.jpa.EntityManagerImpl;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Run {


    public static void main(String[]args){
        Client client=new Client(1,"abdallah","malik","18 rue clovis hugues");

        Compte compte=new Compte(1,client,200,new Date());
        Livret livret=new Livret(2,client,200,new Date(),1.58);


        client.addCompte(compte);

        client.addCompte(livret);

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("banquePU");
        EntityManager em = emf.createEntityManager();



        em.getTransaction().begin();


        //methode 1
      //  em.persist(compte);
        em.persist(client);

        em.getTransaction().commit();











    }
}
