package domain.chessGame;

import domain.chessGame.base.ChessGame;
import domain.chessGame.statusfactory.ChessStatusFactory;
import domain.chessboard.ChessBoard;
import domain.coordinate.Coordinate;
import domain.piece.Color;
import domain.piece.base.ChessPiece;
import java.util.Map;
import view.OutputView;

public class ChessGameRunning implements ChessGame {

    private final ChessBoard chessBoard;

    private Color currentTurn;

    public ChessGameRunning(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        this.currentTurn = Color.WHITE;
    }

    @Override
    public ChessGame start() {
        throw new UnsupportedOperationException("이미 시작된 상태입니다.");
    }

    @Override
    public ChessGame move(Coordinate start, Coordinate destination) {
        validateCanMove(start, destination);
        if (chessBoard.isOpponentColorKing(destination, currentTurn)) {
            chessBoard.playTurn(start, destination);
            return ChessStatusFactory.makeKingCaughtChessGame(chessBoard, currentTurn);
        }
        chessBoard.playTurn(start, destination);

        currentTurn = currentTurn.changeTurn();
        return this;
    }

    private void validateCanMove(Coordinate start, Coordinate destination) {
        if (chessBoard.isCanNotMovePiece(start, currentTurn) || chessBoard.isCanNotMoveDestination(destination,
                currentTurn)) {
            throw new IllegalArgumentException("움직일 수 없는 말을 선택 했습니다.");
        }
    }

    @Override
    public ChessGame end() {
        return ChessStatusFactory.makeEndChessGame();
    }

    @Override
    public boolean isPlaying() {
        return true;
    }

    @Override
    public Map<Coordinate, ChessPiece> getBoard() {
        return chessBoard.getBoard();
    }

    @Override
    public void show() {
        OutputView.printBoard(chessBoard.getBoard());
    }
}
