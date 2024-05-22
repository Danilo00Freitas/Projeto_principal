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
/*A classe TokenService é um serviço Spring responsável por gerar e validar tokens JWT. Ela utiliza a biblioteca Auth0 para criar tokens JWT contendo o e-mail do usuário como assunto e com um tempo de expiração de 1 hora. A geração e verificação dos tokens são realizadas utilizando o algoritmo HMAC-SHA256 com uma chave secreta definida nas propriedades da aplicação.*/
@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;
    //Cria um token de verificação utilizando JWT. Enviamos o e-mail da entidade user dentro do token
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
    //Realiza a validação do token gerado... capturamos o email recebido no token.
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
