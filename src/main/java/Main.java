import logic.Logic;
import maze.Maze;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        read(sc);
    }

    private static void read(Scanner sc) throws Exception {
        File maze1 = new File("src/main/resources/maze/maze1.txt");
        System.out.println("Do you want to read file (f) or standard input (i)? ");
        String read = sc.nextLine();
        if(read.equals("f"))
            execute(maze1);
        else {
            System.out.println("Please specify how many lines you want to enter: ");
            int rows = sc.nextInt();
            String input = "";
            System.out.println("Please input your maze: ");
            for (int i = 0; i < rows; i++) {
                input += sc.nextLine() + "\n";
            }
            execute(input);
        }
    }

    private static void execute(File text) throws Exception {
        String fileText = "";
        try (Scanner input = new Scanner(text)) {
            while (input.hasNextLine()) {
                fileText += input.nextLine() + "\n";
            }
        }
        Maze maze = new Maze(fileText);
        logic(maze);
    }

    private static void execute(String text) throws Exception {
        Maze maze = new Maze(text);
        logic(maze);
    }

    private static void logic(Maze maze) throws Exception {
        Logic logic = new Logic();
        List<String> path = logic.solve(maze);
        maze.printPath(path);
        maze.reset();
    }
}
