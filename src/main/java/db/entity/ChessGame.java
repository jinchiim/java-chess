package db.entity;

import db.booleanTranslator.BooleanTranslator;
import domain.room.GameRoom;

public class ChessGame {
    private final int isRunning;
    private final String roomName;

    private ChessGame(int isRunning, String roomName) {
        this.isRunning = isRunning;
        this.roomName = roomName;
    }

    public static ChessGame create(GameRoom gameRoom) {
        return new ChessGame(BooleanTranslator.translate(false), gameRoom.getName());
    }

    public String getRoomName() {
        return roomName;
    }
}
