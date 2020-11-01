package fr.formation.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
private Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		this.logger.info("Création BCrypt encoder");
		
		return new BCryptPasswordEncoder();
	}
}
