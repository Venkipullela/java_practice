package Chess.entities;

public class Move {
    Long id;
    Long gameId;
    Long movedByUserId;
    Integer startingRow;
    Integer startingColumn;
    Integer endingRow;
    Integer endingColumn;
    String colorOfUser;
    String pieceName;
    String deadPieceName;
}
