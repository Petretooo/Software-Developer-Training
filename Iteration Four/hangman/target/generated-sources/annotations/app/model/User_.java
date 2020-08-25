package annotations.app.model.app.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import app.model.Game;
import app.model.Ranking;
import app.model.User;
import app.model.UserStats;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SetAttribute<User, UserStats> userStats;
	public static volatile SetAttribute<User, Game> games;
	public static volatile SetAttribute<User, Ranking> rank;
	public static volatile SingularAttribute<User, String> userId;
	public static volatile SingularAttribute<User, String> username;

	public static final String USER_STATS = "userStats";
	public static final String GAMES = "games";
	public static final String RANK = "rank";
	public static final String USER_ID = "userId";
	public static final String USERNAME = "username";

}

