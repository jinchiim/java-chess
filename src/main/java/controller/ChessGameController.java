package controller;

import command.Command;
import command.Commands;
import domain.chessGame.base.ChessGame;
import domain.chessGame.statusfactory.ChessStatusFactory;
import java.util.List;
import view.InputView;
import view.OutputView;

public class ChessGameController {

    private final InputView inputView;

    public ChessGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        ChessGame chessGame = ChessStatusFactory.initChessGame();
        OutputView.printGameGuide();
        do {
            List<String> inputCommand = inputView.receiveCommands();
            Command command = Commands.findCommand(inputCommand.get(0));

            chessGame = command.execute(chessGame, inputCommand);
            chessGame.show();
        } while (chessGame.isPlaying());
    }
}
