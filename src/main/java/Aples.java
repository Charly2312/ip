import Aples.Print.Print;
import Aples.Tasks.*;

import java.util.Scanner;
import java.util.ArrayList;

public class Aples {

    public static final int MAX_ENTRIES = 100;
    public static final int LINE_DASH_LENGTH = 50;

    public static ArrayList<Task> list = new ArrayList<>();
    public static void main(String[] args) {
        /*String logo =
                "                                \n" +
                "    ___    ____  __    ____  ___ \n " +
                "   /__ | (  _ \(  )  ( ___)/ __) \n " +
                "  /(__)| |___/ )(__  )__) \__ \ \n " +
                " (__)(__)|__)  (____)(____)(___/ \n " +
                "    Aples chatbot at your service   \n";
        System.out.println(logo);*/
        //Task[] list = new Task[MAX_ENTRIES]; //make an array of class type: Task
        int itemIndex = 0; //index of the item to be added to the list
        Print.printGreeting(list);

        String line;
        Scanner in = new Scanner(System.in); //needs to be outside of the loop to ensure the automated test runs
        while (true) {
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
                HandleTask.handleTodoTask(line, list, itemIndex);
                itemIndex += 1;
            } else if (line.contains("deadline")) {
                HandleTask.handleDeadlineTask(line, list, itemIndex);
                itemIndex += 1;
            } else if (line.contains("event")) {
                HandleTask.handleEventTask(line, list, itemIndex);
                itemIndex += 1;
            } else if (line.contains("delete")) {
                HandleTask.deleteTask(line, list);
                itemIndex -= 1;
            } else {
                Print.askRefill();
            }
        }
    }
}
