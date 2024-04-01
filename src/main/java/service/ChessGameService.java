package service;

import db.entity.ChessGame;
import java.sql.SQLException;
import repository.ChessGameRepository;

public class ChessGameService {

    private final ChessGameRepository chessGameRepository;

    public ChessGameService() {
        this.chessGameRepository = new ChessGameRepository();
    }

    public Long addChessGame() throws SQLException {
        ChessGame chessGame = ChessGame.create();
        return chessGameRepository.save(chessGame);
    }

    public void deleteChessGame(Long gameId) throws SQLException {
        chessGameRepository.delete(gameId);
    }
}
