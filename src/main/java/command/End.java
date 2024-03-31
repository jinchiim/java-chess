package command;

import domain.chessGame.base.ChessGame;
import java.util.List;

public class End implements Command {

    @Override
    public ChessGame execute(ChessGame chessGame, List<String> inputCommand) {
        return chessGame.end();
    }
}
