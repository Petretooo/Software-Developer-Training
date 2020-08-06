package app.service.alphabet;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import app.dao.character.CharacterDao;
import app.model.Game;

public class AlphabetServiceTest {

	@Mock
	private CharacterDao characterDao;

	@InjectMocks
	private AlphabetService alphabetService;
	
	@BeforeEach
	private void init() {
		alphabetService = new AlphabetServiceImpl();
	}

	@Test
	public void Should_ReturnNotNull_When_SetGameWithId() {
		alphabetService.setGameAlphabet("1");
		assertThat(alphabetService.getCurrentGameAlphabet("1")).isNotNull();
	}

//	@Test
//	public void Should_ReturnTrue_When_MakeTry() {
//		alphabetService.setGameAlphabet("1");
//		app.model.Character c = new app.model.Character();
//		c.setCharacterId("2");
//		c.setLetter('A');
//		c.setGame(new Game());
//		alphabetService.saveCharacter("1", c);
//		Map<Character, Boolean> alphabet = alphabetService.getCurrentGameAlphabet("1");
//		assertThat(alphabet.get('A')).isTrue();
//	}

}
