package domain.chessGame.statusfactory;

import domain.chessGame.ChessGameEnd;
import domain.chessGame.ChessGameKingCaught;
import domain.chessGame.ChessGameRunning;
import domain.chessGame.InitialChessGame;
import domain.chessGame.base.ChessGame;
import domain.chessboard.ChessBoard;
import domain.piece.Color;

public class ChessStatusFactory {

    public static ChessGame initChessGame() {
        return new InitialChessGame();
    }

    public static ChessGame makeRunningChessGame(Long gameId) {
        return new ChessGameRunning(new ChessBoard(), gameId);
    }

    public static ChessGame makeEndChessGame() {
        return new ChessGameEnd();
    }

    public static ChessGame makeKingCaughtChessGame(ChessBoard chessBoard, Color color, Long gameId) {
        return new ChessGameKingCaught(chessBoard, color, gameId);
    }
}
