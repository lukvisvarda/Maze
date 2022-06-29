package maze;

import lombok.Getter;

@Getter
public class Position {
    int x;
    int y;
    Position position;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
        this.position = null;
    }

    public Position(int x, int y, Position position) {
        this.x = x;
        this.y = y;
        this.position = position;
    }
}
