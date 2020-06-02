package fr.miage.orleans.aar.tp7.backend.controlleur;

import fr.miage.orleans.aar.tp7.backend.dao.ClientRepository;
import fr.miage.orleans.aar.tp7.backend.dao.CompteRepository;
import fr.miage.orleans.aar.tp7.backend.dao.LivretRepository;
import fr.miage.orleans.aar.tp7.backend.modele.Client;
import fr.miage.orleans.aar.tp7.backend.modele.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("banques/")
public class Controlleur {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CompteRepository compteRepository;


    @Autowired
    private LivretRepository livretRepository;





    @PostMapping("/ajoutClient")
    public String ajouterClientdef(@Valid @ModelAttribute("client") Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "index";
        }

        clientRepository.save(client);
        model.addAttribute("users", clientRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Client client = clientRepository.findById(id);
        if(client==null){
            throw                  new IllegalArgumentException("Invalid user Id:" + id);

        }
        clientRepository.delete(client);
        model.addAttribute("users", clientRepository.findAll());
        return "index";
    }




    @GetMapping("/historique/{id}")
    public String historique(@PathVariable("id") long id, Model model) {
        Client client = clientRepository.findById(id);
        if(client==null){
            throw                  new IllegalArgumentException("Invalid user Id:" + id);

        }
        List<Compte>listebis=new ArrayList<>();
       // List<Compte> comptesClient=compteRepository.findByTitulaireId(client);
        List<Compte>liste=compteRepository.findAll();
        for(Compte compte:liste){
            if(compte.getTitulaire().getId()==id){
                listebis.add(compte);
            }
        }
        model.addAttribute("client",client);
        model.addAttribute("comptes",listebis);
        return "historique";
    }





    @GetMapping("/editer/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Client user = clientRepository.findById(id);
        if(user==null){
            throw new IllegalArgumentException("invalid user id :"+id);
        }

        model.addAttribute("client", user);
        return "update-user";
    }


   @PostMapping("/editer/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid Client client,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            Client client1=this.clientRepository.findById(id);
            model.addAttribute("client",client1);

            return "update-user";
        }

        clientRepository.save(client);
        model.addAttribute("users", clientRepository.findAll());
        return "index";
    }



    @GetMapping("/ajoutClient")
    public String ajoutClien(Model model,@ModelAttribute("client") Client client){
        model.addAttribute("client",client);
        return "ajoutClient";
    }

    @GetMapping("/listeClients")
    public String showSignUpForm(Model model) {
        model.addAttribute("users", clientRepository.findAll());
        return "index";
    }


    @GetMapping("/listeComptes")
    public String listeCompte(Model model){

        model.addAttribute("comptes",compteRepository.findAll());
        model.addAttribute("livrets",livretRepository.findAll());
        return "listeCompte";
    }

}
