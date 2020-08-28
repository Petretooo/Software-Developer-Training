
package localhost._8080.hangman.soap.rank;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for symbol complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="symbol"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="characterId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="game" type="{http://localhost:8080/hangman/soap/rank}game" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="letter" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "symbol", propOrder = {
    "characterId",
    "game",
    "letter"
})
public class Symbol {

    protected String characterId;
    protected Game game;
    @XmlSchemaType(name = "unsignedShort")
    protected int letter;

    /**
     * Gets the value of the characterId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCharacterId() {
        return characterId;
    }

    /**
     * Sets the value of the characterId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCharacterId(String value) {
        this.characterId = value;
    }

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
     * Gets the value of the letter property.
     * 
     */
    public int getLetter() {
        return letter;
    }

    /**
     * Sets the value of the letter property.
     * 
     */
    public void setLetter(int value) {
        this.letter = value;
    }

}
