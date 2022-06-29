import logic.Logic;
import maze.Maze;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        File maze1 = new File("src/main/resources/maze/maze1.txt");
        execute(maze1);
    }

    private static void execute(File file) throws Exception {
        Maze maze = new Maze(file);
        logic(maze);
    }

    private static void logic(Maze maze) throws Exception {
        Logic logic = new Logic();
        List<String> path = logic.solve(maze);
        maze.printPath(path);
        maze.reset();
    }
}
