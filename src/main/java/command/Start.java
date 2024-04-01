package command;

import command.base.Command;
import domain.chessGame.base.ChessGame;
import java.sql.SQLException;
import java.util.List;
import service.PieceService;

public class Start implements Command {

    public Start() {
    }

    @Override
    public ChessGame execute(ChessGame chessGame, List<String> inputCommand, PieceService pieceService)
            throws SQLException {
        chessGame = chessGame.start(pieceService);
        return chessGame;
    }
}
