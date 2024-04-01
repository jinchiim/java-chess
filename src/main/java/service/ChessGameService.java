package service;

import db.dao.ChessGameDao;
import db.dao.ChessGameRepository;
import db.entity.ChessGame;
import java.sql.SQLException;

public class ChessGameService {

    private final ChessGameRepository chessGameRepository;

    public ChessGameService() {
        this.chessGameRepository = new ChessGameDao();
    }

    public Long addChessGame() throws SQLException {
        ChessGame chessGame = ChessGame.create();
        return chessGameRepository.save(chessGame);
    }

    public void deleteChessGame(Long gameId) throws SQLException {
        chessGameRepository.delete(gameId);
    }
}
