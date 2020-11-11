package app.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin("http://localhost:3000")
public class WordApi {
	
	@Autowired
	private WordService wordService;
	
	private final static String URL_WORD_SELF_REF = "http://localhost:8080/hangman/api/v1/words/%s";
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<WordApiBean> getPage(@RequestParam("page") int page, Model model) {
		WordApiBean bean = new WordApiBean();
		List<Word> words = wordService.findByPage(page);
		words.stream().forEach(e -> e.add(Link.of(String.format(URL_WORD_SELF_REF, e.getWordId())).withSelfRel()));
		bean.setPageCount(wordService.numberPages());
		bean.setWords(words);
		return ResponseEntity.ok(bean);
	}
	
//	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<Word>> getAll(){
//		List<Word> words = wordService.findAllWords();
//		words.stream().forEach(e -> e.add(Link.of(String.format(URL_WORD_SELF_REF, e.getWordId())).withSelfRel()));
//		return ResponseEntity.ok(words);
//	}

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
