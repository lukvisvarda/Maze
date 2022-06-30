package logic;

import maze.Maze;

import java.io.File;
import java.util.Scanner;

public class FindPathInputReaderFile extends AbstractFindPathReader{

    @Override
    public void execute(File text) throws Exception {
        String fileText = "";
        try (Scanner input = new Scanner(text)) {
            while (input.hasNextLine()) {
                fileText += input.nextLine() + "\n";
            }
        }
        Maze maze = new Maze(fileText);
        logic(maze);
    }

    @Override
    public void execute(String text) {
    }
}
