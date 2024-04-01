package command.base;

import command.End;
import command.Move;
import command.Start;
import command.Status;
import java.util.Arrays;

public enum Commands {

    START("start", new Start()),
    MOVE("move", new Move()),
    END("end", new End()),
    STATUS("status", new Status());

    private final String identifier;
    private final Command commandStatus;

    Commands(String identifier, Command commandStatus) {
        this.identifier = identifier;
        this.commandStatus = commandStatus;
    }

    public static Command findCommand(String inputCommand) {
        Commands commands = Arrays.stream(values())
                .filter(command -> command.identifier.equals(inputCommand))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 Command가 없습니다."));

        return commands.commandStatus;
    }
}
