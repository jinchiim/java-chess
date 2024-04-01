package view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static List<String> receiveCommands() {
        return splitCommand(scanner.nextLine());
    }

    private static List<String> splitCommand(String input) {
        return List.of(input.split(" "));
    }
}
