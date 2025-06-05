package br.edu.ifsp.aissa.oficina.controller;

import br.edu.ifsp.aissa.oficina.model.dto.DadosAuthenticator;
import br.edu.ifsp.aissa.oficina.user.User;
import br.edu.ifsp.aissa.oficina.util.security.TokenJWT;
import br.edu.ifsp.aissa.oficina.util.security.TokenJWTService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    private final AuthenticationManager manager;
    private final TokenJWTService tokenService;

    public AutenticacaoController(AuthenticationManager manager, TokenJWTService tokenService) {
        this.manager = manager;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAuthenticator dados) {

        var token = new UsernamePasswordAuthenticationToken( dados.login(), dados.senha() );
        var authentication = manager.authenticate(token);
        var tokenJWT = tokenService.gerarToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new TokenJWT(tokenJWT));
    }
}
