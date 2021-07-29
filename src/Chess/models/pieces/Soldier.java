package Chess.models.pieces;

import Chess.models.Game;
import Chess.models.Move;
import Chess.models.Position;

public class Soldier extends Piece {
    @Override
    public boolean isMovable(Game game, Position endPosition) {
        return false;
    }

    @Override
    public Move move(Game game, Position endPosition) {
        return null;
    }
}
