package app.model;

import java.util.List;
public class Game {

  private int numberTries;
  private String currentWord;
  private char[] hiddenWord;
  private String id;
  private List<String> usedCharacters;

  public int getNumberTries() {
    return numberTries;
  }

  public void setNumberTries(int numberFails) {
    this.numberTries = numberFails;
  }

  public String getCurrentWord() {
    return currentWord;
  }

  public void setCurrentWord(String currentWord) {
    this.currentWord = currentWord;
  }

  public char[] getHiddenWord() {
    return hiddenWord;
  }

  public void setHiddenWord(char[] hiddenWord) {
    this.hiddenWord = hiddenWord;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public List<String> getUsedCharacters() {
    return usedCharacters;
  }

  public void setUsedCharacters(List<String> usedCharacters) {
    this.usedCharacters = usedCharacters;
  }
}
