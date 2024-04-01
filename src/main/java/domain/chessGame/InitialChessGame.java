package domain.chessGame;

import domain.chessGame.base.ChessGame;
import domain.chessGame.base.NotRunningGame;
import domain.chessGame.statusfactory.ChessStatusFactory;
import domain.coordinate.Coordinate;
import domain.piece.Color;
import domain.piece.base.ChessPiece;
import java.sql.SQLException;
import java.util.Map;
import service.ChessGameService;
import service.PieceService;

public class InitialChessGame extends NotRunningGame {

    public InitialChessGame() {
    }

    @Override
    public ChessGame start(PieceService pieceService) throws SQLException {
        Long id = new ChessGameService().addChessGame();

        ChessGame chessGame = ChessStatusFactory.makeRunningChessGame(id);
        pieceService.addPieces(id, chessGame.getBoard());

        return chessGame;
    }

    @Override
    public Map<Coordinate, ChessPiece> getBoard() {
        throw new IllegalArgumentException("아직 시작하지 않아 보드판을 가져올 수 없습니다.");
    }

    @Override
    public void show() {
        throw new IllegalArgumentException("아직 시작하지 않아 보여줄 상태가 없습니다.");
    }

    @Override
    public Long getGameId() {
        throw new UnsupportedOperationException("초기의 상태에서는 게임의 id를 불러올 수 없습니다.");
    }

    @Override
    public Color getTurn() {
        throw new UnsupportedOperationException("초기의 상태에서는 게임의 턴을 불러올 수 없습니다.");
    }
}
