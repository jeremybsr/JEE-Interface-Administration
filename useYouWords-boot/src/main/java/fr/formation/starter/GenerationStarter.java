package fr.formation.starter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.formation.dao.IUtilisateurRepository;
import fr.formation.model.Utilisateur;

@Service
@Profile("starter")
public class GenerationStarter {
	@Autowired
	private IUtilisateurRepository daoUtilisateur;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@PostConstruct
	public void init() {
		Utilisateur admin = new Utilisateur();
		
		admin.setUsername("visiteur");
		admin.setPassword(passwordEncoder.encode("test"));
		
		admin.setAdmin(true);
		
		this.daoUtilisateur.save(admin);
	}

}
