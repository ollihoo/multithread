package de.hoogvliet.jokes;

import lombok.Data;

@Data
public class Joke {
  private Integer id;
  private String type;
  private String setup;
  private String punchline;
}
