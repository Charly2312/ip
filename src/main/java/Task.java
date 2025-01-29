public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String task) {
        this.description = task;
        this.isDone = false;
    }

    public void markDone() {
        this.isDone = true;
    }

    public void markNotDone() {
        this.isDone = false;
    }

    public String getSign() {
        return (isDone ? "[X] " : "[ ] ");
    }

    public String getDescription() {
        return description;
    }
}
