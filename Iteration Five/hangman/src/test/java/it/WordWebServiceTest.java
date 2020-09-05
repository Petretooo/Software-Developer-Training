package it;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import app.HangmanApp;
import app.api.WordApi;
import app.dao.word.WordDao;
import app.model.Word;
import app.service.word.WordService;
import app.service.word.WordServiceImpl;

@SpringBootTest(classes = {WordDao.class, WordService.class})
public class WordWebServiceTest {
	
	private static WordService wordService;
	
	@Autowired
	private static WordDao wordDao;
	
	static private RestTemplate tamplete;

	private final static String URI_GET_WORDS_BY_PAGE = "http://localhost:8080/hangman/api/v1/words?page=%d";
	private final static String URI_DELETE_WORD = "http://localhost:8080/hangman/api/v1/words/%s";
	private final static String URI_CREATE_WORD = "http://localhost:8080/hangman/api/v1/words?wordName=%s&level=%d";

	private final static String ANDROID_WORD = "ANDROID";
	
	private final static String STATUS_CODE_200_OK = "200 OK";
	
	@BeforeAll
	private static void init() {
		wordService = new WordServiceImpl(wordDao);
		tamplete = new RestTemplate();
	}

	@Test
	public void Should_ReturnTenOrLessWords_When_GetWordsByPage() {
		ResponseEntity<Word[]> words = tamplete.getForEntity(String.format(URI_GET_WORDS_BY_PAGE, 1),
				Word[].class);
		List<Word> listWords = Arrays.stream(words.getBody()).collect(Collectors.toList());
		assertThat(listWords.size()).isLessThanOrEqualTo(10);
	}
	
	@Test
	public void Should_Return200_When_GetWordsByPage() {
		ResponseEntity<Word[]> words = tamplete.getForEntity(String.format(URI_GET_WORDS_BY_PAGE, 1),
				Word[].class);
		String statusCode = words.getStatusCode().toString();
		assertThat(statusCode).isEqualTo(STATUS_CODE_200_OK);
	}
	
	@Test
	public void Should_ReturnAndroid_When_GetWordsByPage() {
		ResponseEntity<Word[]> words = tamplete.getForEntity(String.format(URI_GET_WORDS_BY_PAGE, 1),
				Word[].class);
		List<String> wordsFromApi = Arrays.stream(words.getBody()).map(e -> e.getWordName()).collect(Collectors.toList());
		boolean isTrue = wordsFromApi.contains(ANDROID_WORD);
		assertThat(isTrue).isTrue();
	}
}
