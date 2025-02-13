package Aples.Tasks;

public class Deadline extends Task{
    protected String by;
    public Deadline(String task, String by) {
        super(task);
        this.by = by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(do by: " + by + ")";
    }
}
