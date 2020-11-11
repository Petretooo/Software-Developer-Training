package app.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.RankingDto;
import app.model.Ranking;
import app.service.rank.RankService;

@RestController
@RequestMapping("/api/v1/rank")
@CrossOrigin("http://localhost:3000")
public class RankApi {
	
	@Autowired
	private RankService rankService;
	
	
	@GetMapping(value = "/topTen", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RankingDto>> getTopTen() {
		List<RankingDto> rankList = rankService.getRankList().getDtoList();
		return ResponseEntity.ok(rankList);
	}
	
	@GetMapping(value = "/topMonth", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RankingDto>> getTopForMonth() {
		List<RankingDto> rankList = rankService.getRankByMonth().getDtoList();
		return ResponseEntity.ok(rankList);
	}
	
}