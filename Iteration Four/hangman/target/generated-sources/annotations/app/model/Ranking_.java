package annotations.app.model.app.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import app.model.Ranking;
import app.model.User;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Ranking.class)
public abstract class Ranking_ {

	public static volatile SingularAttribute<Ranking, LocalDate> date;
	public static volatile SingularAttribute<Ranking, Integer> score;
	public static volatile SingularAttribute<Ranking, String> idUserRank;
	public static volatile SingularAttribute<Ranking, String> id;
	public static volatile SingularAttribute<Ranking, User> user;
	public static volatile SingularAttribute<Ranking, String> word;

	public static final String DATE = "date";
	public static final String SCORE = "score";
	public static final String ID_USER_RANK = "idUserRank";
	public static final String ID = "id";
	public static final String USER = "user";
	public static final String WORD = "word";

}

