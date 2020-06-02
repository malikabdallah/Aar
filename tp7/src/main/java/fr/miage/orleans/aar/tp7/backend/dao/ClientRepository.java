package fr.miage.orleans.aar.tp7.backend.dao;

import fr.miage.orleans.aar.tp7.backend.modele.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
    Client findFirstByNom(String nom);


    Client findById(long id);

    Client findByNom(String username);
}
