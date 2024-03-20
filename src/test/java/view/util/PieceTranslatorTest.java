package view.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import piece.Pawn;

class PieceTranslatorTest {

    @DisplayName("해당하는 말이 검정 말일 경우 대문자 이름을 가져온다.")
    @Test
    void getBlackPieceName() {
        Pawn pawn = new Pawn(true);

        assertThat(PieceTranslator.getName(pawn)).isEqualTo("P");
    }

    @DisplayName("해당하는 말이 흰 말일 경우 소문자 이름을 가져온다.")
    @Test
    void getWhitePieceName() {
        Pawn pawn = new Pawn(false);

        assertThat(PieceTranslator.getName(pawn)).isEqualTo("p");
    }

    @DisplayName("해당하는 말이 없을 경우 빈 칸을 뜻하는 이름을 가져온다.")
    @Test
    void getBlankPieceName() {

        assertThat(PieceTranslator.getName(null)).isEqualTo(".");
    }
}
