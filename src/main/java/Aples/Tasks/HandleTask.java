package Aples.Tasks;

import Aples.Print.Print;

import java.util.ArrayList;
import java.util.Scanner;

public class HandleTask {
    public static void handleTodoTask(String line, ArrayList<Task> list, int itemIndex) {
        try {
            String description = line.substring(5);
            //System.out.println("this is the desc:" + description);
            //list.set(itemIndex, new Todo(description));
            list.add(new Todo(description));
            Print.echoTask(list.get(list.size() - 1), list.size());
        } catch (IndexOutOfBoundsException e) { //take out the description without the category word
            Print.todoError();
        }
    }

    public static void handleDeadlineTask(String line, ArrayList<Task> list, int itemIndex) {
        try {
            //check if there's something after deadline
            String statement = line.substring(9);
            if (statement.contains("/by")) {
                int byPosition = line.indexOf("/by");
                String description = line.substring(9, byPosition);
                String deadline = line.substring(byPosition + 4);
                list.add(new Deadline(description, deadline));
                Print.echoTask(list.get(list.size() - 1), list.size());
            } else {
                System.out.println("-".repeat(Print.LINE_DASH_LENGTH));
                System.out.println("Please key in a Deadline task with the keyword '/by'");
                System.out.println("-".repeat(Print.LINE_DASH_LENGTH));
                String newLine;
                Scanner in = new Scanner(System.in);
                newLine = in.nextLine();
                handleDeadlineTask(newLine, list, itemIndex);
            }
        } catch (IndexOutOfBoundsException e) { //take out the description without the category word
            Print.deadlineError();
        }
    }

    public static void handleEventTask(String line, ArrayList<Task> list, int itemIndex) {
        if (line.contains("/from") && line.contains("/to")) {
            int fromPosition = line.indexOf("/from");
            int toPosition = line.indexOf("/to");
            String description = line.substring(6, fromPosition);
            String startTime = line.substring(fromPosition + 6, toPosition);
            String endTime = line.substring(toPosition + 4);
            list.add(new Event(description, startTime, endTime));
            Print.echoTask(list.get(list.size() - 1), list.size());
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

    public static void deleteTask(String line, ArrayList<Task> list) {
        String[] words = line.split(" ");
        int taskIndex = Integer.parseInt(words[1]);
        System.out.println("-".repeat(Print.LINE_DASH_LENGTH));
        System.out.println("Okais. I have removed this task:");
        System.out.println(" " + list.get(taskIndex - 1).toString());
        System.out.println("Now you have " + (list.size() - 1) + " left in the list.");
        System.out.println("-".repeat(Print.LINE_DASH_LENGTH));
        list.remove(taskIndex - 1);
    }
}
