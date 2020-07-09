package app.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(value = RuntimeException.class)
  public ResponseEntity<Object> exception(RuntimeException exception){
    return new ResponseEntity<>("Character not found", HttpStatus.NOT_FOUND);
  }
}
