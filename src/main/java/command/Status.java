package command;

import command.base.Command;
import java.util.List;
import service.ChessGameService;
import service.PieceService;
import service.dto.GameScoreDto;
import state.chessGame.base.ChessGameState;
import view.OutputView;

public class Status implements Command {

    public Status() {
    }

    @Override
    public ChessGameState execute(ChessGameService chessGameService, List<String> inputCommand,
                                  PieceService pieceService, ChessGameState chessGameState) {
        GameScoreDto gameScoreDto = chessGameService.calculateScore(chessGameState);
        OutputView.printStatus(gameScoreDto);
        return chessGameState;
    }
}
