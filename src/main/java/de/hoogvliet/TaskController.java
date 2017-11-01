package de.hoogvliet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

  @Autowired
  private TaskService taskService;

  @RequestMapping(name="/task", method = RequestMethod.GET)
  public String executeTask() {
    return taskService.getJoke();
  }
}
