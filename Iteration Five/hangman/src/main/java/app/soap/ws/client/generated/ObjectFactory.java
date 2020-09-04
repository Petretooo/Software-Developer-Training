
package app.soap.ws.client.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the app.soap.ws.client.generated package. 
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

    private final static QName _GetRankByMonth_QNAME = new QName("http://rank.service.app/", "GetRankByMonth");
    private final static QName _GetRankByMonthResponse_QNAME = new QName("http://rank.service.app/", "GetRankByMonthResponse");
    private final static QName _GetRankList_QNAME = new QName("http://rank.service.app/", "GetRankList");
    private final static QName _GetRankListResponse_QNAME = new QName("http://rank.service.app/", "GetRankListResponse");
    private final static QName _RemoveFromRank_QNAME = new QName("http://rank.service.app/", "RemoveFromRank");
    private final static QName _RemoveFromRankResponse_QNAME = new QName("http://rank.service.app/", "RemoveFromRankResponse");
    private final static QName _SaveRank_QNAME = new QName("http://rank.service.app/", "SaveRank");
    private final static QName _SaveRankResponse_QNAME = new QName("http://rank.service.app/", "SaveRankResponse");
    private final static QName _RankingList_QNAME = new QName("http://rank.service.app/", "rankingList");
    private final static QName _RankingSoap_QNAME = new QName("http://rank.service.app/", "rankingSoap");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: app.soap.ws.client.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRankByMonth }
     * 
     */
    public GetRankByMonth createGetRankByMonth() {
        return new GetRankByMonth();
    }

    /**
     * Create an instance of {@link GetRankByMonthResponse }
     * 
     */
    public GetRankByMonthResponse createGetRankByMonthResponse() {
        return new GetRankByMonthResponse();
    }

    /**
     * Create an instance of {@link GetRankList }
     * 
     */
    public GetRankList createGetRankList() {
        return new GetRankList();
    }

    /**
     * Create an instance of {@link GetRankListResponse }
     * 
     */
    public GetRankListResponse createGetRankListResponse() {
        return new GetRankListResponse();
    }

    /**
     * Create an instance of {@link RemoveFromRank }
     * 
     */
    public RemoveFromRank createRemoveFromRank() {
        return new RemoveFromRank();
    }

    /**
     * Create an instance of {@link RemoveFromRankResponse }
     * 
     */
    public RemoveFromRankResponse createRemoveFromRankResponse() {
        return new RemoveFromRankResponse();
    }

    /**
     * Create an instance of {@link SaveRank }
     * 
     */
    public SaveRank createSaveRank() {
        return new SaveRank();
    }

    /**
     * Create an instance of {@link SaveRankResponse }
     * 
     */
    public SaveRankResponse createSaveRankResponse() {
        return new SaveRankResponse();
    }

    /**
     * Create an instance of {@link RankingDtoList }
     * 
     */
    public RankingDtoList createRankingDtoList() {
        return new RankingDtoList();
    }

    /**
     * Create an instance of {@link RankingDto }
     * 
     */
    public RankingDto createRankingDto() {
        return new RankingDto();
    }

    /**
     * Create an instance of {@link LocalDate }
     * 
     */
    public LocalDate createLocalDate() {
        return new LocalDate();
    }

    /**
     * Create an instance of {@link UserStats }
     * 
     */
    public UserStats createUserStats() {
        return new UserStats();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link Game }
     * 
     */
    public Game createGame() {
        return new Game();
    }

    /**
     * Create an instance of {@link Symbol }
     * 
     */
    public Symbol createSymbol() {
        return new Symbol();
    }

    /**
     * Create an instance of {@link GameStats }
     * 
     */
    public GameStats createGameStats() {
        return new GameStats();
    }

    /**
     * Create an instance of {@link Ranking }
     * 
     */
    public Ranking createRanking() {
        return new Ranking();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRankByMonth }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetRankByMonth }{@code >}
     */
    @XmlElementDecl(namespace = "http://rank.service.app/", name = "GetRankByMonth")
    public JAXBElement<GetRankByMonth> createGetRankByMonth(GetRankByMonth value) {
        return new JAXBElement<GetRankByMonth>(_GetRankByMonth_QNAME, GetRankByMonth.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRankByMonthResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetRankByMonthResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://rank.service.app/", name = "GetRankByMonthResponse")
    public JAXBElement<GetRankByMonthResponse> createGetRankByMonthResponse(GetRankByMonthResponse value) {
        return new JAXBElement<GetRankByMonthResponse>(_GetRankByMonthResponse_QNAME, GetRankByMonthResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRankList }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetRankList }{@code >}
     */
    @XmlElementDecl(namespace = "http://rank.service.app/", name = "GetRankList")
    public JAXBElement<GetRankList> createGetRankList(GetRankList value) {
        return new JAXBElement<GetRankList>(_GetRankList_QNAME, GetRankList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRankListResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetRankListResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://rank.service.app/", name = "GetRankListResponse")
    public JAXBElement<GetRankListResponse> createGetRankListResponse(GetRankListResponse value) {
        return new JAXBElement<GetRankListResponse>(_GetRankListResponse_QNAME, GetRankListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveFromRank }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveFromRank }{@code >}
     */
    @XmlElementDecl(namespace = "http://rank.service.app/", name = "RemoveFromRank")
    public JAXBElement<RemoveFromRank> createRemoveFromRank(RemoveFromRank value) {
        return new JAXBElement<RemoveFromRank>(_RemoveFromRank_QNAME, RemoveFromRank.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveFromRankResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveFromRankResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://rank.service.app/", name = "RemoveFromRankResponse")
    public JAXBElement<RemoveFromRankResponse> createRemoveFromRankResponse(RemoveFromRankResponse value) {
        return new JAXBElement<RemoveFromRankResponse>(_RemoveFromRankResponse_QNAME, RemoveFromRankResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveRank }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveRank }{@code >}
     */
    @XmlElementDecl(namespace = "http://rank.service.app/", name = "SaveRank")
    public JAXBElement<SaveRank> createSaveRank(SaveRank value) {
        return new JAXBElement<SaveRank>(_SaveRank_QNAME, SaveRank.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveRankResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SaveRankResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://rank.service.app/", name = "SaveRankResponse")
    public JAXBElement<SaveRankResponse> createSaveRankResponse(SaveRankResponse value) {
        return new JAXBElement<SaveRankResponse>(_SaveRankResponse_QNAME, SaveRankResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RankingDtoList }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RankingDtoList }{@code >}
     */
    @XmlElementDecl(namespace = "http://rank.service.app/", name = "rankingList")
    public JAXBElement<RankingDtoList> createRankingList(RankingDtoList value) {
        return new JAXBElement<RankingDtoList>(_RankingList_QNAME, RankingDtoList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RankingDto }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RankingDto }{@code >}
     */
    @XmlElementDecl(namespace = "http://rank.service.app/", name = "rankingSoap")
    public JAXBElement<RankingDto> createRankingSoap(RankingDto value) {
        return new JAXBElement<RankingDto>(_RankingSoap_QNAME, RankingDto.class, null, value);
    }

}
