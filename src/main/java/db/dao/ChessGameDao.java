package db.dao;

import db.connection.DatabaseConnection;
import db.entity.ChessGame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChessGameDao implements ChessGameRepository {

    @Override
    public Long save(ChessGame chessGame) throws SQLException {
        String query = "INSERT INTO chess_game " +
                "(id, is_running) " +
                "VALUES(DEFAULT, true)";
        Connection connection = DatabaseConnection.getConnection();

        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();

            ResultSet result = statement.getGeneratedKeys();

            if (result.next()) {
                connection.commit();
                return result.getLong(1);
            }
            connection.rollback();
            throw new RuntimeException("해당하는 데이터가 없습니다.");
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException("데이터베이스 생성에 실패했습니다." + e.getMessage());
        }
    }

    @Override
    public void delete(Long gameId) throws SQLException {
        String query = "DELETE FROM chess_game " +
                "WHERE id = ?";

        Connection connection = DatabaseConnection.getConnection();

        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, gameId);

            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException("데이터베이스 삭제에 실패했습니다." + e.getMessage());
        }
    }

    @Override
    public void updateChessGameById(Long gameId) throws SQLException {
        String query = "UPDATE chess_game " +
                "SET is_running = false " +
                "WHERE id = ?";

        Connection connection = DatabaseConnection.getConnection();

        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, gameId);
            statement.executeUpdate();

            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            throw new RuntimeException("데이터베이스 생성에 실패했습니다." + e.getMessage());
        }
    }
}
