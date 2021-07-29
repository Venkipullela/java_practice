package Chess.models;

import java.util.List;

public class Game {
    Integer gameId;
    Player whitePlayer;
    Player blackPlayer;
    Board board;
    List<Move> moves;
    Player winner;
}
