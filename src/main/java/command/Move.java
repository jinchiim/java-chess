package command;

import domain.chessGame.base.ChessGame;
import domain.coordinate.Coordinate;
import java.util.List;

public class Move implements Command {

    public Move() {
    }

    @Override
    public ChessGame execute(ChessGame chessGame, List<String> inputCommand) {
        Coordinate start = Coordinate.from(inputCommand.get(1));
        Coordinate destination = Coordinate.from(inputCommand.get(2));

        return chessGame.move(start, destination);
    }
}
