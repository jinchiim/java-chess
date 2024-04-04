package service;

import db.dao.ChessGameDao;
import db.entity.ChessGame;
import domain.chessboard.ChessBoardScoreCalculator;
import domain.coordinate.Coordinate;
import domain.piece.Color;
import domain.piece.base.ChessPiece;
import java.sql.SQLException;
import java.util.Map;
import service.dto.GameScoreDto;
import state.chessGame.base.ChessGameState;
import state.chessGame.statusfactory.ChessStatusFactory;

public class ChessGameService {

    private final ChessGameDao chessGameDao;

    public ChessGameService() {
        this.chessGameDao = new ChessGameDao();
    }

    public ChessGameState addChessGame() throws SQLException {
        ChessGame chessGame = ChessGame.create();
        Long id = chessGameDao.save(chessGame);

        return ChessStatusFactory.makeRunningChessGame(id);
    }

    public void deleteChessGame(ChessGameState chessGameState) throws SQLException {
        chessGameDao.delete(chessGameState.getGameId());
    }

    public GameScoreDto calculateScore(ChessGameState chessGameState) {
        Map<Coordinate, ChessPiece> board = chessGameState.getBoard();

        double blackScore = ChessBoardScoreCalculator.calculate(Color.BLACK, board);
        double whiteScore = ChessBoardScoreCalculator.calculate(Color.WHITE, board);

        return new GameScoreDto(blackScore, whiteScore);
    }

    public ChessGameState stopChessGame(ChessGameState chessGameState) throws SQLException {
        chessGameDao.updateChessGameById(chessGameState.getGameId());
        return chessGameState.end();
    }
}
