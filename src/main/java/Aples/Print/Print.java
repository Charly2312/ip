package Aples.Print;

import Aples.Tasks.Task;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static Aples.Tasks.HandleData.copyContents;
import static Aples.Tasks.HandleData.printFileContents;


public class Print {

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

    public static void markBox(String line, ArrayList<Task> list) {
        String[] words = line.split(" ");
        int taskIndex = Integer.parseInt(words[1]);
        if (list.get(taskIndex - 1) != null) {
            System.out.println("-".repeat(LINE_DASH_LENGTH));
            System.out.println("Nice! I've marked this task as done:");
            list.get(taskIndex - 1).markDone();
            //System.out.println("  " + list[taskIndex - 1].getSign() + list[taskIndex - 1].getDescription());
            System.out.println("  " + list.get(taskIndex - 1).toString());
            System.out.println("-".repeat(LINE_DASH_LENGTH));
        } else {
            System.out.println("-".repeat(LINE_DASH_LENGTH));
            System.out.println("There are not that many tasks in the list. Please write a smaller number");
            System.out.println("-".repeat(LINE_DASH_LENGTH));
        }
    }

    public static void unmarkBox(String line, ArrayList<Task> list) {
        String[] words = line.split(" ");
        int taskIndex = Integer.parseInt(words[1]);
        if (list.get(taskIndex - 1) != null) {
            System.out.println("-".repeat(LINE_DASH_LENGTH));
            System.out.println("Sadness but OK, I've marked this task as not done yet:");
            list.get(taskIndex - 1).markNotDone();
            //System.out.println("  " + list[taskIndex - 1].getSign() + list[taskIndex - 1].getDescription());
            System.out.println("  " + list.get(taskIndex - 1).toString());
            System.out.println("-".repeat(LINE_DASH_LENGTH));
        } else {
            System.out.println("-".repeat(LINE_DASH_LENGTH));
            System.out.println("There are not that many tasks in the list. Please write a smaller number");
            System.out.println("-".repeat(LINE_DASH_LENGTH));
        }
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

}
