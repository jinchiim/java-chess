package domain.chessGame;

import domain.chessboard.ChessBoard;
import domain.piece.Color;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChessGameKingCaughtTest {

    @DisplayName("킹이 잡혀 게임이 끝난 상태에서 게임을 시작하려 할 경우 에러를 발생한다.")
    @Test
    void startChessGameAtKingCaught() {
        ChessGameKingCaught chessGameKingCaught = new ChessGameKingCaught(new ChessBoard(), Color.WHITE);

        Assertions.assertThatThrownBy(chessGameKingCaught::start)
                .isInstanceOf(UnsupportedOperationException.class)
                .hasMessage("게임이 이미 종료되었습니다.");
    }
}
