
package service1;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for reservation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="agence" type="{http://service/}agence" minOccurs="0"/>
 *         &lt;element name="chambreReserveCollection" type="{http://service/}chambre" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="client" type="{http://service/}client" minOccurs="0"/>
 *         &lt;element name="dateArrivee" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateDepart" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="prix" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="reservationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reservation", propOrder = {
    "agence",
    "chambreReserveCollection",
    "client",
    "dateArrivee",
    "dateDepart",
    "prix",
    "reservationId"
})
public class Reservation {

    protected Agence agence;
    @XmlElement(nillable = true)
    protected List<Chambre> chambreReserveCollection;
    protected Client client;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateArrivee;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateDepart;
    protected double prix;
    protected String reservationId;

    /**
     * Gets the value of the agence property.
     * 
     * @return
     *     possible object is
     *     {@link Agence }
     *     
     */
    public Agence getAgence() {
        return agence;
    }

    /**
     * Sets the value of the agence property.
     * 
     * @param value
     *     allowed object is
     *     {@link Agence }
     *     
     */
    public void setAgence(Agence value) {
        this.agence = value;
    }

    /**
     * Gets the value of the chambreReserveCollection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the chambreReserveCollection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChambreReserveCollection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Chambre }
     * 
     * 
     */
    public List<Chambre> getChambreReserveCollection() {
        if (chambreReserveCollection == null) {
            chambreReserveCollection = new ArrayList<Chambre>();
        }
        return this.chambreReserveCollection;
    }

    /**
     * Gets the value of the client property.
     * 
     * @return
     *     possible object is
     *     {@link Client }
     *     
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets the value of the client property.
     * 
     * @param value
     *     allowed object is
     *     {@link Client }
     *     
     */
    public void setClient(Client value) {
        this.client = value;
    }

    /**
     * Gets the value of the dateArrivee property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateArrivee() {
        return dateArrivee;
    }

    /**
     * Sets the value of the dateArrivee property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateArrivee(XMLGregorianCalendar value) {
        this.dateArrivee = value;
    }

    /**
     * Gets the value of the dateDepart property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateDepart() {
        return dateDepart;
    }

    /**
     * Sets the value of the dateDepart property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateDepart(XMLGregorianCalendar value) {
        this.dateDepart = value;
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

    /**
     * Gets the value of the reservationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservationId() {
        return reservationId;
    }

    /**
     * Sets the value of the reservationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservationId(String value) {
        this.reservationId = value;
    }

}
