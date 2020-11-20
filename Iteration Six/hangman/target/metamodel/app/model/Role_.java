package app.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Role.class)
public abstract class Role_ {

	public static volatile SingularAttribute<Role, String> role;
	public static volatile SingularAttribute<Role, String> roleId;
	public static volatile SetAttribute<Role, RolePermission> permission;
	public static volatile SetAttribute<Role, User> users;

	public static final String ROLE = "role";
	public static final String ROLE_ID = "roleId";
	public static final String PERMISSION = "permission";
	public static final String USERS = "users";

}

