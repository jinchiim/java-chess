package domain.chessGame;

import domain.chessGame.base.ChessGame;
import domain.chessGame.base.NotRunningGame;
import domain.chessGame.statusfactory.ChessStatusFactory;
import domain.coordinate.Coordinate;
import domain.piece.base.ChessPiece;
import java.util.Map;

public class InitialChessGame extends NotRunningGame {

    public InitialChessGame() {
    }

    @Override
    public ChessGame start() {
        return ChessStatusFactory.makeRunningChessGame();
    }

    @Override
    public Map<Coordinate, ChessPiece> getBoard() {
        throw new IllegalArgumentException("아직 시작하지 않아 보드판을 가져올 수 없습니다.");
    }

    @Override
    public void show() {
        throw new IllegalArgumentException("아직 시작하지 않아 보여줄 상태가 없습니다.");
    }
}
