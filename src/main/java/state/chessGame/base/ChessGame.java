package state.chessGame.base;

import domain.coordinate.Coordinate;
import domain.piece.Color;
import domain.piece.base.ChessPiece;
import java.sql.SQLException;
import java.util.Map;
import service.PieceService;

public interface ChessGame {

    ChessGame start(PieceService pieceService) throws SQLException;

    ChessGame move(Coordinate start, Coordinate destination);

    ChessGame end();

    boolean isPlaying();

    Map<Coordinate, ChessPiece> getBoard();

    Long getGameId();

    void show();

    Color getTurn();
}
