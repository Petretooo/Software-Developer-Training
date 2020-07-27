package app.service.alphabet;

import static java.util.Map.entry;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.character.CharacterDao;

@Service
public class AlphabetServiceImpl implements AlphabetService {

	private Map<Character, Boolean> entryAlphabet = Map.ofEntries(entry('A', false), entry('B', false),
			entry('C', false), entry('D', false), entry('E', false), entry('F', false), entry('G', false),
			entry('H', false), entry('I', false), entry('J', false), entry('K', false), entry('L', false),
			entry('M', false), entry('N', false), entry('O', false), entry('P', false), entry('Q', false),
			entry('R', false), entry('S', false), entry('T', false), entry('U', false), entry('V', false),
			entry('W', false), entry('X', false), entry('Y', false), entry('Z', false));

	private Map<Character, Boolean> alphabet;
	private Map<String, Map<Character, Boolean>> gameAlphabet;

	@Autowired
	private CharacterDao characterDao;

	public AlphabetServiceImpl() {
		gameAlphabet = new HashMap<String, Map<Character, Boolean>>();
	}

	@Override
	public void setGameAlphabet(String gameId) {
		alphabet = new HashMap<Character, Boolean>(entryAlphabet);
		gameAlphabet.put(gameId, alphabet);
	}

	@Override
	public Map<Character, Boolean> getCurrentGameAlphabet(String gameId) {
		return gameAlphabet.get(gameId);
	}

	@Override
	public void saveCharacter(String gameId, app.model.Character character) {
		characterDao.save(character);
		gameAlphabet.get(gameId).replace(character.getLetter(), true);
	}

}
