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
	private final static String URI_DELETE_WORD = "http://localhost:%d/api/v1/words/%s";
	private final static String URI_CREATE_WORD = "http://localhost:%d/api/v1/words?wordName=%s&level=%d";

	private final static String STATUS_CODE_200_OK = "200 OK";
	private final static String WORD_ANDROID = "ANDROID";

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
	public void Should_ReturnAndroid_When_GetWordsByPage() {
		ResponseEntity<Word[]> words = tamplete.getForEntity(String.format(URI_GET_WORDS_BY_PAGE,port, 1), Word[].class);
		List<Word> wordsFromApi = Arrays.stream(words.getBody()).collect(Collectors.toList());
		List<Word> wordsFromDao = wordDao.findAll();
		Word wordApi = wordsFromApi.stream().filter(e -> e.getWordName().equals(WORD_ANDROID)).findFirst().orElse(null);
		Word wordDao = wordsFromDao.stream().filter(e -> e.getWordName().equals(WORD_ANDROID)).findFirst().orElse(null);
		assertThat(wordApi.getWordName()).isEqualTo(wordDao.getWordName());
	}
}