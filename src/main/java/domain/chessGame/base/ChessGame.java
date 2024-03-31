package domain.chessGame.base;

import domain.coordinate.Coordinate;
import domain.piece.base.ChessPiece;
import java.util.Map;

public interface ChessGame {

    ChessGame start();

    ChessGame move(Coordinate start, Coordinate destination);

    ChessGame end();

    boolean isPlaying();

    Map<Coordinate, ChessPiece> getBoard();

    void show();
}
