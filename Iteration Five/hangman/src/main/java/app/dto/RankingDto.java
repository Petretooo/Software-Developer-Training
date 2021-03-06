package app.dto;

import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import app.model.Ranking;
import app.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement(name = "rankingSoap")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "id", "idUserRank", "username", "word", "score", "date"})
public class RankingDto {

	@XmlAttribute
	private String id;
	@XmlElement(name = "idUserRank")
	private String idUserRank;
	@XmlTransient
	private User user;
	@XmlElement(name = "username")
	private String username;
	@XmlElement(name = "word")
	private String word;
	@XmlElement(name = "score")
	private int score;
	@XmlElement(name = "date")
	private LocalDate date;
	
	
	
	public static RankingDto fromRanking(Ranking rank) {
		RankingDto dto = new RankingDto();
		dto.setId(rank.getId());
		dto.setIdUserRank(rank.getIdUserRank());
		dto.setUsername(rank.getUser().getUsername());
		dto.setUser(rank.getUser());
		dto.setScore(rank.getScore());
		dto.setWord(rank.getWord());
		dto.setDate(rank.getDate());
		return dto;
	}
}
