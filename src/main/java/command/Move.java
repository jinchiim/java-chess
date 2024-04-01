package command;

import command.base.Command;
import java.sql.SQLException;
import java.util.List;
import service.ChessGameService;
import service.PieceService;
import state.chessGame.base.ChessGameState;

public class Move implements Command {

    public Move() {
    }

    @Override
    public ChessGameState execute(ChessGameService chessGameService, List<String> inputCommand,
                                  PieceService pieceService, ChessGameState chessGameState)
            throws SQLException {
        return pieceService.updatePiece(inputCommand, chessGameState);
    }
}
