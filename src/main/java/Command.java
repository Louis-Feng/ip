import java.util.ArrayList;
/**
 * Represents a command. A <code>Command</code> object corresponds to
 * a command represented by a String and a task object
 */
public abstract class Command {

    public String command;
    public ArrayList<Task> task;
    public Command(String command,ArrayList<Task> task) {
        this.command = command;
        this.task = task;
    }


    /**
     * define an abstract method performCommand()
     *
     * @return ArrayList<Task> an ArrayList of Tasks.
     */
    public abstract ArrayList<Task> performCommand();
}