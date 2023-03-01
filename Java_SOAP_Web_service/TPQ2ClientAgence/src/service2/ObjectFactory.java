
package service2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import service1.Agence;
import service1.Chambre;
import service1.Client;
import service1.Hotel;
import service1.HotelPartenaireTarif;
import service1.Lit;
import service1.Reservation;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateCarteCredit_QNAME = new QName("http://service/", "createCarteCredit");
    private final static QName _AgenceLoginResResponse_QNAME = new QName("http://service/", "agenceLoginResResponse");
    private final static QName _CreateCarteCreditResponse_QNAME = new QName("http://service/", "createCarteCreditResponse");
    private final static QName _ReserveResponse_QNAME = new QName("http://service/", "reserveResponse");
    private final static QName _AgenceLoginRes_QNAME = new QName("http://service/", "agenceLoginRes");
    private final static QName _CreateReservation_QNAME = new QName("http://service/", "createReservation");
    private final static QName _CreateReservationResponse_QNAME = new QName("http://service/", "createReservationResponse");
    private final static QName _CreateClient_QNAME = new QName("http://service/", "createClient");
    private final static QName _CreateClientResponse_QNAME = new QName("http://service/", "createClientResponse");
    private final static QName _Reserve_QNAME = new QName("http://service/", "reserve");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateClient }
     * 
     */
    public CreateClient createCreateClient() {
        return new CreateClient();
    }

    /**
     * Create an instance of {@link CreateReservation }
     * 
     */
    public CreateReservation createCreateReservation() {
        return new CreateReservation();
    }

    /**
     * Create an instance of {@link CreateReservationResponse }
     * 
     */
    public CreateReservationResponse createCreateReservationResponse() {
        return new CreateReservationResponse();
    }

    /**
     * Create an instance of {@link AgenceLoginRes }
     * 
     */
    public AgenceLoginRes createAgenceLoginRes() {
        return new AgenceLoginRes();
    }

    /**
     * Create an instance of {@link AgenceLoginResResponse }
     * 
     */
    public AgenceLoginResResponse createAgenceLoginResResponse() {
        return new AgenceLoginResResponse();
    }

    /**
     * Create an instance of {@link CreateCarteCreditResponse }
     * 
     */
    public CreateCarteCreditResponse createCreateCarteCreditResponse() {
        return new CreateCarteCreditResponse();
    }

    /**
     * Create an instance of {@link ReserveResponse }
     * 
     */
    public ReserveResponse createReserveResponse() {
        return new ReserveResponse();
    }

    /**
     * Create an instance of {@link CreateCarteCredit }
     * 
     */
    public CreateCarteCredit createCreateCarteCredit() {
        return new CreateCarteCredit();
    }

    /**
     * Create an instance of {@link Reserve }
     * 
     */
    public Reserve createReserve() {
        return new Reserve();
    }

    /**
     * Create an instance of {@link CreateClientResponse }
     * 
     */
    public CreateClientResponse createCreateClientResponse() {
        return new CreateClientResponse();
    }

    /**
     * Create an instance of {@link HotelPartenaireTarif }
     * 
     */
    public HotelPartenaireTarif createHotelPartenaireTarif() {
        return new HotelPartenaireTarif();
    }

    /**
     * Create an instance of {@link Chambre }
     * 
     */
    public Chambre createChambre() {
        return new Chambre();
    }

    /**
     * Create an instance of {@link Agence }
     * 
     */
    public Agence createAgence() {
        return new Agence();
    }

    /**
     * Create an instance of {@link Lit }
     * 
     */
    public Lit createLit() {
        return new Lit();
    }

    /**
     * Create an instance of {@link CarteCredit }
     * 
     */
    public CarteCredit createCarteCredit() {
        return new CarteCredit();
    }

    /**
     * Create an instance of {@link Hotel }
     * 
     */
    public Hotel createHotel() {
        return new Hotel();
    }

    /**
     * Create an instance of {@link Reservation }
     * 
     */
    public Reservation createReservation() {
        return new Reservation();
    }

    /**
     * Create an instance of {@link Client }
     * 
     */
    public Client createClient() {
        return new Client();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCarteCredit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "createCarteCredit")
    public JAXBElement<CreateCarteCredit> createCreateCarteCredit(CreateCarteCredit value) {
        return new JAXBElement<CreateCarteCredit>(_CreateCarteCredit_QNAME, CreateCarteCredit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgenceLoginResResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "agenceLoginResResponse")
    public JAXBElement<AgenceLoginResResponse> createAgenceLoginResResponse(AgenceLoginResResponse value) {
        return new JAXBElement<AgenceLoginResResponse>(_AgenceLoginResResponse_QNAME, AgenceLoginResResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCarteCreditResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "createCarteCreditResponse")
    public JAXBElement<CreateCarteCreditResponse> createCreateCarteCreditResponse(CreateCarteCreditResponse value) {
        return new JAXBElement<CreateCarteCreditResponse>(_CreateCarteCreditResponse_QNAME, CreateCarteCreditResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "reserveResponse")
    public JAXBElement<ReserveResponse> createReserveResponse(ReserveResponse value) {
        return new JAXBElement<ReserveResponse>(_ReserveResponse_QNAME, ReserveResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgenceLoginRes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "agenceLoginRes")
    public JAXBElement<AgenceLoginRes> createAgenceLoginRes(AgenceLoginRes value) {
        return new JAXBElement<AgenceLoginRes>(_AgenceLoginRes_QNAME, AgenceLoginRes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateReservation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "createReservation")
    public JAXBElement<CreateReservation> createCreateReservation(CreateReservation value) {
        return new JAXBElement<CreateReservation>(_CreateReservation_QNAME, CreateReservation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateReservationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "createReservationResponse")
    public JAXBElement<CreateReservationResponse> createCreateReservationResponse(CreateReservationResponse value) {
        return new JAXBElement<CreateReservationResponse>(_CreateReservationResponse_QNAME, CreateReservationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateClient }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "createClient")
    public JAXBElement<CreateClient> createCreateClient(CreateClient value) {
        return new JAXBElement<CreateClient>(_CreateClient_QNAME, CreateClient.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateClientResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "createClientResponse")
    public JAXBElement<CreateClientResponse> createCreateClientResponse(CreateClientResponse value) {
        return new JAXBElement<CreateClientResponse>(_CreateClientResponse_QNAME, CreateClientResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Reserve }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "reserve")
    public JAXBElement<Reserve> createReserve(Reserve value) {
        return new JAXBElement<Reserve>(_Reserve_QNAME, Reserve.class, null, value);
    }

}
