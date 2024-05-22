package br.com.projetoPrincipal.ProjetoPrincipal.repositories;

import br.com.projetoPrincipal.ProjetoPrincipal.Domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    /*Utilizando um optional porque podemos ou não encontrar este usuário no banco de dados*/
    Optional<User> findByEmail(String email);
}
