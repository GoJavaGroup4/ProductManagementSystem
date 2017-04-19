package ua.goit.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Implementation of {@link SecurityService}
 *
 * @author Semen
 * @version 1.0
 */

@Service
public class SecurityServiceImp implements SecurityService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	public String findLoggedInUserName() {
		Object userDetatils = SecurityContextHolder.getContext().getAuthentication().getDetails();
		if (userDetatils instanceof UserDetails) {
			return ((UserDetails) userDetatils).getUsername();
		}
		return null;
	}

	@Override
	public void autoLogin(String username, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken authenticationToken = new
			UsernamePasswordAuthenticationToken(userDetails, password, userDetails.
			getAuthorities());
		authenticationManager.authenticate(authenticationToken);

		if (authenticationToken.isAuthenticated()){
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		}
	}
}
