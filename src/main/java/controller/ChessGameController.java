package controller;

import command.base.Command;
import command.base.Commands;
import java.sql.SQLException;
import java.util.List;
import service.ChessGameService;
import service.PieceService;
import state.chessGame.base.ChessGame;
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
        ChessGame chessGame = ChessStatusFactory.initChessGame();
        OutputView.printGameGuide();
        do {
            List<String> inputCommand = InputView.receiveCommands();
            Command command = Commands.findCommand(inputCommand.get(0));

            chessGame = command.execute(chessGame, inputCommand, pieceService);
            chessGame.show();
        } while (chessGame.isPlaying());

        pieceService.deletePieces(chessGame.getGameId());
        chessGameService.deleteChessGame(chessGame.getGameId());
    }
}
