package Aples.Tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{
    protected LocalDateTime by;
    public Deadline(String task, LocalDateTime by) {
        super(task);
        this.by = by;
    }

    public void setBy(LocalDateTime by) {
        this.by = by;
    }

    public LocalDateTime getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (do by: " + by.format(DateTimeFormatter.ofPattern("MMM d yyyy HH:mm")) + ")";
    }
}
