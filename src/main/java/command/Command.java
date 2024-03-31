package command;

import domain.chessGame.base.ChessGame;
import java.util.List;

public interface Command {

    ChessGame execute(ChessGame chessGame, List<String> inputCommand);
}
