package app.api;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import app.service.alphabet.AlphabetService;


@RestController
@RequestMapping("/api/v1/alphabet")
@CrossOrigin("http://localhost:3000")
public class AlphabetApi {

	@Autowired
	private AlphabetService alphabetService;	
	
	@GetMapping(value = "/{gameId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Character>> getAlphabet(@PathVariable String gameId) {
		return ResponseEntity.ok(alphabetService.getUnusedCharacters(gameId));
	}

}