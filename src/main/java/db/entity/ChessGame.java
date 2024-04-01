package db.entity;

import db.booleanTranslator.BooleanTranslator;

public class ChessGame {
    private final int isRunning;

    private ChessGame(int isRunning) {
        this.isRunning = isRunning;
    }

    public static ChessGame create() {
        return new ChessGame(BooleanTranslator.translate(false));
    }

    public String isRunning() {
        return String.valueOf(isRunning);
    }
}
