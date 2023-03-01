
package service2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import service1.Agence;
import service1.HotelPartenaireTarif;
import service1.Reservation;


/**
 * <p>Java class for reserve complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="reserve">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://service/}hotelPartenaireTarif" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://service/}reservation" minOccurs="0"/>
 *         &lt;element name="arg2" type="{http://service/}agence" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "reserve", propOrder = {
    "arg0",
    "arg1",
    "arg2"
})
public class Reserve {

    protected HotelPartenaireTarif arg0;
    protected Reservation arg1;
    protected Agence arg2;

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
     *     {@link Reservation }
     *     
     */
    public Reservation getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Reservation }
     *     
     */
    public void setArg1(Reservation value) {
        this.arg1 = value;
    }

    /**
     * Gets the value of the arg2 property.
     * 
     * @return
     *     possible object is
     *     {@link Agence }
     *     
     */
    public Agence getArg2() {
        return arg2;
    }

    /**
     * Sets the value of the arg2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Agence }
     *     
     */
    public void setArg2(Agence value) {
        this.arg2 = value;
    }

}
