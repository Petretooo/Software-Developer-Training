package app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.model.Rank;
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
		List<Rank> rankList = rankService.getRankList();
		model.addAttribute("show", rankList);
		return "rankTopTen";
	}
	
	@GetMapping("/topMonth")
	public String getTopForMonth(Model model) {
		List<Rank> rankList = rankService.getRankByMonth();
		model.addAttribute("show", rankList);
		return "rankTopForMonth";
	}
}
