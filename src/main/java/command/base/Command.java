package command.base;

import java.sql.SQLException;
import java.util.List;
import service.ChessGameService;
import service.PieceService;
import state.chessGame.base.ChessGameState;

public interface Command {

    ChessGameState execute(ChessGameService chessGameService, List<String> inputCommand,
                           PieceService pieceService, ChessGameState chessGameState)
            throws SQLException;
}
