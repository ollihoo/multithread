package de.hoogvliet;

import lombok.Data;

@Data
public class Jeopardy {
//  [{\"id\":146218,\"answer\":\"left-wing and right-wing\",\"question\":\"(Here's Kelly.) The seating arrangement used today in France's legislature is the same as in the 18th century, when these two directional 2-word terms for conservatives and liberals originated\",
// \"value\":400,\"airdate\":\"2014-07-08T12:00:00.000Z\",\"created_at\":\"2015-01-22T02:33:07.876Z\",\"updated_at\":\"2015-01-22T02:33:07.876Z\",\"category_id\":1,\"game_id\":4557,\"invalid_count\":null,\"category\":{\"id\":1,\"title\":\"politics\",\"created_at\":\"2014-02-11T22:47:18.687Z\",\"updated_at\":\"2014-02-11T22:47:18.687Z\",\"clues_count\":30}}]"
    private Integer id;
    private String answer;
    private String question;
    private Integer value;
}
