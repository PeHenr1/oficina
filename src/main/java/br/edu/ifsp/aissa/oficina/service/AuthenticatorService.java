package br.edu.ifsp.aissa.oficina.service;

import br.edu.ifsp.aissa.oficina.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticatorService implements UserDetailsService {

    private final UserRepository repository;

    public AuthenticatorService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }
}