package fr.miage.orleans.aar.tp7;

import fr.miage.orleans.aar.tp7.backend.dao.ClientRepository;
import fr.miage.orleans.aar.tp7.backend.modele.Client;
import fr.miage.orleans.aar.tp7.backend.modele.Compte;
import fr.miage.orleans.aar.tp7.backend.modele.Livret;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.TreeSet;

@SpringBootApplication
public class Tp7Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp7Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(ClientRepository clientRepo) {
        return args -> {
            Client client = new Client(1L, "malik", "malik", "adressee :p");

            client.addCompte(new Compte(client, 50000, new SimpleDateFormat("dd/MM/yy").parse("31/01/2010")));
            client.addCompte(new Livret(client, 45000.0, new SimpleDateFormat("dd/MM/yy").parse("31/01/2010"), 0.15));
            client.setActive(true);
            client.setPassword("malik");
            Set<String> set=new TreeSet<>();
            set.add("ROLE_USER");
            client.setEnable(true);
            client.setRoles(set);
            clientRepo.save(client);

        };
    }
}

