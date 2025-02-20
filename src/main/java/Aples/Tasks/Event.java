package Aples.Tasks;

public class Event extends Task{
    protected String start;
    protected String end;

    public Event(String task, String start, String end) {
        super(task);
        this.start = start;
        this.end = end;
    }

    public String getEnd() {
        return end;
    }

    public String getStart() {
        return start;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(from: " + start + "to: " + end + ")";
    }
}
