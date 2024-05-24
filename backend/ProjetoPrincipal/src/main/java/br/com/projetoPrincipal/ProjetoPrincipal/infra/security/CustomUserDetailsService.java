package br.com.projetoPrincipal.ProjetoPrincipal.infra.security;

import br.com.projetoPrincipal.ProjetoPrincipal.Domain.user.User;
import br.com.projetoPrincipal.ProjetoPrincipal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class CustomUserDetailsService implements UserDetailsService {
   @Autowired
   private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not found"));
        /*Criando o user pensando no springSecurity, que vai conter o array com as roles permitidas...*/
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
