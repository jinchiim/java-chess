package domain.command;

import static org.assertj.core.api.Assertions.assertThat;

import command.Command;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommandTest {

    @DisplayName("START 커멘드의 식별자와 일치하는지 확인한다.")
    @Test
    void isStartCommand() {
        assertThat(Command.isStartCommand("start")).isTrue();
    }

    @DisplayName("MOVE 커멘드의 식별자와 일치하는 경우 True를 return 한다.")
    @Test
    void moveCommandIdentifierMove() {
        assertThat(Command.isCommandMove("move")).isTrue();
    }

    @DisplayName("MOVE 커멘드의 식별자와 일치하지 않을 경우 false를 return 한다.")
    @Test
    void moveCommandIdentifierNotMove() {
        assertThat(Command.isCommandMove("end")).isFalse();
    }

    @DisplayName("STATUS 커멘드의 식별자와 일치할 경우 true를 return 한다.")
    @Test
    void statusCommandIdentifierStatus() {
        assertThat(Command.isStatusCommand("status")).isTrue();
    }

    @DisplayName("STATUS 커멘드의 식별자와 일치하지 않을 경우 false를 return 한다.")
    @Test
    void statusCommandIdentifierNotStatus() {
        assertThat(Command.isStatusCommand("move")).isFalse();
    }
}
