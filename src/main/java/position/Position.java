package position;

import java.util.Objects;

public class Position {

    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 7;

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public int getMinusPosition(Position position) {
        return position.position - this.position;
    }

    public void moveBy(int distance) {
        position += distance;
        if (position < MIN_POSITION || MAX_POSITION < position) {
            throw new IllegalArgumentException("움직일 수 있는 위치가 아닙니다.");
        }
    }

    public int getPosition() {
        return position;
    }

    public Position copied() {
        return new Position(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
