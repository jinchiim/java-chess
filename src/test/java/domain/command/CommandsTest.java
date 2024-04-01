package domain.command;

import command.base.Commands;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CommandsTest {


    @ParameterizedTest
    @ValueSource(strings = {"play", "stop", "go", "moving"})
    @DisplayName("존재하지 않는 Command일 경우, 에러를 발생한다.")
    void notExistCommandFind(String inputCommand) {
        Assertions.assertThatThrownBy(() -> Commands.findCommand(inputCommand))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당하는 Command가 없습니다.");
    }

}
