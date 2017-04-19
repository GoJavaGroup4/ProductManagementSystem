package ua.goit.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.java.model.User;

public interface UserDao extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
