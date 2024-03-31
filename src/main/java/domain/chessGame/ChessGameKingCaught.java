package domain.chessGame;

import domain.chessGame.base.ChessGame;
import domain.chessGame.base.NotRunningGame;
import domain.chessboard.ChessBoard;
import domain.coordinate.Coordinate;
import domain.piece.Color;
import domain.piece.base.ChessPiece;
import java.util.Map;
import view.OutputView;

public class ChessGameKingCaught extends NotRunningGame {

    private final ChessBoard chessBoard;
    private final Color currentTurn;

    public ChessGameKingCaught(ChessBoard chessBoard, Color currentTurn) {
        this.chessBoard = chessBoard;
        this.currentTurn = currentTurn;
    }

    @Override
    public ChessGame start() {
        throw new UnsupportedOperationException("게임이 이미 종료되었습니다.");
    }

    @Override
    public Map<Coordinate, ChessPiece> getBoard() {
        return chessBoard.getBoard();
    }

    @Override
    public void show() {
        OutputView.printResult(currentTurn);
    }
}
