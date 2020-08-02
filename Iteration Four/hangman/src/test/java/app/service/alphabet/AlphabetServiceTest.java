package app.service.alphabet;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import app.dao.character.CharacterDao;
import app.model.User;
import app.service.alphabet.AlphabetService;
import app.service.alphabet.AlphabetServiceImpl;

public class AlphabetServiceTest {

	@Mock
	private CharacterDao characterDao;

	@InjectMocks
	private AlphabetService alphabetService;

	@Test
	public void Should_ReturnNotNull_When_SetGameWithId() {
		alphabetService.setGameAlphabet("1");
		assertThat(alphabetService.getCurrentGameAlphabet("1")).isNotNull();
	}

	@Test
	public void Should_ReturnTrue_When_MakeTry() {
		Mockito.when(characterDao.save(entity))
		alphabetService.setGameAlphabet("1");
		app.model.Character c = new app.model.Character();
		c.setCharacterId("2");
		c.setLetter('A');
		alphabetService.saveCharacter("1", c);
		Map<Character, Boolean> alphabet = alphabetService.getCurrentGameAlphabet("1");
		assertThat(alphabet.get('A')).isTrue();
	}

}
