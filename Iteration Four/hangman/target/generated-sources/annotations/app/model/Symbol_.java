package annotations.app.model.app.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import app.model.Game;
import app.model.Symbol;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Symbol.class)
public abstract class Symbol_ {

	public static volatile SingularAttribute<Symbol, Game> game;
	public static volatile SingularAttribute<Symbol, Character> letter;
	public static volatile SingularAttribute<Symbol, String> characterId;

	public static final String GAME = "game";
	public static final String LETTER = "letter";
	public static final String CHARACTER_ID = "characterId";

}

