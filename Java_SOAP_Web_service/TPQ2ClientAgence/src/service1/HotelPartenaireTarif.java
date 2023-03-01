
package service1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for hotelPartenaireTarif complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="hotelPartenaireTarif">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="hotel" type="{http://service/}hotel" minOccurs="0"/>
 *         &lt;element name="pourcentage" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hotelPartenaireTarif", propOrder = {
    "hotel",
    "pourcentage"
})
public class HotelPartenaireTarif {

    protected Hotel hotel;
    protected double pourcentage;

    /**
     * Gets the value of the hotel property.
     * 
     * @return
     *     possible object is
     *     {@link Hotel }
     *     
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * Sets the value of the hotel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Hotel }
     *     
     */
    public void setHotel(Hotel value) {
        this.hotel = value;
    }

    /**
     * Gets the value of the pourcentage property.
     * 
     */
    public double getPourcentage() {
        return pourcentage;
    }

    /**
     * Sets the value of the pourcentage property.
     * 
     */
    public void setPourcentage(double value) {
        this.pourcentage = value;
    }

}
