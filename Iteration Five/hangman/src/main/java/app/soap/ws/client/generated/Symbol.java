
package app.soap.ws.client.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for symbol complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="symbol"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="characterId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="letter" type="{http://www.w3.org/2001/XMLSchema}unsignedShort"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "symbol", propOrder = {
    "characterId",
    "letter"
})
public class Symbol {

    protected String characterId;
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
