package command;

import domain.chessGame.base.ChessGame;
import java.util.List;

public class Start implements Command {

    public Start() {
    }

    @Override
    public ChessGame execute(ChessGame chessGame, List<String> inputCommand) {
        chessGame = chessGame.start();
        return chessGame;
    }
}
