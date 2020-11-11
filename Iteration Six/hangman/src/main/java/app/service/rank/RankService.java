package app.service.rank;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import app.dto.RankingDtoList;
import app.model.GameStats;
import app.model.Ranking;
import app.model.UserStats;
import jakarta.jws.WebParam;


@WebService
@SOAPBinding
public interface RankService {
	
	@WebMethod(operationName = "SaveRank")
	public Ranking saveRank(@WebParam UserStats stat, @WebParam GameStats gameStat);
	@WebMethod(operationName = "RemoveFromRank")
	public void removeFromRank(@WebParam String rankId);
	@WebMethod(operationName = "GetRankList")
	//@WebResult(name = "rankList")
	public RankingDtoList getRankList();
	@WebMethod(operationName = "GetRankByMonth")
	//@WebResult(name = "rankListTopMonth")
	public RankingDtoList getRankByMonth();
}
