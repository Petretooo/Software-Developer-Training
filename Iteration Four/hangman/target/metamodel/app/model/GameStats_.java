package app.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GameStats.class)
public abstract class GameStats_ {

	public static volatile SingularAttribute<GameStats, String> gameId;
	public static volatile SingularAttribute<GameStats, Game> game;
	public static volatile SingularAttribute<GameStats, LocalDate> gameStart;
	public static volatile SingularAttribute<GameStats, Boolean> isWordFound;
	public static volatile SingularAttribute<GameStats, Integer> wrongTries;
	public static volatile SingularAttribute<GameStats, String> id;
	public static volatile SingularAttribute<GameStats, LocalDate> gameEnd;

	public static final String GAME_ID = "gameId";
	public static final String GAME = "game";
	public static final String GAME_START = "gameStart";
	public static final String IS_WORD_FOUND = "isWordFound";
	public static final String WRONG_TRIES = "wrongTries";
	public static final String ID = "id";
	public static final String GAME_END = "gameEnd";

}

