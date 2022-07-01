import logic.FindPathInputReaderFile;
import logic.FindPathReaderStdIn;
import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        read(new Scanner(System.in));
    }

    private static void read(Scanner sc) throws Exception {
        File maze1 = new File("src/main/resources/maze/maze1.txt");
        String read = "";

        while(!Objects.equals(read, "i") && !Objects.equals(read, "f")) {
            System.out.println("Do you want to read file (f) or standard input (i)? ");
            read = sc.next();
        }
        if(read.equals("f")) {
            FindPathInputReaderFile file = new FindPathInputReaderFile();
            file.execute(maze1);
        }
        if(read.equals("i")) {
            int rows;
            do {
                System.out.println("Please specify how many lines you want to enter: ");
                while (!sc.hasNextInt()) {
                    System.out.println("That's not a number!");
                    sc.next();
                }
                rows = sc.nextInt();
            } while (rows <= 0);
            StringBuilder input = new StringBuilder();
            System.out.println("Please input your maze: ");
            for (int i = 0; i < rows; i++) {
                input.append(sc.nextLine()).append("\n");
            }
            FindPathReaderStdIn maze = new FindPathReaderStdIn();
            maze.execute(input.toString());
        }
    }
}
