package br.com.projetoPrincipal.ProjetoPrincipal.infra.security;

import br.com.projetoPrincipal.ProjetoPrincipal.Domain.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;
    public String generateToken(User user){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create().withIssuer("login-auth-api")
                    .withSubject(user.getEmail())
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException ex){
            throw new RuntimeException("Error while authenticating \n" + ex.getMessage());
        }
    }
    public String validateToken(String token){
        Algorithm algorithm = Algorithm.HMAC256(secret);
        try {
            return JWT.require(algorithm)
                    .withIssuer("login-auth-api")
                    .build()
                    .verify(token)
                    .getSubject();

        }catch (JWTVerificationException ex){
            return null;
        }
    }
    private Instant generateExpirationDate(){
        //retorna um "instant" da biblioteca time... essa quantidade de tempo representa o tempo de duração do token gerado.
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-3"));
    }

}
