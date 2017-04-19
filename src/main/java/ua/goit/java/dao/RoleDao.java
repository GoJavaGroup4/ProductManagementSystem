package ua.goit.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.java.model.Role;

public interface RoleDao extends JpaRepository<Role, Long> {

}
