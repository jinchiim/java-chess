package state.chessGame.base;

import domain.coordinate.Coordinate;

public abstract class NotRunningGame implements ChessGame {

    @Override
    public ChessGame move(Coordinate start, Coordinate destination) {
        throw new UnsupportedOperationException("움직일 수 없는 게임 상태입니다.");
    }

    @Override
    public ChessGame end() {
        throw new UnsupportedOperationException("게임이 끝났거나, 시작되지 않은 상태입니다.");
    }

    @Override
    public boolean isPlaying() {
        return false;
    }
}
