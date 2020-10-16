import java.util.ArrayList;
/**
 * Represents a Delete which extends Command class. A <code>Delete</code> object corresponds to
 * a Delete represented by a String and a list of Tasks
 */
public class Delete extends Command {
    public int taskNumberdeleted;
    /** constructor*/
    public Delete(String command,ArrayList<Task> task){
        super(command,task);


    }
    /**
     * implements performCommand() to delete a task from ArrayList<Task></Task>
     * @return ArrayList<Task> an ArrayList of Tasks.
     */
    public ArrayList<Task> performCommand(){
        int taskNumberdeleted = Integer.parseInt(this.command.replaceAll("\\D+", "")) - 1;
        task.remove(taskNumberdeleted); //remove that task from arrayList
        return super.task;

    }
}
