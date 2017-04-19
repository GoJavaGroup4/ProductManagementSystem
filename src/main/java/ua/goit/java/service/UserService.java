package ua.goit.java.service;

import ua.goit.java.model.User;

/**
 * Service class for {@link ua.goit.java.model.User}
 *
 * @author Semen
 * @version 1.0
 *
 */

public interface UserService {

	void save(User user);

	User findUserByName(String username);
}
