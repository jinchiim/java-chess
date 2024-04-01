package command;

import command.base.Command;
import domain.chessboard.ChessBoardScoreCalculator;
import domain.coordinate.Coordinate;
import domain.piece.Color;
import domain.piece.base.ChessPiece;
import java.util.List;
import java.util.Map;
import service.PieceService;
import state.chessGame.base.ChessGame;
import view.OutputView;

public class Status implements Command {

    public Status() {
    }

    @Override
    public ChessGame execute(ChessGame chessGame, List<String> inputCommand, PieceService pieceService) {
        Map<Coordinate, ChessPiece> board = chessGame.getBoard();

        double blackScore = ChessBoardScoreCalculator.calculate(Color.BLACK, board);
        double whiteScore = ChessBoardScoreCalculator.calculate(Color.WHITE, board);

        OutputView.printStatus(blackScore, whiteScore);
        return chessGame;
    }
}
