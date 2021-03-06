/**
 * Represents a Task . A <code>Task</code> object corresponds to
 * a Task represented by a String and a boolean value
 */
public class Task {
    protected String description;
    protected boolean isDone;


    public Task(String description) {
        this.description = description;
        this.isDone = false;

    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }
    public Task completeTask() {
        this.isDone = true;
        return this;
    }

    @Override
    public String toString(){
        return "[" + this.getStatusIcon()+ "] " + this.description;
    }
}