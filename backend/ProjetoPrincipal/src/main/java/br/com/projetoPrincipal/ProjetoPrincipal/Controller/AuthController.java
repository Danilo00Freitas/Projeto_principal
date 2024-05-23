package br.com.projetoPrincipal.ProjetoPrincipal.Controller;

import br.com.projetoPrincipal.ProjetoPrincipal.Domain.user.User;
import br.com.projetoPrincipal.ProjetoPrincipal.dto.Login.LoginRequestData;
import br.com.projetoPrincipal.ProjetoPrincipal.dto.Login.LoginResponseData;
import br.com.projetoPrincipal.ProjetoPrincipal.dto.Register.RegisterRequestData;
import br.com.projetoPrincipal.ProjetoPrincipal.infra.security.TokenService;
import br.com.projetoPrincipal.ProjetoPrincipal.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
/*@RequiredArgsConstructor *//*Lombok vai gerar o construtor da classe solicitando os parametros abaixo... Poderia ir utilizando autowired*/
public class AuthController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestData body){
        User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(user.getPassword(), body.password())){
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new LoginResponseData(user.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestData body){
        Optional<User> user = this.repository.findByEmail(body.email());
        if (user.isEmpty()){
            User newUser = new User();
            newUser.setPassword(passwordEncoder.encode(body.password()));
            newUser.setEmail(body.email());
            newUser.setName(body.name());
            this.repository.save(newUser);
            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new LoginResponseData(newUser.getName(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
