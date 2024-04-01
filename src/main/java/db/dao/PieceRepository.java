package db.dao;

import db.entity.Piece;
import java.sql.SQLException;
import java.util.List;

public interface PieceRepository {

    void saveAll(Long gameId, List<Piece> pieces) throws SQLException;

    void updatePieceByRowAndColumn(Long id, String row, String column) throws SQLException;

    void updatePieceByRowAndColumnAndPieceType(Long id, String row, String column) throws SQLException;

    Long findIdByRowAndColumnAndGameId(Long gameId, String row, String column)
            throws SQLException;

    void delete(Long gameId) throws SQLException;
}
