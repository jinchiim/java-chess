package service;

import db.dao.ChessGameDao;
import db.dao.ChessGameRepository;
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

    private final ChessGameRepository chessGameRepository;

    public ChessGameService() {
        this.chessGameRepository = new ChessGameDao();
    }

    public ChessGameState addChessGame() throws SQLException {
        ChessGame chessGame = ChessGame.create();
        Long id = chessGameRepository.save(chessGame);

        return ChessStatusFactory.makeRunningChessGame(id);
    }

    public ChessGameState deleteChessGame(Long gameId, ChessGameState chessGameState) throws SQLException {
        ChessGameState endState = chessGameState.end();
        chessGameRepository.delete(gameId);
        return endState;
    }

    public GameScoreDto calculateScore(ChessGameState chessGameState) {
        Map<Coordinate, ChessPiece> board = chessGameState.getBoard();

        double blackScore = ChessBoardScoreCalculator.calculate(Color.BLACK, board);
        double whiteScore = ChessBoardScoreCalculator.calculate(Color.WHITE, board);

        return new GameScoreDto(blackScore, whiteScore);
    }
}
