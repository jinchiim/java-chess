package state.chessGame.statusfactory;

import domain.chessboard.ChessBoard;
import domain.piece.Color;
import state.chessGame.ChessGameEnd;
import state.chessGame.ChessGameKingCaught;
import state.chessGame.ChessGameRunning;
import state.chessGame.InitialChessGame;
import state.chessGame.base.ChessGame;

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
