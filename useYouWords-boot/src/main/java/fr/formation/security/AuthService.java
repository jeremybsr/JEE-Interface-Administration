package fr.formation.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.formation.dao.IUtilisateurRepository;
import fr.formation.model.Utilisateur;
@Service
public class AuthService implements UserDetailsService {
	@Autowired
	private IUtilisateurRepository daoUtilisateur;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Utilisateur utilisateur =
			this.daoUtilisateur
				.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("username not found"));
		
		return new UtilisateurPrincipal(utilisateur);
	}

}
