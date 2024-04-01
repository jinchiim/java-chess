package db.dao;

import db.entity.Piece;
import java.sql.SQLException;
import java.util.List;

public interface ChessPieceDao {

    void create(Long gameId, List<Piece> pieces) throws SQLException;

    void updateByRowAndColumn(Long id, String row, String column) throws SQLException;

    void updateByRowAndColumnAndPieceType(Long id, String row, String column) throws SQLException;

    Long findIdByRowAndColumnAndGameId(Long gameId, String row, String column)
            throws SQLException;

    void delete(Long gameId) throws SQLException;
}
