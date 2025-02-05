import org.w3c.dom.ls.LSInput;

import java.util.Arrays;
import java.util.Scanner;

public class Aples {

    public static final int MAX_ENTRIES = 100;
    public static final int LINE_DASH_LENGTH = 50;

    public static void handleTodoTask(String line, Task[] list, int itemIndex) {
        String description = line.substring(5); //take out the description without the category word
        list[itemIndex] = new Todo(description);
        Print.echoTask(list[itemIndex], itemIndex + 1);
    }

    public static void handleDeadlineTask(String line, Task[] list, int itemIndex) {
        if (line.contains("/by")) {
            int byPosition = line.indexOf("/by");
            String description = line.substring(9, byPosition);
            String deadline = line.substring(byPosition + 4);
            list[itemIndex] = new Deadline(description, deadline);
            Print.echoTask(list[itemIndex], itemIndex + 1);
        } else {
            System.out.println("-".repeat(Print.LINE_DASH_LENGTH));
            System.out.println("Please key in a Deadline task with the keyword '/by'");
            System.out.println("-".repeat(Print.LINE_DASH_LENGTH));
            String newLine;
            Scanner in = new Scanner(System.in);
            newLine = in.nextLine();
            handleDeadlineTask(newLine, list, itemIndex);
        }
    }

    public static void handleEventTask(String line, Task[] list, int itemIndex) {
        if (line.contains("/from") && line.contains("/to")) {
            int fromPosition = line.indexOf("/from");
            int toPosition = line.indexOf("/to");
            String description = line.substring(6, fromPosition);
            String startTime = line.substring(fromPosition + 6, toPosition);
            String endTime = line.substring(toPosition + 4);
            list[itemIndex] = new Event(description, startTime, endTime);
            Print.echoTask(list[itemIndex], itemIndex + 1);
        } else {
            System.out.println("-".repeat(Print.LINE_DASH_LENGTH));
            System.out.println("Please key in an Event task with both the keywords '/from' and '/to'");
            System.out.println("-".repeat(Print.LINE_DASH_LENGTH));
            String newLine;
            Scanner in = new Scanner(System.in);
            newLine = in.nextLine();
            handleEventTask(newLine, list, itemIndex);
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
        Task[] list = new Task[MAX_ENTRIES]; //make an array of class type: Task
        int itemIndex = 0; //index of the item to be added to the list
        Print.printGreeting();

        while (true) {
            String line;
            Scanner in = new Scanner(System.in);
            line = in.nextLine();
            boolean isBye = line.contains("bye") || line.contains("Bye");
            if (isBye) {
                Print.printBye();
                break;
            } else if (line.equals("list") || line.equals("List")) {
                Print.printList(list);
            } else if (line.contains("unmark")) {
                Print.unmarkBox(line, list);
            } else if (line.contains("mark")) {
                Print.markBox(line, list);
            } else if (line.contains("todo")) {
                handleTodoTask(line, list, itemIndex);
                itemIndex += 1;
            } else if (line.contains("deadline")) {
                handleDeadlineTask(line, list, itemIndex);
                itemIndex += 1;
            } else if (line.contains("event")) {
                handleEventTask(line, list, itemIndex);
                itemIndex += 1;
            } else {
                Print.askRefill();
            }
        }
    }
}
