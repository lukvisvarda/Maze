package maze;

import lombok.Getter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

    public Maze(File maze) throws FileNotFoundException {
        String fileText = "";
        try (Scanner input = new Scanner(maze)) {
            while (input.hasNextLine()) {
                fileText += input.nextLine() + "\n";
            }
        }
        initializeMaze(fileText);
    }

    private void initializeMaze(String text) {
        if (text == null || (text = text.trim()).length() == 0) {
            throw new IllegalArgumentException("EMPTY");
        }

        String[] lines = text.split("\n");
        maze = new int[lines.length][lines[0].length()];
        visited = new boolean[lines.length][lines[0].length()];

        for (int x = 0; x < getHeight(); x++) {
            if (lines[x].length() != getWidth()) {
                throw new IllegalArgumentException("line " + (x + 1) + " wrong length (was " + lines[x].length() + " but should be " + getWidth() + ")");
            }

            for (int y = 0; y < getWidth(); y++) {
                if (lines[x].charAt(y) == '#')
                    maze[x][y] = WALL;
                else if (lines[x].charAt(y) == 'S') {
                    maze[x][y] = START;
                    start = new Position(x, y);
                } else if (lines[x].charAt(y) == 'X') {
                    maze[x][y] = EXIT;
                    end = new Position(x, y);
                } else
                    maze[x][y] = ROAD;
            }
        }
    }

    public Position getEntry() {
        return start;
    }

    public Position getExit() {
        return end;
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

    public boolean isStart(int x, int y) {
        return x == start.getX() && y == start.getY();
    }

    public boolean isExplored(int x, int y) {
        return visited[x][y];
    }

    public boolean isWall(int x, int y) {
        return maze[x][y] == WALL;
    }

    public void setVisited(int x, int y, boolean value) {
        visited[x][y] = value;
    }

    public boolean isValidLocation(int x, int y) {
        if (x < 0 || x >= getHeight() || y < 0 || y >= getWidth()) {
            return false;
        }
        return true;
    }

    public void printPath(List<String> path) {
        List<String> output = new ArrayList<>();
        for(int i = path.size() - 1; i > 0; i--) {
            output.add(path.get(i));
        }
        System.out.println(output.toString());
    }

    public String toString(int[][] maze) {
        StringBuilder result = new StringBuilder(getWidth() * (getHeight() + 1));
        for (int x = 0; x < getHeight(); x++) {
            for (int y = 0; y < getWidth(); y++) {
                if (maze[x][y] == ROAD) {
                    result.append(' ');
                } else if (maze[x][y] == WALL) {
                    result.append('#');
                } else if (maze[x][y] == START) {
                    result.append('S');
                } else if (maze[x][y] == EXIT) {
                    result.append('X');
                } else {
                    result.append('.');
                }
            }
            result.append('\n');
        }
        return result.toString();
    }

    public void reset() {
        for (int i = 0; i < visited.length; i++)
            Arrays.fill(visited[i], false);
    }
}

