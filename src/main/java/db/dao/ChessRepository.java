package db.dao;

import db.entity.ChessGame;
import java.sql.SQLException;

public interface ChessRepository {

    Long create(ChessGame chessGame) throws SQLException;

    void delete(Long gameId) throws SQLException;
}
