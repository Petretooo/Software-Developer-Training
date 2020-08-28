
package localhost._8080.hangman.soap.rank;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for gameStats complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="gameStats"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="game" type="{http://localhost:8080/hangman/soap/rank}game" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="gameEnd" type="{http://localhost:8080/hangman/soap/rank}localDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="gameId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="gameStart" type="{http://localhost:8080/hangman/soap/rank}localDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="wordFound" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="wrongTries" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gameStats", propOrder = {
    "game",
    "gameEnd",
    "gameId",
    "gameStart",
    "id",
    "wordFound",
    "wrongTries"
})
public class GameStats {

    protected Game game;
    protected LocalDate gameEnd;
    protected String gameId;
    protected LocalDate gameStart;
    protected String id;
    protected boolean wordFound;
    protected int wrongTries;

    /**
     * Gets the value of the game property.
     * 
     * @return
     *     possible object is
     *     {@link Game }
     *     
     */
    public Game getGame() {
        return game;
    }

    /**
     * Sets the value of the game property.
     * 
     * @param value
     *     allowed object is
     *     {@link Game }
     *     
     */
    public void setGame(Game value) {
        this.game = value;
    }

    /**
     * Gets the value of the gameEnd property.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getGameEnd() {
        return gameEnd;
    }

    /**
     * Sets the value of the gameEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setGameEnd(LocalDate value) {
        this.gameEnd = value;
    }

    /**
     * Gets the value of the gameId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGameId() {
        return gameId;
    }

    /**
     * Sets the value of the gameId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGameId(String value) {
        this.gameId = value;
    }

    /**
     * Gets the value of the gameStart property.
     * 
     * @return
     *     possible object is
     *     {@link LocalDate }
     *     
     */
    public LocalDate getGameStart() {
        return gameStart;
    }

    /**
     * Sets the value of the gameStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocalDate }
     *     
     */
    public void setGameStart(LocalDate value) {
        this.gameStart = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the wordFound property.
     * 
     */
    public boolean isWordFound() {
        return wordFound;
    }

    /**
     * Sets the value of the wordFound property.
     * 
     */
    public void setWordFound(boolean value) {
        this.wordFound = value;
    }

    /**
     * Gets the value of the wrongTries property.
     * 
     */
    public int getWrongTries() {
        return wrongTries;
    }

    /**
     * Sets the value of the wrongTries property.
     * 
     */
    public void setWrongTries(int value) {
        this.wrongTries = value;
    }

}
