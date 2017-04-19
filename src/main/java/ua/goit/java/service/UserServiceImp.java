package ua.goit.java.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.goit.java.dao.RoleDao;
import ua.goit.java.dao.UserDao;
import ua.goit.java.model.Role;
import ua.goit.java.model.User;


/**
 * Implementation of {@link UserService} interface
 *
 * @author Semen
 * @version 1.0
 */

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Set<Role> roles = new HashSet<>();
		roles.add(roleDao.getOne(1L)); //by default all new user has ROLE_USER
		user.setRoles(roles);
		userDao.save(user);
	}

	@Override
	public User findUserByName(String username) {
		return userDao.findByUsername(username);
	}
}
