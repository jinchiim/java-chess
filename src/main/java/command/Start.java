package command;

import command.base.Command;
import java.sql.SQLException;
import java.util.List;
import service.ChessGameService;
import service.PieceService;
import state.chessGame.base.ChessGameState;

public class Start implements Command {

    public Start() {
    }

    @Override
    public ChessGameState execute(ChessGameService chessGameService, List<String> inputCommand,
                                  PieceService pieceService, ChessGameState chessGameState)
            throws SQLException {
        chessGameState = chessGameService.addChessGame();
        pieceService.addPieces(chessGameState.getGameId(), chessGameState.getBoard());
        return chessGameState;
    }
}
