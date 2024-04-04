package service;

import db.dao.ChessGameDao;
import db.entity.ChessGame;
import domain.chessboard.ChessBoardInitializer;
import domain.chessboard.ChessBoardScoreCalculator;
import domain.coordinate.Coordinate;
import domain.piece.Color;
import domain.piece.base.ChessPiece;
import domain.room.GameRoom;
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

    public ChessGameState addChessGame(String roomName) throws SQLException {
        GameRoom gameRoom = new GameRoom(roomName);

        ChessGame chessGame = ChessGame.create(gameRoom);
        Long id = chessGameDao.save(chessGame);

        return ChessStatusFactory.makeRunningChessGame(id, ChessBoardInitializer.createInitialBoard());
    }

    public Long loadChessGame(String roomName) throws SQLException {
        return chessGameDao.findChessGameByName(roomName);
    }

    public GameScoreDto calculateScore(ChessGameState chessGameState) {
        Map<Coordinate, ChessPiece> board = chessGameState.getBoard();

        double blackScore = ChessBoardScoreCalculator.calculate(Color.BLACK, board);
        double whiteScore = ChessBoardScoreCalculator.calculate(Color.WHITE, board);

        return new GameScoreDto(blackScore, whiteScore);
    }

    public void stopChessGame(ChessGameState chessGameState) throws SQLException {
        chessGameDao.updateChessGameById(chessGameState.getGameId());
    }
}
