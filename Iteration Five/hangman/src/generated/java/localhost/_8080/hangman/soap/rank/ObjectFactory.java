
package localhost._8080.hangman.soap.rank;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the localhost._8080.hangman.soap.rank package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: localhost._8080.hangman.soap.rank
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Ranking }
     * 
     */
    public Ranking createRanking() {
        return new Ranking();
    }

    /**
     * Create an instance of {@link LocalDate }
     * 
     */
    public LocalDate createLocalDate() {
        return new LocalDate();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link Game }
     * 
     */
    public Game createGame() {
        return new Game();
    }

    /**
     * Create an instance of {@link Symbol }
     * 
     */
    public Symbol createSymbol() {
        return new Symbol();
    }

    /**
     * Create an instance of {@link GameStats }
     * 
     */
    public GameStats createGameStats() {
        return new GameStats();
    }

    /**
     * Create an instance of {@link UserStats }
     * 
     */
    public UserStats createUserStats() {
        return new UserStats();
    }

    /**
     * Create an instance of {@link RankingArray }
     * 
     */
    public RankingArray createRankingArray() {
        return new RankingArray();
    }

}
