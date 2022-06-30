import logic.Logic;
import maze.Maze;
import maze.Position;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import static org.junit.Assert.*;



public class MazeTest {
    @Test
    public void testResultingPath() throws Exception {
        File maze1 = new File("src/main/resources/maze/maze1.txt");
        String fileText = "";
        try (Scanner input = new Scanner(maze1)) {
            while (input.hasNextLine()) {
                fileText += input.nextLine() + "\n";
            }
        }
        Maze maze = new Maze(fileText);
        Logic logic = new Logic();
        List<String> result = logic.solve(maze);
        assertTrue("Solution should be equal to expected", fromStartToEnd(maze, result));
    }

    private boolean fromStartToEnd(Maze maze, List<String> result) {
        Position cur = maze.getEntry();
        for(int i = 0; i < result.size(); i++) {
            String s = result.get(i);
            switch (s) {
                case "u":
                    cur.setX(cur.getX() - 1);
                    break;
                case "d":
                    cur.setX(cur.getX() + 1);
                    break;
                case "l":
                    cur.setY(cur.getY() - 1);
                    break;
                case "r":
                    cur.setY(cur.getY() + 1);
                    break;
            }
        }
        return cur.getX() == maze.getEnd().getX() && cur.getY() == maze.getEnd().getY();
    }
}
