package ua.goit.java.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.goit.java.model.Role;

@Repository
public class RoleDao{

	@Autowired
	private SessionFactory sessionFactory;

	public Role getOne(long l) {
		Session session = sessionFactory.getCurrentSession();
		Role role = session.load(Role.class, l);
		return role;
	}

}
