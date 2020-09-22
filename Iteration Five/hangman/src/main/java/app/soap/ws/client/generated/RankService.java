
package app.soap.ws.client.generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "RankService", targetNamespace = "http://rank.service.app/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RankService {


    /**
     * 
     * @return
     *     returns app.soap.ws.client.generated.RankingDtoList
     */
    @WebMethod(operationName = "GetRankByMonth")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetRankByMonth", targetNamespace = "http://rank.service.app/", className = "app.soap.ws.client.generated.GetRankByMonth")
    @ResponseWrapper(localName = "GetRankByMonthResponse", targetNamespace = "http://rank.service.app/", className = "app.soap.ws.client.generated.GetRankByMonthResponse")
    public RankingDtoList getRankByMonth();

    /**
     * 
     * @return
     *     returns app.soap.ws.client.generated.RankingDtoList
     */
    @WebMethod(operationName = "GetRankList")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetRankList", targetNamespace = "http://rank.service.app/", className = "app.soap.ws.client.generated.GetRankList")
    @ResponseWrapper(localName = "GetRankListResponse", targetNamespace = "http://rank.service.app/", className = "app.soap.ws.client.generated.GetRankListResponse")
    public RankingDtoList getRankList();

    /**
     * 
     * @param arg0
     */
    @WebMethod(operationName = "RemoveFromRank")
    @RequestWrapper(localName = "RemoveFromRank", targetNamespace = "http://rank.service.app/", className = "app.soap.ws.client.generated.RemoveFromRank")
    @ResponseWrapper(localName = "RemoveFromRankResponse", targetNamespace = "http://rank.service.app/", className = "app.soap.ws.client.generated.RemoveFromRankResponse")
    public void removeFromRank(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns app.soap.ws.client.generated.Ranking
     */
    @WebMethod(operationName = "SaveRank")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "SaveRank", targetNamespace = "http://rank.service.app/", className = "app.soap.ws.client.generated.SaveRank")
    @ResponseWrapper(localName = "SaveRankResponse", targetNamespace = "http://rank.service.app/", className = "app.soap.ws.client.generated.SaveRankResponse")
    public Ranking saveRank(
        @WebParam(name = "arg0", targetNamespace = "")
        UserStats arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        GameStats arg1);

}