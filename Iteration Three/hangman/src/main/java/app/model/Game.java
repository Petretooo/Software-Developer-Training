package app.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class Game {
  
  private int numberTries;
  private String currentWord;
  private char[] hiddenWord;
  private String id;
  private List<String> usedCharacters;
}
