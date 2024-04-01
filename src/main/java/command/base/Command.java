package command.base;

import domain.chessGame.base.ChessGame;
import java.sql.SQLException;
import java.util.List;
import service.PieceService;

public interface Command {

    ChessGame execute(ChessGame chessGame, List<String> inputCommand, PieceService pieceService) throws SQLException;
}
