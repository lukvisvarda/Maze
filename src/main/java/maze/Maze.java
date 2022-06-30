package maze;

import lombok.Getter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
public class Maze {
    private static final int ROAD = 0;
    private static final int WALL = 1;
    private static final int START = 2;
    private static final int EXIT = 3;
    private static final int PATH = 4;
    private int[][] maze;
    private boolean[][] visited;
    private Position start;
    private Position end;

    public Maze(String maze) {
        initializeMaze(maze);
    }

    private void initializeMaze(String text) {
        if (text == null || (text = text.trim()).length() == 0) {
            throw new IllegalArgumentException("EMPTY");
        }

        String[] lines = text.split("\n");
        maze = new int[lines.length][lines[0].length()];
        visited = new boolean[lines.length][lines[0].length()];

        for (int row = 0; row < getHeight(); row++) {
            if (lines[row].length() != getWidth()) {
                throw new IllegalArgumentException("line " + (row + 1) + " has wrong length (was " + lines[row].length() + " but should be " + getWidth() + ")");
            }

            for (int col = 0; col < getWidth(); col++) {
                if (lines[row].charAt(col) == '#')
                    maze[row][col] = WALL;
                else if (lines[row].charAt(col) == 'S') {
                    maze[row][col] = START;
                    start = new Position(row, col);
                } else if (lines[row].charAt(col) == 'X') {
                    maze[row][col] = EXIT;
                    end = new Position(row, col);
                } else
                    maze[row][col] = ROAD;
            }
        }
    }

    public Position getEntry() {
        return start;
    }

    public int getHeight() {
        return maze.length;
    }

    public int getWidth() {
        return maze[0].length;
    }

    public boolean isExit(int x, int y) {
        return x == end.getX() && y == end.getY();
    }

    public boolean isExplored(int x, int y) {
        return visited[x][y];
    }

    public boolean isWall(int row, int col) {
        return maze[row][col] == WALL;
    }

    public void setVisited(int row, int col, boolean value) {
        visited[row][col] = value;
    }

    public boolean isValidLocation(int row, int col) {
        if (row < 0 || row >= getHeight() || col < 0 || col >= getWidth()) {
            return false;
        }
        return true;
    }

    public List<String> reversePath(List<String> path) {
        List<String> output = new ArrayList<>();
        for(int i = path.size() - 1; i >= 0; i--) {
            output.add(path.get(i));
        }
        return output;
    }
}

