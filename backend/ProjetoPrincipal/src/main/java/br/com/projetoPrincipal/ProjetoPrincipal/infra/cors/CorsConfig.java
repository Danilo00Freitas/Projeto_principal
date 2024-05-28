package br.com.projetoPrincipal.ProjetoPrincipal.infra.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                /*preciso alterar para o domínio correto futuramente conforme for evoluindo a aplicação*/
                .allowedOrigins("http://127.0.0.1:5500")
                /*posso colocar os demais métodos conforme for aprimorando a aplicação...*/
                .allowedMethods("GET","POST")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
