package state.chessGame.statusfactory;

import domain.chessboard.ChessBoard;
import domain.piece.Color;
import state.chessGame.ChessGameStateEnd;
import state.chessGame.ChessGameStateKingCaught;
import state.chessGame.ChessGameStateRunning;
import state.chessGame.InitialChessGameState;
import state.chessGame.base.ChessGameState;

public class ChessStatusFactory {

    public static ChessGameState initChessGame() {
        return new InitialChessGameState();
    }

    public static ChessGameState makeRunningChessGame(Long gameId) {
        return new ChessGameStateRunning(new ChessBoard(), gameId);
    }

    public static ChessGameState makeEndChessGame() {
        return new ChessGameStateEnd();
    }

    public static ChessGameState makeKingCaughtChessGame(ChessBoard chessBoard, Color color, Long gameId) {
        return new ChessGameStateKingCaught(chessBoard, color, gameId);
    }
}
