package app.service.alphabet;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class AlphabetServiceImpl implements AlphabetService {//AlpabetServiceImpl
  
  Map<Character, Boolean> entryAlphabet = Map.ofEntries(Map.entry('A', false),
      Map.entry('B', false), Map.entry('C', false), Map.entry('D', false), Map.entry('E', false),
      Map.entry('F', false), Map.entry('G', false), Map.entry('H', false), Map.entry('I', false),
      Map.entry('J', false), Map.entry('K', false), Map.entry('L', false), Map.entry('M', false),
      Map.entry('N', false), Map.entry('O', false), Map.entry('P', false), Map.entry('Q', false),
      Map.entry('R', false), Map.entry('S', false), Map.entry('T', false), Map.entry('U', false),
      Map.entry('V', false), Map.entry('W', false), Map.entry('X', false), Map.entry('Y', false),
      Map.entry('Z', false));

  Map<Character, Boolean> alphabet;
  Map<String, Map<Character, Boolean>> gameAlphabet;

  public AlphabetServiceImpl() {
    gameAlphabet = new HashMap<String, Map<Character,Boolean>>();
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
  public void setUsedCharacter(String gameId, char character) {
    gameAlphabet.get(gameId).replace(character, true);
  }

}
