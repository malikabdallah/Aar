package fr.miage.orleans.aar.tp7.backend.dao;

import fr.miage.orleans.aar.tp7.backend.modele.Livret;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LivretRepository extends CrudRepository<Livret, Long> {
    List<Livret> findAll();
}
