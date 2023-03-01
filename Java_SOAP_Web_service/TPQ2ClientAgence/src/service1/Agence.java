
package service1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for agence complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="agence">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hotelPartenaireTarif" type="{http://service/}hotelPartenaireTarif" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="identifiant" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listReservation" type="{http://service/}reservation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="mdp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "agence", propOrder = {
    "hotelPartenaireTarif",
    "identifiant",
    "listReservation",
    "mdp"
})
public class Agence {

    @XmlElement(nillable = true)
    protected List<HotelPartenaireTarif> hotelPartenaireTarif;
    protected String identifiant;
    @XmlElement(nillable = true)
    protected List<Reservation> listReservation;
    protected String mdp;

    /**
     * Gets the value of the hotelPartenaireTarif property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hotelPartenaireTarif property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHotelPartenaireTarif().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HotelPartenaireTarif }
     * 
     * 
     */
    public List<HotelPartenaireTarif> getHotelPartenaireTarif() {
        if (hotelPartenaireTarif == null) {
            hotelPartenaireTarif = new ArrayList<HotelPartenaireTarif>();
        }
        return this.hotelPartenaireTarif;
    }

    /**
     * Gets the value of the identifiant property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentifiant() {
        return identifiant;
    }

    /**
     * Sets the value of the identifiant property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentifiant(String value) {
        this.identifiant = value;
    }

    /**
     * Gets the value of the listReservation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listReservation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListReservation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Reservation }
     * 
     * 
     */
    public List<Reservation> getListReservation() {
        if (listReservation == null) {
            listReservation = new ArrayList<Reservation>();
        }
        return this.listReservation;
    }

    /**
     * Gets the value of the mdp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * Sets the value of the mdp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMdp(String value) {
        this.mdp = value;
    }

}
