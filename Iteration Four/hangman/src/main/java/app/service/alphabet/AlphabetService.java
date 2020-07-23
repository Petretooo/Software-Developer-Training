package app.service.alphabet;

import java.util.Map;

public interface AlphabetService {
  
  public void setGameAlphabet(String gameId);
  
  public Map<Character, Boolean> getCurrentGameAlphabet(String gameId);
  
  public void setUsedCharacter(String gameId, char character);

}
