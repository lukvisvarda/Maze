package maze;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Position {
    private int x;
    private int y;
    private Position position;

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
