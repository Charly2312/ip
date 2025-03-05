import Aples.Print.Print;
import Aples.Tasks.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import static Aples.Tasks.HandleData.updateFile;

public class Aples {

    public static ArrayList<Task> list = new ArrayList<>();
    public static void main(String[] args) {
        String logo =
            "\n" +
            "       **     *******  **       ********  ******** \n" +
            "      ****   /**////**/**      /**/////  **////// \n" +
            "     **//**  /**   /**/**      /**      /**       \n" +
            "    **  //** /******* /**      /******* /********* \n" +
            "   **********/**////  /**      /**////  ////////** \n" +
            "  /**//////**/**      /**      /**             /** \n" +
            "  /**     /**/**      /********/******** ******** \n" +
            "  //      // //       //////// //////// ////////  \n" +
            "                Aples at your service             \n ";
        System.out.println(logo);
        Print.printGreeting(list);

        String line;
        //needs to be outside of the loop to ensure the automated test runs
        Scanner in = new Scanner(System.in);
        while (true) {
            line = in.nextLine();
            boolean isBye = line.contains("bye") || line.contains("Bye");
            if (isBye) {
                Print.printBye();
                try {
                    updateFile(list);
                } catch (IndexOutOfBoundsException e) { //take out the description without the category word
                    Print.deadlineError();
                } catch (FileNotFoundException e) {
                    System.out.println("File not found");
                } catch (IOException e) {
                    System.out.println("Something went wrong: " + e.getMessage());
                }
                break;
            } else if (line.equals("list") || line.equals("List")) {
                Print.printList(list);
            } else if (line.contains("unmark")) {
                HandleTask.unmarkBox(line, list);
            } else if (line.contains("mark")) {
                HandleTask.markBox(line, list);
            } else if (line.contains("todo")) {
                HandleTask.handleTodoTask(line, list);
            } else if (line.contains("deadline")) {
                HandleTask.handleDeadlineTask(line, list);
            } else if (line.contains("event")) {
                HandleTask.handleEventTask(line, list);
            } else if (line.contains("delete")) {
                HandleTask.deleteTask(line, list);
            } else if (line.contains("find")) {
                HandleTask.findKeywordInTask(line,list);
            } else {
                Print.askRefill();
            }
        }
    }
}
