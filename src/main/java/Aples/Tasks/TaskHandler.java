package Aples.Tasks;

import Aples.Print.Printer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import static Aples.Tasks.DataHandler.updateFile;

public class TaskHandler {
    public static void markBox(String line, ArrayList<Task> list) {
        String[] words = line.split(" ");
        int taskIndex = Integer.parseInt(words[1]);
        if (taskIndex <= list.size() && taskIndex > 0) {
            System.out.println("-".repeat(Printer.LINE_DASH_LENGTH));
            System.out.println("Nice! I've marked this task as done:");
            list.get(taskIndex - 1).markDone();
            //System.out.println("  " + list[taskIndex - 1].getSign() + list[taskIndex - 1].getDescription());
            System.out.println("  " + list.get(taskIndex - 1).toString());
            System.out.println("-".repeat(Printer.LINE_DASH_LENGTH));
        } else {
            System.out.println("-".repeat(Printer.LINE_DASH_LENGTH));
            System.out.println("You only have " + list.size() + " task(s) left. Please key in a smaller number");
            System.out.println("-".repeat(Printer.LINE_DASH_LENGTH));
        }
    }

    public static void unmarkBox(String line, ArrayList<Task> list) {
        String[] words = line.split(" ");
        int taskIndex = Integer.parseInt(words[1]);
        if (taskIndex <= list.size() && taskIndex > 0) {
            System.out.println("-".repeat(Printer.LINE_DASH_LENGTH));
            System.out.println("Sadness but OK, I've marked this task as not done yet:");
            list.get(taskIndex - 1).markNotDone();
            //System.out.println("  " + list[taskIndex - 1].getSign() + list[taskIndex - 1].getDescription());
            System.out.println("  " + list.get(taskIndex - 1).toString());
            System.out.println("-".repeat(Printer.LINE_DASH_LENGTH));
        } else {
            System.out.println("-".repeat(Printer.LINE_DASH_LENGTH));
            System.out.println("You only have " + list.size() + " task(s) left. Please key in a smaller number");
            System.out.println("-".repeat(Printer.LINE_DASH_LENGTH));
        }
    }
    public static void handleTodoTask(String line, ArrayList<Task> list) {
        try {
            String description = line.substring(5);
            list.add(new Todo(description));
            Printer.echoTask(list.get(list.size() - 1), list.size());
        } catch (IndexOutOfBoundsException e) { //take out the description without the category word
            Printer.todoError();
        }
    }

    public static void handleDeadlineTask(String line, ArrayList<Task> list) {
        try {
            //check if there's something after deadline
            String statement = line.substring(9);
            if (statement.contains("/by")) {
                list.add(Parser.parseToDeadline(line));
                Printer.echoTask(list.get(list.size() - 1), list.size());
            } else {
                System.out.println("-".repeat(Printer.LINE_DASH_LENGTH));
                System.out.println("Please key in a Deadline task with the keyword '/by'");
                System.out.println("-".repeat(Printer.LINE_DASH_LENGTH));
            }
        } catch (IndexOutOfBoundsException e) { //take out the description without the category word
            Printer.deadlineError();
        }
    }

    public static void handleEventTask(String line, ArrayList<Task> list) {
        try {
            //check if there's something after the word 'event'
            String statement = line.substring(6);
            if (line.contains("/from") && line.contains("/to")) {
                list.add(Parser.parseToEvent(line));
                Printer.echoTask(list.get(list.size() - 1), list.size());
            } else {
                System.out.println("-".repeat(Printer.LINE_DASH_LENGTH));
                System.out.println("Please key in an Event task with both the keywords '/from' and '/to'");
                System.out.println("-".repeat(Printer.LINE_DASH_LENGTH));
            }
        } catch (IndexOutOfBoundsException e) { //take out the description without the category word
            Printer.eventError();
        }
    }

    public static void deleteTask(String line, ArrayList<Task> list) {
        String[] words = line.split(" ");
        try {
            int taskIndex = Integer.parseInt(words[1]);
            if (taskIndex <= list.size() && taskIndex > 0) {
                System.out.println("-".repeat(Printer.LINE_DASH_LENGTH));
                System.out.println("Okais. I have removed this task:");
                System.out.println(" " + list.get(taskIndex - 1).toString());
                System.out.println("Now you have " + (list.size() - 1) + " left in the list.");
                System.out.println("-".repeat(Printer.LINE_DASH_LENGTH));
                list.remove(taskIndex - 1);
            } else {
                System.out.println("-".repeat(Printer.LINE_DASH_LENGTH));
                System.out.println("You only have " + list.size() + " task(s) left. Please key in a smaller number");
                System.out.println("-".repeat(Printer.LINE_DASH_LENGTH));
            }
        } catch (IndexOutOfBoundsException e) { //no index for deleting function
            Printer.deleteError();
        }
    }

    public static void findKeywordInTask(String line, ArrayList<Task> list) {
        try {
            ArrayList<Task> tasksWithKeyword = new ArrayList<>();
            String keyword = Parser.findKeyword(line);
            for (Task task: list) {
                if (task.getDescription().contains(keyword)) {
                    tasksWithKeyword.add(task);
                }
            }
            Printer.printList(tasksWithKeyword);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("-".repeat(Printer.LINE_DASH_LENGTH));
            System.out.println("You are finding emptiness. Please input it with a keyword");
            System.out.println("-".repeat(Printer.LINE_DASH_LENGTH));
        }
    }
}
