import org.w3c.dom.ls.LSInput;

import java.util.Scanner;

public class Aples {
    public static void printBye() {
        int length = 50; // Length of the horizontal line
        System.out.println("-".repeat(length));
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("-".repeat(length));
    }

    public static void printGreeting() {
        int length = 50; // Length of the horizontal line
        System.out.println("-".repeat(length));
        System.out.println("Hello! I'm " + "Aples");
        System.out.println("What can I do for you?");
        System.out.println("-".repeat(length));
    }

    public static void main(String[] args) {
        /*String logo =
                  " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println(logo);*/


        String[] list = new String[100];
        int length = 50; // Length of the horizontal line
        printGreeting();

        while (true) {
            String line;
            Scanner in = new Scanner(System.in);
            line = in.nextLine();
            boolean isBye = line.equals("bye") || line.equals("Bye");
            if (isBye) {
                printBye();
                break;
            }
            System.out.println("-".repeat(50));
            System.out.println(line);
            System.out.println("-".repeat(50));
        }
    }
}
