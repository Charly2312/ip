package Aples.Tasks;

public class Parser {

    public static Deadline parseToDeadline(String line) {
        int byPosition = line.indexOf("/by");
        String description = line.substring(9, byPosition);
        String deadline = line.substring(byPosition + 4);
        return new Deadline(description, deadline);
    }

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
