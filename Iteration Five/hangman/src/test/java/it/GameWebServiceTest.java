package it;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.meta.When;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import app.dao.game.GameDao;
import app.model.Game;
import app.model.Word;
import app.service.alphabet.AlphabetService;
import app.service.game.GameService;
import app.service.game.HangmanGameServiceImpl;
import app.service.word.WordService;
import app.service.word.WordServiceImpl;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.get;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import org.hamcrest.Matchers.*;
import org.mockito.*;
import static org.hamcrest.Matchers.equalTo;


@SpringBootTest(classes = { GameDao.class, GameService.class })
public class GameWebServiceTest {

	private static GameService gameService;

	@Autowired
	private static GameDao gameDao;
	@Autowired
	private static WordService wordService;
	@Autowired
	private static AlphabetService alphabetService;

	
	

	private final static String URI_GET_GAMES = "http://localhost:8080/hangman/api/v1/games/%s";
	private final static String URI_GET_RUNNING_GAMES = "http://localhost:8080/hangman/api/v1/games";
	private final static String URI_CREATE_GAME = "http://localhost:8080/hangman/api/v1/games?username=POP";

	private final static String ID_GAME_FROM_DB = "a7591b79-af77-42ca-8cf1-e418b5f2b3f5";
	private final static int STATUS_CODE_200_OK = 200;
	private final static String JSON_ID = "Id";

	@BeforeAll
	private static void init() {
		gameService = new HangmanGameServiceImpl(wordService, alphabetService, gameDao);
	}

	@Test
	public void Should_ReturnGameFromId_When_GetGame() {
		get(String.format(URI_GET_GAMES, ID_GAME_FROM_DB))
		.then()
		.assertThat()
		.body(JSON_ID, equalTo(ID_GAME_FROM_DB));
	}

	@Test
	public void Should_ReturnStatusCode200_When_GetGame() {
		get(String.format(URI_GET_GAMES, ID_GAME_FROM_DB))
		.then()
		.statusCode(STATUS_CODE_200_OK)
		.assertThat();
	}

	@Test
	public void Should_ReturnRunningGames_When_GetRunningGames() {		
		Game[] games= given().when().get(URI_GET_RUNNING_GAMES).as(Game[].class);
		assertThat(games).isNotNull();
	}
	
}
