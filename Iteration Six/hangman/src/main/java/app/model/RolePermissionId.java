package app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class RolePermissionId implements Serializable {

	@Column(name = "role_id")
	private String roleId;
	@Column(name = "permission_id")
	private String permissionId;
	
}
