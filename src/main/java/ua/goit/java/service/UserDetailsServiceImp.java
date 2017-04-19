package ua.goit.java.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.dao.UserDao;
import ua.goit.java.model.Role;
import ua.goit.java.model.User;

/**
 * Implementation of {@link UserDetailsService} interface
 *
 * @author Semen
 * @version 1.0
 *
 */
public class UserDetailsServiceImp implements UserDetailsService{

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional (readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		for (Role role:user.getRoles()){
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user
			.getPassword(), grantedAuthorities);
	}
}
