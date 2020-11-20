package app.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Permission.class)
public abstract class Permission_ {

	public static volatile SingularAttribute<Permission, String> permissionId;
	public static volatile SetAttribute<Permission, RolePermission> role;
	public static volatile SingularAttribute<Permission, String> permission;

	public static final String PERMISSION_ID = "permissionId";
	public static final String ROLE = "role";
	public static final String PERMISSION = "permission";

}

