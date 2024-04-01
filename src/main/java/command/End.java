package command;

import command.base.Command;
import domain.chessGame.base.ChessGame;
import java.util.List;
import service.PieceService;

public class End implements Command {

    @Override
    public ChessGame execute(ChessGame chessGame, List<String> inputCommand, PieceService pieceService) {
        return chessGame.end();
    }
}
