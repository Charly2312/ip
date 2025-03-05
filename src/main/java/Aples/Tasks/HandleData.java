package Aples.Tasks;
import Aples.Print.Print;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

import Aples.Tasks.Deadline.*;

public class HandleData {
    static String filePath = "aples.txt";

    public static void updateFile(ArrayList<Task> list) throws FileNotFoundException, IOException {
        try { //overwriting the file
            FileWriter f = new FileWriter(filePath); // create a File for the given file path
            int count = 0;
            for (Task task : list) {
                if (task.isDone) {
                    if (task.getClass() == Todo.class) {
                        f.write("T|1|"+task.getDescription()+"\n");
                    } else if (task.getClass() == Deadline.class) {
                        f.write("D|1|"+task.getDescription()+"|"+((Deadline) task).getBy()+"\n");
                    } else {
                        f.write("E|1|"+task.getDescription()+"|"+((Event) task).getStart()+"|"+((Event) task).getEnd()+"\n");
                    }
                }
                else {
                    if (task.getClass() == Todo.class) {
                        f.write("T|0|"+task.getDescription()+"\n");
                    } else if (task.getClass() == Deadline.class) {
                        f.write("D|0|"+task.getDescription()+"|"+((Deadline) task).getBy()+"\n");
                    } else {
                        f.write("E|0|"+task.getDescription()+"|"+((Event) task).getStart()+"|"+((Event) task).getEnd()+"\n");
                    }
                }
                count++;
            }
            f.close();
            System.out.println("-".repeat(Print.LINE_DASH_LENGTH));
            System.out.println("File updated successfully!");
            System.out.println("-".repeat(Print.LINE_DASH_LENGTH));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public static void printFileContents() throws FileNotFoundException {
        try {
            File f = new File(filePath); // create a File for the given file path
            Scanner s = new Scanner(f); // create a Scanner using the File as the source
            while (s.hasNext()) {
                System.out.println(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }
    }

    public static void parseIntolist(File file, ArrayList<Task> list) throws FileNotFoundException {
        try {
            // create a Scanner using the File as the source
            Scanner s = new Scanner(file);
            while (s.hasNext()) {
                String taskFromFile = s.nextLine();
                String[] words = taskFromFile.split("\\|");

                if (words.length < 3) {
                    System.out.println("Skipping invalid task: " + taskFromFile);
                    continue; //move on to the next task
                }

                if (words[0].equals("T")) {
                    list.add(new Todo(words[2]));
                    if (words[1].equals("1")) {
                        list.get(list.size() - 1).markDone();
                    } else {
                        list.get(list.size() - 1).markNotDone();
                    }
                } else if (words[0].equals("D")) {
                    String[] deadlineArray = words[3].split("T");
                    String deadline = deadlineArray[0] + " " + deadlineArray[1];
                    list.add(new Deadline(words[2], LocalDateTime.parse(deadline, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));
                    if (words[1].equals("1")) {
                        list.get(list.size() - 1).markDone();
                    } else {
                        list.get(list.size() - 1).markNotDone();
                    }
                } else {
                    list.add(new Event(words[2], words[3], words[4]));
                    if (words[1].equals("1")) {
                        list.get(list.size() - 1).markDone();
                    } else {
                        list.get(list.size() - 1).markNotDone();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File " + filePath + "cannot be read");
        }
    }

    public static void copyContents(ArrayList<Task> list) throws FileNotFoundException {
        File f = new File(filePath);
        if (f.exists() && !f.isDirectory()) { // check if a file exists
            File file = new File(filePath); // create a File for the given file path
            parseIntolist(file, list);
        } else { // if file does not exist, then we create a new file with that name
            try {
                File file = new File(filePath);
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("File " + filePath + " cannot be created!");
            }
        }
    }


}
