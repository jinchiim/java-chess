package db.dao;

import db.entity.ChessGame;
import java.sql.SQLException;

public interface ChessGameRepository {

    Long save(ChessGame chessGame) throws SQLException;

    void delete(Long gameId) throws SQLException;

    void updateChessGameById(Long gameId) throws SQLException;
}
