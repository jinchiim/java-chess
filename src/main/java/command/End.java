package command;

import command.base.Command;
import java.util.List;
import service.PieceService;
import state.chessGame.base.ChessGame;

public class End implements Command {

    @Override
    public ChessGame execute(ChessGame chessGame, List<String> inputCommand, PieceService pieceService) {
        return chessGame.end();
    }
}
