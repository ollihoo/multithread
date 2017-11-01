package de.hoogvliet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

  @RequestMapping(name="/task", method = RequestMethod.GET)
  public String executeTask() {
    return "Hello";
  }
}
