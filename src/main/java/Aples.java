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
        System.out.println("Hello! I'm " + "Aples");
        System.out.println("What can I do for you?");
        System.out.println("-".repeat(length));
    }

    public static void printList(Task[] list) {
        int index = 0;
        System.out.println("-".repeat(50));
        while (list[index] != null) {
            System.out.println((index + 1) + ". " + list[index].getSign() + list[index].getDescription());
            index += 1;
        }
        System.out.println("-".repeat(50));
    }

    public static void markBox(String line, Task[] list) {
        String[] words = line.split(" ");
        int taskIndex = Integer.parseInt(words[1]);
        if (list[taskIndex - 1] != null) {
            System.out.println("-".repeat(50));
            System.out.println("Nice! I've marked this task as done:");
            list[taskIndex - 1].markDone();
            System.out.println("  " + list[taskIndex - 1].getSign() + list[taskIndex - 1].getDescription());
            System.out.println("-".repeat(50));
        } else {
            System.out.println("-".repeat(50));
            System.out.println("There are not that many tasks in the list. Please write a smaller number");
            System.out.println("-".repeat(50));
        }
    }

    public static void unmarkBox(String line, Task[] list) {
        String[] words = line.split(" ");
        int taskIndex = Integer.parseInt(words[1]);
        if (list[taskIndex - 1] != null) {
            System.out.println("-".repeat(50));
            System.out.println("Sadness but OK, I've marked this task as not done yet:");
            list[taskIndex - 1].markNotDone();
            System.out.println("  " + list[taskIndex - 1].getSign() + list[taskIndex - 1].getDescription());
            System.out.println("-".repeat(50));
        } else {
            System.out.println("-".repeat(50));
            System.out.println("There are not that many tasks in the list. Please write a smaller number");
            System.out.println("-".repeat(50));
        }
    }

    public static void main(String[] args) {
        String logo =
                "                                               \n" +
                " █████╗ ██████╗ ██╗     ███████╗███████╗       \n" +
                "██╔══██╗██╔══██╗██║     ██╔════╝██╔════╝       \n" +
                "███████║██████╔╝██║     █████╗  ███████╗       \n" +
                "██╔══██║██╔═══╝ ██║     ██╔══╝  ╚════██║       \n" +
                "██║  ██║██║     ███████╗███████╗███████║       \n" +
                "╚═╝  ╚═╝╚═╝     ╚══════╝╚══════╝╚══════╝       \n" +
                "    Aples chatbot at your service              \n";
        System.out.println(logo);
        Task[] list = new Task[100]; //make an array of class type: Task
        int itemIndex = 0;
        printGreeting();

        while (true) {
            String line;
            Scanner in = new Scanner(System.in);
            line = in.nextLine();
            Task task = new Task(line);
            boolean isBye = line.contains("bye") || line.contains("Bye");
            if (isBye) {
                printBye();
                break;
            } else if (line.equals("list") || line.equals("List")) {
                printList(list);
            } else if (line.contains("unmark")) {
                unmarkBox(line, list);
            } else if (line.contains("mark")) {
                markBox(line, list);
            } else {
                list[itemIndex] = task;
                System.out.println("-".repeat(50));
                System.out.println("added: " + line);
                System.out.println("-".repeat(50));
                itemIndex += 1;
            }
        }
    }
}
