package Chess.models.pieces;

import Chess.models.Color;
import Chess.models.Game;
import Chess.models.Move;
import Chess.models.Position;

public abstract class Piece {
    public Position currentPosition;
    public Boolean isDead;
    public Color color;
    
    public abstract boolean isMovable(Game game, Position endPosition);
    
    public abstract Move move(Game game, Position endPosition);
}
