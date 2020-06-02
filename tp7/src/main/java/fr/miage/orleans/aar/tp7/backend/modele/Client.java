package fr.miage.orleans.aar.tp7.backend.modele;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.FetchType.EAGER;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client implements UserDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private String adresse;
private  boolean enable;
    private String password;
    private boolean active;
    @ElementCollection(fetch = EAGER)
    @CollectionTable(name = "client_roles")
    private Set<String> roles;

    @OneToMany(mappedBy="titulaire", cascade = CascadeType.ALL, fetch = EAGER)
    private Collection<Compte> comptes;

    public Client(long l, String prenom, String nom, String addr) {
        this.id = l;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = addr;
        this.comptes = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public Collection<Compte> getComptes() {
        return comptes;
    }

    public void addCompte(Compte compte) {
        this.comptes.add(compte);
    }

    public void setComptes(List<Compte> comptes){
        this.comptes.addAll(comptes);
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setComptes(Collection<Compte> comptes) {
        this.comptes = comptes;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Object[]list=this.roles.toArray();
        if(list[0].equals("user"))
         return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        else
            return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));


    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public String getUsername() {
        return this.nom;
    }
    @Override
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
