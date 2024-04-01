package controller;

import command.base.Command;
import command.base.Commands;
import java.sql.SQLException;
import java.util.List;
import service.ChessGameService;
import service.PieceService;
import state.chessGame.base.ChessGameState;
import state.chessGame.statusfactory.ChessStatusFactory;
import view.InputView;
import view.OutputView;

public class ChessGameController {

    private final ChessGameService chessGameService;
    private final PieceService pieceService;

    public ChessGameController(ChessGameService chessGameService, PieceService pieceService) {
        this.chessGameService = chessGameService;
        this.pieceService = pieceService;
    }

    public void run() throws SQLException {
        ChessGameState chessGameState = ChessStatusFactory.initChessGame();
        OutputView.printGameGuide();
        do {
            List<String> inputCommand = InputView.receiveCommands();
            Command command = Commands.findCommand(inputCommand.get(0));

            chessGameState = command.execute(chessGameState, inputCommand, pieceService);
            chessGameState.show();
        } while (chessGameState.isPlaying());

        pieceService.deletePieces(chessGameState.getGameId());
        chessGameService.deleteChessGame(chessGameState.getGameId());
    }
}
