
package service2;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import service1.Agence;
import service1.Chambre;
import service1.Client;
import service1.Reservation;
import service1.HotelPartenaireTarif;

/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IHotelServiceWeb2", targetNamespace = "http://service/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IHotelServiceWeb2 {


    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "reserve", targetNamespace = "http://service/", className = "service2.Reserve")
    @ResponseWrapper(localName = "reserveResponse", targetNamespace = "http://service/", className = "service2.ReserveResponse")
    @Action(input = "http://service/IHotelServiceWeb2/reserveRequest", output = "http://service/IHotelServiceWeb2/reserveResponse")
    public void reserve(
        @WebParam(name = "arg0", targetNamespace = "")
        HotelPartenaireTarif arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Reservation arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        Agence arg2);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns service2.CarteCredit
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createCarteCredit", targetNamespace = "http://service/", className = "service2.CreateCarteCredit")
    @ResponseWrapper(localName = "createCarteCreditResponse", targetNamespace = "http://service/", className = "service2.CreateCarteCreditResponse")
    @Action(input = "http://service/IHotelServiceWeb2/createCarteCreditRequest", output = "http://service/IHotelServiceWeb2/createCarteCreditResponse")
    public CarteCredit createCarteCredit(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        int arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns service2.Client
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createClient", targetNamespace = "http://service/", className = "service2.CreateClient")
    @ResponseWrapper(localName = "createClientResponse", targetNamespace = "http://service/", className = "service2.CreateClientResponse")
    @Action(input = "http://service/IHotelServiceWeb2/createClientRequest", output = "http://service/IHotelServiceWeb2/createClientResponse")
    public Client createClient(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        CarteCredit arg2);

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg5
     * @param arg4
     * @param arg1
     * @param arg0
     * @param arg7
     * @param arg6
     * @return
     *     returns service2.Reservation
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "createReservation", targetNamespace = "http://service/", className = "service2.CreateReservation")
    @ResponseWrapper(localName = "createReservationResponse", targetNamespace = "http://service/", className = "service2.CreateReservationResponse")
    @Action(input = "http://service/IHotelServiceWeb2/createReservationRequest", output = "http://service/IHotelServiceWeb2/createReservationResponse")
    public Reservation createReservation(
        @WebParam(name = "arg0", targetNamespace = "")
        HotelPartenaireTarif arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        List<Chambre> arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        XMLGregorianCalendar arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        XMLGregorianCalendar arg4,
        @WebParam(name = "arg5", targetNamespace = "")
        Client arg5,
        @WebParam(name = "arg6", targetNamespace = "")
        double arg6,
        @WebParam(name = "arg7", targetNamespace = "")
        Agence arg7);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns service2.Agence
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "agenceLoginRes", targetNamespace = "http://service/", className = "service2.AgenceLoginRes")
    @ResponseWrapper(localName = "agenceLoginResResponse", targetNamespace = "http://service/", className = "service2.AgenceLoginResResponse")
    @Action(input = "http://service/IHotelServiceWeb2/agenceLoginResRequest", output = "http://service/IHotelServiceWeb2/agenceLoginResResponse")
    public Agence agenceLoginRes(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

}