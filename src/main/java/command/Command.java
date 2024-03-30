package command;

public enum Command {

    START("start"),
    MOVE("move"),
    END("end"),
    STATUS("status");

    private final String identifier;

    Command(String identifier) {
        this.identifier = identifier;
    }

    public static boolean isStartCommand(String identifier) {
        return START.identifier.equals(identifier);
    }

    public static boolean
    isStatusCommand(String identifier) {
        return STATUS.identifier.equals(identifier);
    }

    public static boolean isCommandMove(String commandIdentifier) {
        if (isEndCommand(commandIdentifier)) {
            return false;
        }
        if (isStartCommand(commandIdentifier)) {
            throw new IllegalArgumentException("이미 시작한 상태 입니다.");
        }
        if (isStatusCommand(commandIdentifier)) {
            return false;
        }
        return true;
    }

    private static boolean isEndCommand(String identifier) {
        return END.identifier.equals(identifier);
    }
}
