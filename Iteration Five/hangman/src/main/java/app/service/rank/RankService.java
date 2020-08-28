package app.service.rank;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import app.model.GameStats;
import app.model.Ranking;
import app.model.UserStats;

@WebService(targetNamespace = "http://localhost:8080/hangman/soap/rank")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public interface RankService {
	
	public Ranking saveRank(UserStats stat, GameStats gameStat);
	public void removeFromRank(String rankId);
	@WebMethod
	public List<Ranking> getRankList();
	@WebMethod
	public List<Ranking> getRankByMonth();

}
