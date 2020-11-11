package app.service.alphabet;

import java.util.List;
import java.util.Map;

public interface AlphabetService {
  
  public void setGameAlphabet(String gameId);
  
  public Map<Character, Boolean> getCurrentGameAlphabet(String gameId);
  
  public void saveCharacter(String gameId, app.model.Symbol character);
  
  public List<Character> getUnusedCharacters(String gameId);
}
