package command.base;

import java.sql.SQLException;
import java.util.List;
import service.PieceService;
import state.chessGame.base.ChessGame;

public interface Command {

    ChessGame execute(ChessGame chessGame, List<String> inputCommand, PieceService pieceService) throws SQLException;
}
