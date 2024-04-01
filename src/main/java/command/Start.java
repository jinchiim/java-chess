package command;

import command.base.Command;
import java.sql.SQLException;
import java.util.List;
import service.PieceService;
import state.chessGame.base.ChessGameState;

public class Start implements Command {

    public Start() {
    }

    @Override
    public ChessGameState execute(ChessGameState chessGameState, List<String> inputCommand,
                                  PieceService pieceService)
            throws SQLException {
        chessGameState = chessGameState.start(pieceService);
        return chessGameState;
    }
}
