package ua.goit.java.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.goit.java.model.User;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public User findByUsername(String username) {
		List<User> users = sessionFactory.getCurrentSession().
			createQuery("select User from users").list();
		User userToFind = null;
		for (User user : users) {
			if (user.getUsername().equals(username)) {
				userToFind = user;
			}
		}
		return userToFind;
	}

	public void save(User user){
		sessionFactory.getCurrentSession().save(user);
	}


}
