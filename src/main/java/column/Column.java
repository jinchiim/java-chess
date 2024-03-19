package column;

import java.util.Objects;

public class Column {

    private int position;

    public Column(int position) {
        this.position = position;
    }

    public void move(int nextPosition) {
        if (nextPosition < 0 || 7 < nextPosition) {
            throw new IllegalArgumentException("움직일 수 있는 위치가 아닙니다.");
        }
        position = nextPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Column column = (Column) o;
        return position == column.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
