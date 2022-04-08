package be.technifutur.demo_mvc.securities;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        jsr250Enabled = true, // Vérifie un rôle
        securedEnabled = true, // Vérifie un rôle
        prePostEnabled = true // Vérifie bien plus de choses
)
public class WebSecurityConfig {
}
