package app.dao.rolePermission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Permission;

@Repository
public interface PermissionDao extends JpaRepository<Permission, String>{

}
