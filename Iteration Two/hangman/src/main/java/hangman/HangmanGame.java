package hangman;

import java.util.ArrayList;
import java.util.Random;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HangmanGame implements GameService {

  private static final String[] WORDS =
      {"JAVA", "SPRING", "HIBERNATE", "SWING", "MAVEN", "GRADLE", "PLAY", "QUARKUS", "STRUTS",
          "SPARK", "SONAR", "JUNIT", "TOMCAT", "ECLIPSE", "ANDROID", "SERVLET", "JSP", "GRAILS",
          "JENKINS", "DOCKER", "GWT", "JSF", "VAADIN", "BLADE", "VERTX", "WICKET", "MICRONAUT"};

  private static final int MAX_TRIES = 5;
  private int numberFails;
  private String currentWord;
  private char[] hiddenWord = {};
  private ArrayList<String> usedCharacters = new ArrayList<>();

  private String randomWord() {
    Random RANDOM = new Random();
    return WORDS[RANDOM.nextInt(WORDS.length)];
  }

  @Override
  public void enterCharacter(String letter) {
    if (!usedCharacters.contains(letter)) {
      if (currentWord.contains(letter)) {
        int index = currentWord.indexOf(letter);
        while (index >= 0) {
          hiddenWord[index] = letter.charAt(0);
          index = currentWord.indexOf(letter, index + 1);
        }
      } else {
        numberFails++;
      }
      usedCharacters.add(letter);
    }
    updateWord();
  }

  @Override
  public String updateWord() {
    String updatedWord = "";
    for (int i = 0; i < hiddenWord.length; i++) {
      updatedWord += hiddenWord[i] + " ";
    }
    return updatedWord;
  }

  @Override
  public void createGame() {
    numberFails = 0;
    usedCharacters.clear();
    currentWord = randomWord();
    hiddenWord = new char[currentWord.length()];

    for (int i = 0; i < hiddenWord.length; i++) {
      hiddenWord[i] = '_';
    }

  }

  @Override
  public boolean found() {
    return currentWord.contentEquals(new String(hiddenWord));
  }

  @Override
  public String getWord() {
    return new String(currentWord);
  }

  @Override
  public int numberTries() {
    return (MAX_TRIES - numberFails);
  }

  @Override
  public String getUsedWords() {
    String words = "";
    for (String letter : usedCharacters) {
      words += letter + ", ";
    }
    return words;
  }


}
