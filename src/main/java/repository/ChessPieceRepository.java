package repository;

import db.dao.ChessPieceDao;
import db.dao.PieceDao;
import db.entity.Piece;
import java.sql.SQLException;
import java.util.List;

public class ChessPieceRepository {

    private final ChessPieceDao chessPieceDao;

    public ChessPieceRepository() {
        this.chessPieceDao = new PieceDao();
    }

    public void saveAll(Long gameId, List<Piece> pieces) throws SQLException {
        chessPieceDao.create(gameId, pieces);
    }

    public Long findIdByRowAndColumnAndGameId(Long gameId, String row, String column)
            throws SQLException {
        return chessPieceDao.findIdByRowAndColumnAndGameId(gameId, row, column);
    }

    public void updateRowAndColumn(Long pieceId, String rowPosition, String columnPosition) throws SQLException {
        chessPieceDao.updateByRowAndColumn(pieceId, rowPosition, columnPosition);
    }

    public void updateByRowAndColumnAndPieceType(Long pieceId, String rowPosition, String columnPosition)
            throws SQLException {
        chessPieceDao.updateByRowAndColumnAndPieceType(pieceId, rowPosition, columnPosition);
    }

    public void delete(Long gameId) throws SQLException {
        chessPieceDao.delete(gameId);
    }
}
