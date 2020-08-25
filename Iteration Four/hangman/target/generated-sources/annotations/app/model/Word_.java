package annotations.app.model.app.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import app.model.Word;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Word.class)
public abstract class Word_ {

	public static volatile SingularAttribute<Word, String> wordId;
	public static volatile SingularAttribute<Word, Integer> levelDifficulty;
	public static volatile SingularAttribute<Word, String> wordName;

	public static final String WORD_ID = "wordId";
	public static final String LEVEL_DIFFICULTY = "levelDifficulty";
	public static final String WORD_NAME = "wordName";

}

