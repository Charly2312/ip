package Aples.Print;

import Aples.Tasks.Task;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static Aples.Tasks.DataHandler.copyContents;


public class Printer {

    public static final int LINE_DASH_LENGTH = 50;

    public static void printBye() {
        System.out.println("-".repeat(LINE_DASH_LENGTH));
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("-".repeat(LINE_DASH_LENGTH));
    }

    public static void printGreeting(ArrayList<Task> list) {
        System.out.println("Hello! I'm Aples");
        System.out.println("This is where you left of:");
        try {
            copyContents(list);
            printList(list);
        } catch (FileNotFoundException e) {
            System.out.println("File not found, please check your filepath");
        }
        System.out.println("What can I do for you?");
        System.out.println("-".repeat(LINE_DASH_LENGTH));
    }

    public static void printList(ArrayList<Task> list) {
        int index = 0;
        System.out.println("-".repeat(LINE_DASH_LENGTH));
        while (index < list.size()) {
            System.out.println((index + 1) + ". " + list.get(index).toString());
            index += 1;
        }
        System.out.println("-".repeat(LINE_DASH_LENGTH));
    }

    public static void echoTask(Task task, int itemNumber) {
        System.out.println("-".repeat(LINE_DASH_LENGTH));
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task.toString());
        if (itemNumber == 1) {
            System.out.println("Now you have " + itemNumber + " task in the list.");
        } else {
            System.out.println("Now you have " + itemNumber + " tasks in the list.");
        }
        System.out.println("-".repeat(LINE_DASH_LENGTH));
    }

    public static void askRefill() {
        System.out.println("-".repeat(LINE_DASH_LENGTH));
        System.out.println("Please key in a task in either todo/deadline/event category :)");
        System.out.println("-".repeat(LINE_DASH_LENGTH));
    }

    public static void todoError() {
        System.out.println("-".repeat(LINE_DASH_LENGTH));
        System.out.println("There is nothing to-do:( Please input todo with a description.");
        System.out.println("-".repeat(LINE_DASH_LENGTH));
    }

    public static void deadlineError() {
        System.out.println("-".repeat(LINE_DASH_LENGTH));
        System.out.println("I can only say by-by:( Please input deadline with a description.");
        System.out.println("-".repeat(LINE_DASH_LENGTH));
    }

    public static void eventError() {
        System.out.println("-".repeat(LINE_DASH_LENGTH));
        System.out.println("Wheres the start and end:( Please input event with a description.");
        System.out.println("-".repeat(LINE_DASH_LENGTH));
    }

    public static void deleteError() {
        System.out.println("-".repeat(LINE_DASH_LENGTH));
        System.out.println("Where is the index :( Please key in delete followed by an index");
        System.out.println("-".repeat(LINE_DASH_LENGTH));
    }

}
