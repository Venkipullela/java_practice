package Chess.entities;

import java.time.ZonedDateTime;

public class Game {
    Long id;
    Long startedByUserId;
    Long joinedUserId;
    ZonedDateTime createdOn;
    ZonedDateTime startedOn;
    ZonedDateTime updatedOn;
    String status;
    Long winningUserId;
}
