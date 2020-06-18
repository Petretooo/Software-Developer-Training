package hangman;

public interface GameService {

  public void createGame();

  public void enterCharacter(String letter);


  public String updateWord();

  public String getWord();

  public boolean found();


  public int numberTries();

  public String getUsedWords();

}
