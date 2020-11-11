package app.dao.rolePermission;

import org.springframework.stereotype.Repository;

import app.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface RoleDao extends JpaRepository<Role, String>{

}
