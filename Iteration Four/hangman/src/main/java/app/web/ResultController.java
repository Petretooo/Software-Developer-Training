package app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResultController {

  @GetMapping("/gameover")
  public String gameover() {
    return "gameover";
  }

  @GetMapping("/win")
  public String win() {
    return "win";
  }

}
