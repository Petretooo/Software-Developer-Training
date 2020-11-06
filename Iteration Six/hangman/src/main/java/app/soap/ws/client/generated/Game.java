
package app.soap.ws.client.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for game complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="game"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="characters" type="{http://rank.service.app/}symbol" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="currentWord" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="gameStats" type="{http://rank.service.app/}gameStats" minOccurs="0"/&gt;
 *         &lt;element name="hiddenWord" type="{http://www.w3.org/2001/XMLSchema}unsignedShort" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numberTries" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="user" type="{http://rank.service.app/}user" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "game", propOrder = {
    "characters",
    "currentWord",
    "gameStats",
    "hiddenWord",
    "id",
    "numberTries",
    "user"
})
public class Game {

    @XmlElement(nillable = true)
    protected List<Symbol> characters;
    protected String currentWord;
    protected GameStats gameStats;
    @XmlElement(nillable = true)
    @XmlSchemaType(name = "unsignedShort")
    protected List<Integer> hiddenWord;
    protected String id;
    protected int numberTries;
    protected User user;

    /**
     * Gets the value of the characters property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the characters property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCharacters().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Symbol }
     * 
     * 
     */
    public List<Symbol> getCharacters() {
        if (characters == null) {
            characters = new ArrayList<Symbol>();
        }
        return this.characters;
    }

    /**
     * Gets the value of the currentWord property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentWord() {
        return currentWord;
    }

    /**
     * Sets the value of the currentWord property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentWord(String value) {
        this.currentWord = value;
    }

    /**
     * Gets the value of the gameStats property.
     * 
     * @return
     *     possible object is
     *     {@link GameStats }
     *     
     */
    public GameStats getGameStats() {
        return gameStats;
    }

    /**
     * Sets the value of the gameStats property.
     * 
     * @param value
     *     allowed object is
     *     {@link GameStats }
     *     
     */
    public void setGameStats(GameStats value) {
        this.gameStats = value;
    }

    /**
     * Gets the value of the hiddenWord property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hiddenWord property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHiddenWord().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    public List<Integer> getHiddenWord() {
        if (hiddenWord == null) {
            hiddenWord = new ArrayList<Integer>();
        }
        return this.hiddenWord;
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
     * Gets the value of the numberTries property.
     * 
     */
    public int getNumberTries() {
        return numberTries;
    }

    /**
     * Sets the value of the numberTries property.
     * 
     */
    public void setNumberTries(int value) {
        this.numberTries = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUser(User value) {
        this.user = value;
    }

}
