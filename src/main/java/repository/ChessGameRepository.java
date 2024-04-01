package repository;

import db.dao.ChessGameDao;
import db.dao.ChessRepository;
import db.entity.ChessGame;
import java.sql.SQLException;

public class ChessGameRepository {

    private final ChessRepository chessDao;

    public ChessGameRepository() {
        this.chessDao = new ChessGameDao();
    }

    public Long save(ChessGame chessGame) throws SQLException {
        return chessDao.create(chessGame);
    }

    public void delete(Long gameId) throws SQLException {
        chessDao.delete(gameId);
    }
}
