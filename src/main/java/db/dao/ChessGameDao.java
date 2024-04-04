package db.dao;

import db.booleanTranslator.BooleanTranslator;
import db.connection.DatabaseConnection;
import db.entity.ChessGame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChessGameDao {

    public Long save(ChessGame chessGame) throws SQLException {
        String query = "INSERT INTO chess_game " +
                "(id, is_running, room_name) " +
                "VALUES(DEFAULT, true, ?)";
        Connection connection = DatabaseConnection.getConnection();

        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, chessGame.getRoomName());
            statement.executeUpdate();

            ResultSet result = statement.getGeneratedKeys();

            if (result.next()) {
                connection.commit();
                return result.getLong(1);
            }
            connection.close();
            throw new RuntimeException("해당하는 데이터가 없습니다.");
        } catch (SQLException e) {
            connection.rollback();
            connection.close();
            throw new RuntimeException("데이터베이스 생성에 실패했습니다." + e.getMessage());
        }
    }

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
            connection.close();
            throw new RuntimeException("데이터베이스 삭제에 실패했습니다." + e.getMessage());
        }
    }

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
            connection.close();
            throw new RuntimeException("데이터베이스 생성에 실패했습니다." + e.getMessage());
        }
    }

    public Long findChessGameByName(String roomName) throws SQLException {
        String query = "SELECT * " +
                "FROM chess_game " +
                "WHERE room_name = ?";

        Connection connection = DatabaseConnection.getConnection();

        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, roomName);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                connection.commit();
                validateNotEndGame(result);
                return result.getLong(1);
            }
            connection.close();

            throw new RuntimeException("해당하는 데이터가 없습니다.");
        } catch (SQLException e) {
            connection.rollback();
            connection.close();
            throw new RuntimeException("체스 게임 불러오기에 실패했습니다." + e.getMessage());
        }
    }

    private static void validateNotEndGame(ResultSet result) throws SQLException {
        if (result.getInt(3) == BooleanTranslator.translate(false)) {
            throw new IllegalArgumentException("이미 종료된 게임입니다.");
        }
    }
}
