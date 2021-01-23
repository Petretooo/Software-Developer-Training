package app.dao.rolePermission;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.RolePermission;
import app.model.RolePermissionId;

@Repository
public interface RolePermissionDao extends JpaRepository<RolePermission, RolePermissionId> {

}
