package fr.miage.orleans.aar.tp7.backend.dao;

import fr.miage.orleans.aar.tp7.backend.modele.Client;
import fr.miage.orleans.aar.tp7.backend.modele.Compte;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompteRepository extends CrudRepository<Compte,Long> {
    List<Compte> findAll();
    List<Compte> findByTitulaireId(Client titulaire);
}
