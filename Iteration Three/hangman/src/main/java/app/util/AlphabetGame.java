package app.util;

import java.util.HashMap;
import java.util.Map;

public class AlphabetGame {

  Map<Character, Boolean> entryAlphabet = Map.ofEntries(Map.entry('A', false),
      Map.entry('B', false), Map.entry('C', false), Map.entry('D', false), Map.entry('E', false),
      Map.entry('F', false), Map.entry('G', false), Map.entry('H', false), Map.entry('I', false),
      Map.entry('J', false), Map.entry('K', false), Map.entry('L', false), Map.entry('M', false),
      Map.entry('N', false), Map.entry('O', false), Map.entry('P', false), Map.entry('Q', false),
      Map.entry('R', false), Map.entry('S', false), Map.entry('T', false), Map.entry('U', false),
      Map.entry('V', false), Map.entry('W', false), Map.entry('X', false), Map.entry('Y', false),
      Map.entry('Z', false));

  Map<Character, Boolean> alphabet;

  public AlphabetGame() {
    alphabet = new HashMap<Character, Boolean>(entryAlphabet);
  }

  public Map<Character, Boolean> getAlphabet(String gameId) {
    return alphabet;
  }

  public void setUsedCharacter(String gameId, char character) {
    alphabet.replace(character, true);
  }
}
