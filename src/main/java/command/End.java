package command;

import command.base.Command;
import java.sql.SQLException;
import java.util.List;
import service.ChessGameService;
import state.chessGame.base.ChessGameState;

public class End implements Command {

    private final ChessGameService chessGameService;

    public End(ChessGameService chessGameService) {
        this.chessGameService = chessGameService;
    }

    @Override
    public ChessGameState execute(ChessGameState chessGameState) throws SQLException {
        return chessGameService.stopChessGame(chessGameState);
    }

    @Override
    public ChessGameState execute(ChessGameState chessGameState, List<String> inputCommand) {
        throw new IllegalArgumentException("잘못된 입력 값을 받았습니다.");
    }
}
