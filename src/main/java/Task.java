public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String task) {
        this.description = task;
    }

    public String getDescription() {
        return description;
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

    @Override
    public String toString() {
        return getSign() + description;
    }

}
