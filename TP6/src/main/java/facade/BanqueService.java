package facade;

import modele.Client;
import modele.Compte;
import modele.Livret;

import java.util.Collection;
import java.util.List;

public interface BanqueService {




    public void virement(long i, long i1, double v) ;

    public Collection<Client> getAllClients() ;

    public Client getClient(long id) ;

    public Collection<Livret> getAllLivrets() ;

    public Collection<Compte> getAllComptes() ;

    public Collection<Compte> getComptesOfClient(long id) ;



    public void deleteClient(long id) ;

    void saveClients(Client... client);
}
