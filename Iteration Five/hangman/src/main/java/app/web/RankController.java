package app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import app.dto.RankingDto;
import app.model.Ranking;
import app.service.rank.RankService;

@Controller
@RequestMapping("/rank")
public class RankController {
	
	@Autowired
	private RankService rankService;

	@GetMapping
	public String getRank() {
		return "rank";
	}
	
	@GetMapping("/topTen")
	public String getTopTen(Model model) {
		List<RankingDto> rankList = rankService.getRankList().getDtoList();
		model.addAttribute("show", rankList);
		return "rankTopTen";
	}
	
	@GetMapping("/topMonth")
	public String getTopForMonth(Model model) {
		List<RankingDto> rankList = rankService.getRankByMonth().getDtoList();
		model.addAttribute("show", rankList);
		return "rankTopForMonth";
	}
}
