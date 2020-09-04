package app.dto;

import java.util.Set;

import javax.json.bind.annotation.JsonbProperty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import app.model.Game;
import app.model.Ranking;
import app.model.Symbol;
import app.model.User;
import lombok.Data;

@Data
public class GameDto {
	
	@JsonbProperty("Id")
	private String id;
	@JsonbProperty("Tries")
	private int numberTries;
	@JsonbProperty("Word")
	private String currentWord;
	@JsonIgnore
	private char[] hiddenWord;
	@JsonbProperty("Characters")
	private Set<Symbol> characters;
	@JsonIgnore
	private User user;
	@JsonbProperty("Username")
	private String username;
	
	
	public static GameDto fromGame(Game game) {
		GameDto dto = new GameDto();
		dto.setId(game.getId());
		dto.setNumberTries(game.getNumberTries());
		dto.setCurrentWord(game.getCurrentWord());
		dto.setHiddenWord(game.getHiddenWord());
		dto.setCharacters(game.getCharacters());
		dto.setUser(game.getUser());
		dto.setUsername(game.getUser().getUsername());
		return dto;
	}

}
