
package service1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for chambre complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="chambre">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chambreId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="litCollection" type="{http://service/}lit" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="prix" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chambre", propOrder = {
    "chambreId",
    "litCollection",
    "prix"
})
public class Chambre {

    protected String chambreId;
    @XmlElement(nillable = true)
    protected List<Lit> litCollection;
    protected double prix;

    /**
     * Gets the value of the chambreId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChambreId() {
        return chambreId;
    }

    /**
     * Sets the value of the chambreId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChambreId(String value) {
        this.chambreId = value;
    }

    /**
     * Gets the value of the litCollection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the litCollection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLitCollection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Lit }
     * 
     * 
     */
    public List<Lit> getLitCollection() {
        if (litCollection == null) {
            litCollection = new ArrayList<Lit>();
        }
        return this.litCollection;
    }

    /**
     * Gets the value of the prix property.
     * 
     */
    public double getPrix() {
        return prix;
    }

    /**
     * Sets the value of the prix property.
     * 
     */
    public void setPrix(double value) {
        this.prix = value;
    }

}
