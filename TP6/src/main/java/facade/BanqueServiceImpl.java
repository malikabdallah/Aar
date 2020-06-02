package facade;

import dao.ClientDao;
import dao.CompteDao;
import dao.LivretDao;
import modele.Client;
import modele.Compte;
import modele.Livret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class BanqueServiceImpl implements BanqueService{

    // spring run =>facade =>dao => jpa=>jdbc=>mysql
    //il faut forcer a la creation du service a fourni les service
    private Collection<Client> listeclient=new ArrayList<>();
    private Collection<Compte> listecompte=new ArrayList<>();
    private Collection<Livret> listelivret=new ArrayList<>();


    public ClientDao clientDao;

    public CompteDao compteDao;


    public LivretDao livretDao;

    public BanqueServiceImpl(ClientDao clientDao, CompteDao compteDao, LivretDao livretDao) {
        this.clientDao = clientDao;
        this.compteDao = compteDao;
        this.livretDao = livretDao;
    }




    @Transactional
    public void virement(long compteSource, long compteDest, double montant) {

        Compte source=compteDao.find(compteSource);
        Compte dest=compteDao.find(compteDest);

        source.setSolde(source.getSolde()-montant);
        dest.setSolde(dest.getSolde()+montant);
        compteDao.edit(source);
        compteDao.edit(dest);

    }
    //false



    @Transactional(readOnly = true)
    public Collection<Client> getAllClients() {
     return clientDao.findAll();
    }

    @Transactional(readOnly = true)
    public Client getClient(long id) {
        Client c1=new Client();
        for (Client c:listeclient) {
            if(c.getId()==id){
                c1=c;
            }
            
        }
        return c1;
    }

    @Transactional(readOnly = true)
    public Collection<Livret> getAllLivrets() {
        return listelivret;
    }

    @Transactional(readOnly = true)
    public Collection<Compte>  getAllComptes() {
        return listecompte;
    }

    @Transactional(readOnly = true)
    public Collection<Compte>  getComptesOfClient(long id) {
      return clientDao.find(id).getComptes();

    }

    @Transactional
    @Override
    public void saveClients(Client... client){

        for(Client client1:client){
            clientDao.create(client1);
        }



    }

    @Transactional
    public void deleteClient(long id) {
        clientDao.remove(clientDao.find(id));
    }


}
