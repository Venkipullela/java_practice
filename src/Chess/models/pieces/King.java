package Chess.models.pieces;

import Chess.models.*;

public class King extends Piece {

    @Override
    public boolean isMovable(Game game, Position endPosition) {
        return false;
    }

    @Override
    public Move move(Game game, Position endPosition) {
        return null;
    }
}
