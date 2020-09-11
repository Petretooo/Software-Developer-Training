package it;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import app.HangmanApp;
import app.dao.word.WordDao;
import app.model.Word;

@SpringBootTest(classes = HangmanApp.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class WordApiTest {

	@Autowired
	private WordDao wordDao;

	@LocalServerPort
	private int port;

	static private RestTemplate tamplete;

	private final static String URI_GET_WORDS_BY_PAGE = "http://localhost:%d/api/v1/words?page=%d";

	private final static String STATUS_CODE_200_OK = "200 OK";

	@BeforeAll
	private static void init() {
		tamplete = new RestTemplate();
	}

	@Test
	public void Should_ReturnTenOrLessWords_When_GetWordsByPage() {
		ResponseEntity<Word[]> words = tamplete.getForEntity(String.format(URI_GET_WORDS_BY_PAGE, port, 1),
				Word[].class);
		List<Word> listWords = Arrays.stream(words.getBody()).collect(Collectors.toList());
		assertThat(listWords.size()).isLessThanOrEqualTo(10);
	}

	@Test
	public void Should_Return200_When_GetWordsByPage() {
		ResponseEntity<Word[]> words = tamplete.getForEntity(String.format(URI_GET_WORDS_BY_PAGE, port, 1),
				Word[].class);
		String statusCode = words.getStatusCode().toString();
		assertThat(statusCode).isEqualTo(STATUS_CODE_200_OK);
	}

	@Test
	public void Should_ReturnCorrectWords_When_GetWordsByPage() {
		ResponseEntity<Word[]> words = tamplete.getForEntity(String.format(URI_GET_WORDS_BY_PAGE,port, 1), Word[].class);
		List<String> wordsFromApi = Arrays.stream(words.getBody()).map(e -> e.getWordName()).collect(Collectors.toList());
		List<String> wordsFromDao = wordDao.findAll().stream().map(e -> e.getWordName()).collect(Collectors.toList());
		boolean contains = wordsFromDao.containsAll(wordsFromApi);
		assertThat(contains).isTrue();
	}
}