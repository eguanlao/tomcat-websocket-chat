package me.about.eguanlao.app;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  @RequestMapping(path = "/greeting", method = RequestMethod.GET)
  public String getGreeting() {
    return "Greetings from Spring Boot!";
  }

  @CrossOrigin(origins = "http://localhost:9000")
  @RequestMapping(path = "/foo", method = RequestMethod.GET)
  public String getFoo() {
    return "Foo!";
  }

}
