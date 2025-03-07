package Aples.Tasks;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Parser {

    //parse the String to be then created into a new Deadline task
    public static Deadline parseToDeadline(String line) {
        int byPosition = line.indexOf("/by");
        String description = line.substring(9, byPosition).trim();
        String deadlineString = line.substring(byPosition + 4).trim();

        LocalDateTime deadline;
        try {
            deadline = LocalDateTime.parse(deadlineString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Use yyyy-MM-dd HH:mm");
        }
        return new Deadline(description, deadline);
    }

    //parse the String to be then created into a new Event task
    public static Event parseToEvent(String line) {
        int fromPosition = line.indexOf("/from");
        int toPosition = line.indexOf("/to");
        String description = line.substring(6, fromPosition);
        String startTime = line.substring(fromPosition + 6, toPosition);
        String endTime = line.substring(toPosition + 4);
        return new Event(description, startTime, endTime);
    }

    public static String findKeyword(String line) {
        String[] words = line.split(" ");
        return words[1];
    }



}
