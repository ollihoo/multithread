package de.hoogvliet;

import de.hoogvliet.jokes.JokeException;
import de.hoogvliet.task.TaskService;
import de.hoogvliet.task.TaskServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TaskController {

  @Autowired
  private TaskService taskService;

  @RequestMapping(name = "/task", method = RequestMethod.GET)
  public Map<String, Object> executeTask() throws JokeException, TaskServiceException {
    return taskService.doTask();
  }
}
