package app.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.service.word.WordService;

@Controller
@RequestMapping("/word")
public class WordController {
	
	@Autowired
	private WordService wordService;
	
	@GetMapping(value = "/page/{page}")
	public String getPage(@PathVariable("page") int page, Model model) {
		model.addAttribute("show", wordService.findByPage(page));
		model.addAttribute("pages", wordService.numberPages());
		model.addAttribute("currentPage", page);
		return "word";
	}
	
	@RequestMapping(value = "/delete/{word}", method = RequestMethod.GET)
	public String deleteWord(@PathVariable("word") String word) {
		wordService.deleteWord(word);
		
		return "redirect:/word//page/1";
	}
	
	@PostMapping
	public String createWord(HttpServletRequest request) {
		String wordN = request.getParameter("wordName");
		int levelDif = Integer.parseInt(request.getParameter("level"));
		wordService.saveWord(wordN, levelDif);
		return "redirect:/word/page/1";
	}

}
