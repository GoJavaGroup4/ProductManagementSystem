package ua.goit.java.service;

/**
 * Service for Security
 *
 * @author Semen
 * @version 1.0
 */
public interface SecurityService {

	String findLoggedInUserName();

	void autoLogin(String username, String password);
}
