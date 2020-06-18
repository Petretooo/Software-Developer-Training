package hangman;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GameContext {
  public ApplicationContext context;

  public GameContext() {
    context = new ClassPathXmlApplicationContext("application.xml");
  }

  public GameService getGame() {
    return context.getBean("hangmanGame", GameService.class);
  }



}
