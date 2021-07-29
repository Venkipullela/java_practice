package Chess.models;

import Chess.models.pieces.Piece;
import Chess.models.pieces.Soldier;

import java.util.HashSet;
import java.util.Set;

public class Board {
    Position[][] positionsArray = new Position[8][8];
    Set<Piece> piecesAlive = new HashSet<>();
    Set<Piece> piecesDead = new HashSet<>();

    public Piece getPieceByPosition(Position position) {
        return null;
    }

    public void initialise(){

        initialiseSoldiersInTheRow(1, Color.WHITE);
        initialiseSoldiersInTheRow(6, Color.BLACK);


    }



    public void initialiseSoldiersInTheRow(int row, Color color) {
        for (int i = 0; i < 8; i++) {
            Position position = new Position();
            position.row = row;
            position.column = i;

            Piece piece = new Soldier();
            piece.color = color;
            piece.currentPosition = position;
            piece.isDead = false;

            this.positionsArray[row][i] = position;
            piecesAlive.add(piece);
        }
    }
}
