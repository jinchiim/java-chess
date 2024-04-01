package command;

import command.base.Command;
import domain.coordinate.Coordinate;
import java.sql.SQLException;
import java.util.List;
import service.PieceService;
import state.chessGame.base.ChessGameState;

public class Move implements Command {

    public Move() {
    }

    @Override
    public ChessGameState execute(ChessGameState chessGameState, List<String> inputCommand, PieceService pieceService)
            throws SQLException {
        Coordinate start = Coordinate.from(inputCommand.get(1));
        Coordinate destination = Coordinate.from(inputCommand.get(2));
        ChessGameState nextChessGameState = chessGameState.move(start, destination);

        pieceService.updatePiece(nextChessGameState.getGameId(), start, destination);
        return nextChessGameState;
    }
}
