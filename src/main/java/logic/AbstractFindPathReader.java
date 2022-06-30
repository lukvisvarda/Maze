package logic;

import maze.Maze;
import java.io.File;
import java.util.List;

public abstract class AbstractFindPathReader {

    public abstract void execute(File text) throws Exception;
    public abstract void execute(String text) throws Exception;

    public void logic(Maze maze) throws Exception {
        Logic logic = new Logic();
        List<String> path = logic.solveShortesPath(maze);
        path = maze.reversePath(path);
        System.out.println();
        System.out.println(path);
    }
}
