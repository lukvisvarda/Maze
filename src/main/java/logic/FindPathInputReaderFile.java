package logic;

import maze.Maze;
import java.io.File;
import java.util.Scanner;

public class FindPathInputReaderFile extends AbstractFindPathReader{

    @Override
    public void execute(File text) throws Exception {
        StringBuilder fileText = new StringBuilder();
        try (Scanner input = new Scanner(text)) {
            while (input.hasNextLine()) {
                fileText.append(input.nextLine()).append("\n");
            }
        }
        Maze maze = new Maze(fileText.toString());
        logic(maze);
    }

    @Override
    public void execute(String text) {
    }
}
