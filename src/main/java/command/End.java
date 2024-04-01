package command;

import command.base.Command;
import java.util.List;
import service.PieceService;
import state.chessGame.base.ChessGameState;

public class End implements Command {

    @Override
    public ChessGameState execute(ChessGameState chessGameState, List<String> inputCommand, PieceService pieceService) {
        return chessGameState.end();
    }
}
