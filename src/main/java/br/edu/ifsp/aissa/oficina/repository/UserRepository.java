package br.edu.ifsp.aissa.oficina.repository;

import br.edu.ifsp.aissa.oficina.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByLogin(String username);
}