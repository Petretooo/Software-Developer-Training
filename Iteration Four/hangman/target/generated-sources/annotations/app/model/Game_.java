package annotations.app.model.app.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import app.model.Game;
import app.model.GameStats;
import app.model.Symbol;
import app.model.User;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Game.class)
public abstract class Game_ {

	public static volatile SetAttribute<Game, Symbol> characters;
	public static volatile SingularAttribute<Game, String> currentWord;
	public static volatile SingularAttribute<Game, char[]> hiddenWord;
	public static volatile SingularAttribute<Game, String> id;
	public static volatile SingularAttribute<Game, User> user;
	public static volatile SingularAttribute<Game, Integer> numberTries;
	public static volatile SingularAttribute<Game, GameStats> gameStats;

	public static final String CHARACTERS = "characters";
	public static final String CURRENT_WORD = "currentWord";
	public static final String HIDDEN_WORD = "hiddenWord";
	public static final String ID = "id";
	public static final String USER = "user";
	public static final String NUMBER_TRIES = "numberTries";
	public static final String GAME_STATS = "gameStats";

}

