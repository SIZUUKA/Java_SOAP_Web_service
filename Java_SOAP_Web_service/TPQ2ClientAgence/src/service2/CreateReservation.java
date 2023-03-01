
package service2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import service1.Agence;
import service1.Chambre;
import service1.Client;
import service1.HotelPartenaireTarif;


/**
 * <p>Java class for createReservation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createReservation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://service/}hotelPartenaireTarif" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arg2" type="{http://service/}chambre" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="arg3" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="arg4" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="arg5" type="{http://service/}client" minOccurs="0"/>
 *         &lt;element name="arg6" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="arg7" type="{http://service/}agence" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createReservation", propOrder = {
    "arg0",
    "arg1",
    "arg2",
    "arg3",
    "arg4",
    "arg5",
    "arg6",
    "arg7"
})
public class CreateReservation {

    protected HotelPartenaireTarif arg0;
    protected String arg1;
    protected List<Chambre> arg2;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar arg3;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar arg4;
    protected Client arg5;
    protected double arg6;
    protected Agence arg7;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link HotelPartenaireTarif }
     *     
     */
    public HotelPartenaireTarif getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link HotelPartenaireTarif }
     *     
     */
    public void setArg0(HotelPartenaireTarif value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg1(String value) {
        this.arg1 = value;
    }

    /**
     * Gets the value of the arg2 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arg2 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArg2().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Chambre }
     * 
     * 
     */
    public List<Chambre> getArg2() {
        if (arg2 == null) {
            arg2 = new ArrayList<Chambre>();
        }
        return this.arg2;
    }

    /**
     * Gets the value of the arg3 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getArg3() {
        return arg3;
    }

    /**
     * Sets the value of the arg3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setArg3(XMLGregorianCalendar value) {
        this.arg3 = value;
    }

    /**
     * Gets the value of the arg4 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getArg4() {
        return arg4;
    }

    /**
     * Sets the value of the arg4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setArg4(XMLGregorianCalendar value) {
        this.arg4 = value;
    }

    /**
     * Gets the value of the arg5 property.
     * 
     * @return
     *     possible object is
     *     {@link Client }
     *     
     */
    public Client getArg5() {
        return arg5;
    }

    /**
     * Sets the value of the arg5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Client }
     *     
     */
    public void setArg5(Client value) {
        this.arg5 = value;
    }

    /**
     * Gets the value of the arg6 property.
     * 
     */
    public double getArg6() {
        return arg6;
    }

    /**
     * Sets the value of the arg6 property.
     * 
     */
    public void setArg6(double value) {
        this.arg6 = value;
    }

    /**
     * Gets the value of the arg7 property.
     * 
     * @return
     *     possible object is
     *     {@link Agence }
     *     
     */
    public Agence getArg7() {
        return arg7;
    }

    /**
     * Sets the value of the arg7 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Agence }
     *     
     */
    public void setArg7(Agence value) {
        this.arg7 = value;
    }

}
