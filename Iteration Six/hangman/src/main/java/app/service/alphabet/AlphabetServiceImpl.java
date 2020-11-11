package app.service.alphabet;

import static java.util.Map.entry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dao.symbol.SymbolDao;

@Service
@Transactional
public class AlphabetServiceImpl implements AlphabetService {

	private Map<Character, Boolean> entryAlphabet = Map.ofEntries(entry('A', false), entry('B', false),
			entry('C', false), entry('D', false), entry('E', false), entry('F', false), entry('G', false),
			entry('H', false), entry('I', false), entry('J', false), entry('K', false), entry('L', false),
			entry('M', false), entry('N', false), entry('O', false), entry('P', false), entry('Q', false),
			entry('R', false), entry('S', false), entry('T', false), entry('U', false), entry('V', false),
			entry('W', false), entry('X', false), entry('Y', false), entry('Z', false));

	private Map<String, Map<Character, Boolean>> gameAlphabet;

	@Autowired
	private SymbolDao characterDao;

	public AlphabetServiceImpl() {
		gameAlphabet = new HashMap<>();
	}

	@Override
	public void setGameAlphabet(String gameId) {
		Map<Character, Boolean> alphabet = new HashMap<>(entryAlphabet);
		gameAlphabet.put(gameId, alphabet);
	}

	@Override
	public Map<Character, Boolean> getCurrentGameAlphabet(String gameId) {
		return gameAlphabet.get(gameId);
	}
	
	public List<Character> getUnusedCharacters(String gameId){
		return getCurrentGameAlphabet(gameId).entrySet().stream().filter(e -> !e.getValue()).map(e -> e.getKey()).collect(Collectors.toList());
	}

	@Override
	public void saveCharacter(String gameId, app.model.Symbol character) {
		characterDao.save(character);
		gameAlphabet.get(gameId).replace(character.getLetter(), true);
	}

}
