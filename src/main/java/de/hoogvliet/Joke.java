package de.hoogvliet;

import lombok.Data;

@Data
public class Joke {
  private Integer id;
  private String type;
  private String setup;
  private String punchline;
}
