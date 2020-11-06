package it;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

import app.HangmanApp;
import app.dao.game.GameDao;
import app.model.Game;

@SpringBootTest(classes = HangmanApp.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class GameApiTest {

	@Autowired
	private GameDao gameDao;
	
	@LocalServerPort
	private int port;

	private final static String URI_GET_GAMES = "http://localhost:%d/api/v1/games/%s";
	private final static String URI_GET_RUNNING_GAMES = "http://localhost:%d/api/v1/games";

	private final static int STATUS_CODE_200_OK = 200;
	private final static String JSON_ID = "Id";

	@Test
	public void Should_ReturnGameFromId_When_GetGame() {
		Game game = gameDao.getAll().get(1);
		get(String.format(URI_GET_GAMES, port, game.getId()))
		.then()
		.assertThat()
		.body(JSON_ID, equalTo(game.getId()));
	}

	@Test
	public void Should_ReturnStatusCode200_When_GetGame() {
		Game game = gameDao.getAll().get(1);
		get(String.format(URI_GET_GAMES,port, game.getId()))
		.then()
		.statusCode(STATUS_CODE_200_OK)
		.assertThat();
	}

	@Test
	public void Should_ReturnRunningGames_When_GetRunningGames() {		
		Game[] games= given().when().get(String.format(URI_GET_RUNNING_GAMES, port)).as(Game[].class);
		assertThat(games).isNotNull();
	}
	
}
