package domain.chessGame;

import domain.chessGame.base.ChessGame;
import domain.chessGame.base.NotRunningGame;
import domain.chessboard.ChessBoard;
import domain.coordinate.Coordinate;
import domain.piece.Color;
import domain.piece.base.ChessPiece;
import java.util.Map;
import service.PieceService;
import view.OutputView;

public class ChessGameKingCaught extends NotRunningGame {

    private final ChessBoard chessBoard;
    private final Color currentTurn;
    private final Long gameId;

    public ChessGameKingCaught(ChessBoard chessBoard, Color currentTurn, Long gameId) {
        this.chessBoard = chessBoard;
        this.currentTurn = currentTurn;
        this.gameId = gameId;
    }

    @Override
    public ChessGame start(PieceService pieceService) {
        throw new UnsupportedOperationException("게임이 이미 종료되었습니다.");
    }

    @Override
    public Map<Coordinate, ChessPiece> getBoard() {
        return chessBoard.getBoard();
    }

    @Override
    public Long getGameId() {
        return gameId;
    }

    @Override
    public void show() {
        OutputView.printResult(currentTurn);
    }

    @Override
    public Color getTurn() {
        return currentTurn;
    }
}
