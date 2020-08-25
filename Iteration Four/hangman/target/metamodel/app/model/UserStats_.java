package app.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserStats.class)
public abstract class UserStats_ {

	public static volatile SingularAttribute<UserStats, Integer> score;
	public static volatile SingularAttribute<UserStats, String> idUserStats;
	public static volatile SingularAttribute<UserStats, String> id;
	public static volatile SingularAttribute<UserStats, String> word;
	public static volatile SingularAttribute<UserStats, User> user;

	public static final String SCORE = "score";
	public static final String ID_USER_STATS = "idUserStats";
	public static final String ID = "id";
	public static final String WORD = "word";
	public static final String USER = "user";

}

