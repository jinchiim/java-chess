package domain.chessGame;

import domain.chessGame.base.ChessGame;
import domain.chessGame.base.NotRunningGame;
import domain.coordinate.Coordinate;
import domain.piece.base.ChessPiece;
import java.util.Map;
import view.OutputView;

public class ChessGameEnd extends NotRunningGame {

    public ChessGameEnd() {
    }

    @Override
    public ChessGame start() {
        throw new UnsupportedOperationException("게임이 이미 종료되었습니다.");
    }

    @Override
    public Map<Coordinate, ChessPiece> getBoard() {
        throw new UnsupportedOperationException("이미 종료한 상태의 게임으로 보드판을 불러올 수 없습니다.");
    }

    @Override
    public void show() {
        OutputView.printEndGuide();
    }
}
