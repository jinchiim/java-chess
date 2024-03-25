package domain.chessboard;

import domain.coordinate.Coordinate;
import domain.piece.Color;
import domain.piece.base.ChessPiece;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ChessBoard {

    private static final int ROW_DIRECTION = 0;
    private static final int COLUMN_DIRECTION = 1;

    private final Map<Coordinate, ChessPiece> board;

    private Color currentTurn = Color.WHITE;

    public ChessBoard() {
        board = ChessBoardInitializer.createInitialBoard();
    }

    public void playTurn(Coordinate start, Coordinate destination) {
        ChessPiece piece = findPiece(start);
        Coordinate startPosition = start.copied();

        validateBeforePlay(destination, currentTurn, piece);

        List<Integer> direction = piece.getDirection(start, destination, isAttack(currentTurn, destination));

        validateCanMove(start, destination, direction);
        movePiece(destination, startPosition, piece);

        currentTurn = changeTurn();
    }

    private void movePiece(Coordinate destination, Coordinate startPosition, ChessPiece piece) {
        board.remove(startPosition);
        board.put(destination, piece);
    }

    private Color changeTurn() {
        if (currentTurn == Color.BLACK) {
            return Color.WHITE;
        }
        return Color.BLACK;
    }


    private void validateBeforePlay(Coordinate destination, Color currentTurn, ChessPiece piece) {
        validateDestination(destination, currentTurn);
        validateTurn(piece, currentTurn);
    }

    private void validateDestination(Coordinate destination, Color currentTurn) {
        ChessPiece chessPiece = findPiece(destination);

        if (chessPiece == null) {
            return;
        }
        if (!chessPiece.isNotSameColor(currentTurn)) {
            throw new IllegalArgumentException("같은 색의 말은 공격할 수 없습니다.");
        }
    }

    private void validateTurn(ChessPiece piece, Color currentTurn) {
        if (piece.isNotSameColor(currentTurn)) {
            throw new IllegalArgumentException("상대의 말을 움직일 수 없습니다.");
        }
    }

    private void validateCanMove(Coordinate coordinate, Coordinate destination, List<Integer> direction) {
        while (!coordinate.equals(destination)) {
            coordinate.moveByDistances(direction.get(ROW_DIRECTION), direction.get(COLUMN_DIRECTION));

            hasPieceOnPath(coordinate, destination);
        }
    }

    private void hasPieceOnPath(Coordinate coordinate, Coordinate destination) {
        if (coordinate.equals(destination)) {
            return;
        }

        if (board.get(coordinate) != null) {
            throw new IllegalArgumentException("이동 경로에 말이 존재합니다.");
        }
    }

    private ChessPiece findPiece(Coordinate coordinate) {
        return board.get(coordinate);
    }

    private boolean isAttack(Color current, Coordinate destination) {
        ChessPiece destinationPiece = board.get(destination);

        return destinationPiece != null && destinationPiece.isNotSameColor(current);
    }

    public Map<Coordinate, ChessPiece> getBoard() {
        return Collections.unmodifiableMap(board);
    }
}
