package services;

import dto.MessageDto;
import entities.Message;
import entities.Utilisateur;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MurService {
    @PersistenceContext
    EntityManager em;

    public Utilisateur findUtilisateurByLogin(String login) {
        return em.find(Utilisateur.class,login);
    }

    public Utilisateur findUtilisateurByLoginPassword(String login, String password) {
        Query q=em.createQuery("from Utilisateur u where u.login=:l and u.password=:p");
        q.setParameter("l",login);
        q.setParameter("p",password);
        try {
            return (Utilisateur) q.getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public Collection<Utilisateur> findAllUtilisateur() {
        Query q=em.createQuery("from Utilisateur u");
        return q.getResultList();
    }

    public Utilisateur createUtilisateur() {
        // TODO !!!
        return null;
    }


    @Transactional
    public void createMessage(String login, String message) {


/*

        Query q=em.createQuery("from Utilisateur u where u.login=:l ");
        q.setParameter("l",login);
        Utilisateur u=(Utilisateur) q.getSingleResult();
*/

Utilisateur u=em.find(Utilisateur.class,login);
        System.out.println("TODO !!!");


        Message msg=new Message();
        msg.setAutheur(u);

        msg.setContenu(message);
        em.persist(msg);
    }


    @Transactional
    public Collection<MessageDto> findAllMessage() {
        Collection<MessageDto>messageDtos=new ArrayList<>();
        Query c=em.createQuery("from Utilisateur u");


        Collection<Utilisateur> utils=c.getResultList();
        for(Utilisateur utilisateur:utils){
            MessageDto messageDto=new MessageDto();
            messageDto.setPseudo(utilisateur.getPseudo());
            List<String>msg=new ArrayList<>();
            for(Message message:utilisateur.getMessages()){

                msg.add(message.getContenu());
            }

            messageDto.setMessages(msg);
            messageDtos.add(messageDto);

        }

    return messageDtos;
    }

}
