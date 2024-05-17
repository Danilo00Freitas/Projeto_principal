package br.com.projetoPrincipal.ProjetoPrincipal.repositories;

import br.com.projetoPrincipal.ProjetoPrincipal.Domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
