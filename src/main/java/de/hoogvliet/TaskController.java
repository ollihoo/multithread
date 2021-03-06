package de.hoogvliet;

import de.hoogvliet.task.TaskService;
import de.hoogvliet.task.TaskServiceException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TaskController {

  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @RequestMapping(value = "/task", method = RequestMethod.GET)
  public Map<String, Object> executeTask() throws TaskServiceException {
    return taskService.doTask();
  }
}
