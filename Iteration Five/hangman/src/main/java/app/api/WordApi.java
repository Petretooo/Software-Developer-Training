package app.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.model.Word;
import app.service.word.WordService;

@RestController
@RequestMapping("/api/v1/words")
public class WordApi {
	
	@Autowired
	private WordService wordService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Word>> getPage(@RequestParam("page") int page, Model model) {
		return ResponseEntity.ok(wordService.findByPage(page));
	}

	@DeleteMapping(value = "/{word}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Word> deleteWord(@PathVariable("word") String word) {
		wordService.deleteWord(word);
	    return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Word> createWord(@RequestParam String wordName, @RequestParam int level) {
		Word word = wordService.saveWord(wordName, level);
		return new ResponseEntity<>(word, HttpStatus.CREATED);
	}

}
