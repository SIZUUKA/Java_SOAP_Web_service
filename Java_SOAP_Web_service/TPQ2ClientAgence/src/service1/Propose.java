
package service1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for propose complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="propose">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hotelPartenaireTarif" type="{http://service/}hotelPartenaireTarif" minOccurs="0"/>
 *         &lt;element name="listChambre" type="{http://service/}chambre" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="offreId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "propose", propOrder = {
    "hotelPartenaireTarif",
    "listChambre",
    "offreId"
})
public class Propose {

    protected HotelPartenaireTarif hotelPartenaireTarif;
    @XmlElement(nillable = true)
    protected List<Chambre> listChambre;
    protected String offreId;

    /**
     * Gets the value of the hotelPartenaireTarif property.
     * 
     * @return
     *     possible object is
     *     {@link HotelPartenaireTarif }
     *     
     */
    public HotelPartenaireTarif getHotelPartenaireTarif() {
        return hotelPartenaireTarif;
    }

    /**
     * Sets the value of the hotelPartenaireTarif property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelPartenaireTarif }
     *     
     */
    public void setHotelPartenaireTarif(HotelPartenaireTarif value) {
        this.hotelPartenaireTarif = value;
    }

    /**
     * Gets the value of the listChambre property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listChambre property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListChambre().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Chambre }
     * 
     * 
     */
    public List<Chambre> getListChambre() {
        if (listChambre == null) {
            listChambre = new ArrayList<Chambre>();
        }
        return this.listChambre;
    }

    /**
     * Gets the value of the offreId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOffreId() {
        return offreId;
    }

    /**
     * Sets the value of the offreId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOffreId(String value) {
        this.offreId = value;
    }

}
