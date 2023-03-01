
package service2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for carteCredit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="carteCredit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="carteNumero" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cvcCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="expireAnnee" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="expireMois" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "carteCredit", propOrder = {
    "carteNumero",
    "cvcCode",
    "expireAnnee",
    "expireMois"
})
public class CarteCredit {

    protected String carteNumero;
    protected String cvcCode;
    protected int expireAnnee;
    protected int expireMois;

    /**
     * Gets the value of the carteNumero property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarteNumero() {
        return carteNumero;
    }

    /**
     * Sets the value of the carteNumero property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarteNumero(String value) {
        this.carteNumero = value;
    }

    /**
     * Gets the value of the cvcCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCvcCode() {
        return cvcCode;
    }

    /**
     * Sets the value of the cvcCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCvcCode(String value) {
        this.cvcCode = value;
    }

    /**
     * Gets the value of the expireAnnee property.
     * 
     */
    public int getExpireAnnee() {
        return expireAnnee;
    }

    /**
     * Sets the value of the expireAnnee property.
     * 
     */
    public void setExpireAnnee(int value) {
        this.expireAnnee = value;
    }

    /**
     * Gets the value of the expireMois property.
     * 
     */
    public int getExpireMois() {
        return expireMois;
    }

    /**
     * Sets the value of the expireMois property.
     * 
     */
    public void setExpireMois(int value) {
        this.expireMois = value;
    }

}
