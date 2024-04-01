package command;

import command.base.Command;
import domain.chessGame.base.ChessGame;
import domain.coordinate.Coordinate;
import java.sql.SQLException;
import java.util.List;
import service.PieceService;

public class Move implements Command {

    public Move() {
    }

    @Override
    public ChessGame execute(ChessGame chessGame, List<String> inputCommand, PieceService pieceService)
            throws SQLException {
        Coordinate start = Coordinate.from(inputCommand.get(1));
        Coordinate destination = Coordinate.from(inputCommand.get(2));
        ChessGame nextChessGame = chessGame.move(start, destination);

        pieceService.updatePiece(nextChessGame.getGameId(), start, destination);
        return nextChessGame;
    }
}
