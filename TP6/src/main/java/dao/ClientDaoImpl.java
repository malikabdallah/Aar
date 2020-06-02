package dao;

import modele.Client;

// puis l'implémentation JPA :
public class ClientDaoImpl extends AbstractDaoImpl<Client> implements ClientDao {
    public ClientDaoImpl() {
        this(Client.class);
    }
    public ClientDaoImpl(Class<Client> entityClass) {
        super(entityClass);
    }
}