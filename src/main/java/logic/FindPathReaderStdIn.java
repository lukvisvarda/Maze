package logic;

import maze.Maze;

import java.io.File;

public class FindPathReaderStdIn extends AbstractFindPathReader {
    @Override
    public void execute(File text) throws Exception {
    }

    @Override
    public void execute(String text) throws Exception {
        Maze maze = new Maze(text);
        logic(maze);
    }
}
