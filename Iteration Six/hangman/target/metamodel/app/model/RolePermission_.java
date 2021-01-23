package app.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RolePermission.class)
public abstract class RolePermission_ {

	public static volatile SingularAttribute<RolePermission, Role> role;
	public static volatile SingularAttribute<RolePermission, Permission> permission;
	public static volatile SingularAttribute<RolePermission, RolePermissionId> id;

	public static final String ROLE = "role";
	public static final String PERMISSION = "permission";
	public static final String ID = "id";

}

