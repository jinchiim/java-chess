package command.base;

import java.sql.SQLException;
import java.util.List;
import service.PieceService;
import state.chessGame.base.ChessGameState;

public interface Command {

    ChessGameState execute(ChessGameState chessGameState, List<String> inputCommand, PieceService pieceService)
            throws SQLException;
}
