import logic.FindPathInputReaderFile;
import logic.FindPathReaderStdIn;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        read(new Scanner(System.in));
    }

    private static void read(Scanner sc) throws Exception {
        File maze1 = new File("src/main/resources/maze/maze1.txt");
        System.out.println("Do you want to read file (f) or standard input (i)? ");
        String read = sc.nextLine();
        if(read.equals("f")) {
            FindPathInputReaderFile file = new FindPathInputReaderFile();
            file.execute(maze1);
        }
        else {
            System.out.println("Please specify how many lines you want to enter: ");
            int rows = sc.nextInt();
            String input = "";
            System.out.println("Please input your maze: ");
            for (int i = 0; i < rows; i++) {
                input += sc.nextLine() + "\n";
            }
            FindPathReaderStdIn maze = new FindPathReaderStdIn();
            maze.execute(input);
        }
    }
}
