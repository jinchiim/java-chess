package state.chessGame.base;

import domain.coordinate.Coordinate;
import domain.piece.Color;
import domain.piece.base.ChessPiece;
import java.sql.SQLException;
import java.util.Map;
import service.ChessGameService;
import service.PieceService;

public interface ChessGameState {

    ChessGameState start(ChessGameService chessGameService, PieceService pieceService) throws SQLException;

    ChessGameState move(Coordinate start, Coordinate destination);

    ChessGameState end();

    boolean isPlaying();

    Map<Coordinate, ChessPiece> getBoard();

    Long getGameId();

    void show();

    Color getTurn();
}
