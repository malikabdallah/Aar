package fr.miage.orleans.aar.tp7.backend.securite;

import fr.miage.orleans.aar.tp7.backend.dao.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.sql.DataSource;


@Service
@Configuration
@EnableWebSecurity
@ComponentScan
public class SecurityConfig extends WebSecurityConfigurerAdapter {



   /* @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }*/


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new PasswordEnconderTest();
    }

    @Autowired
    private DataSource dataSource;

/*
    @Bean
    public PasswordEncoder encoder() {
        return    new BCryptPasswordEncoder();
    }
*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select nom,password, enable from client where nom=?")
                .authoritiesByUsernameQuery(
                        "select nom,roles from client,client_roles where(client.id=client_roles.client_id) and" +
                                "(client.nom=?)").passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin()
        .successForwardUrl("/banques/listeClients")

        ;
        // .antMatchers("/**").hasAnyRole("USER");

        // http
        //     .authorizeRequests()
        //         .antMatchers("/category/**").access("hasRole('ROLE_USER')")
        //         .antMatchers("/").access("permitAll");
    }



}