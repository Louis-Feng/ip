import java.util.ArrayList;
/**
 * Represents a Delete which extends Command class. A <code>Delete</code> object corresponds to
 * a Delete represented by a String and a list of Tasks
 */
public class Done extends Command {
    public int taskNumberCompleted;
    /** constructor*/
    public Done(String command,ArrayList<Task> task){
        super(command,task);


    }
    /**
     * implements performCommand() to mark a task from ArrayList<Task> as done
     * @return ArrayList<Task> an ArrayList of Tasks.
     */
    public ArrayList<Task> performCommand(){
        int taskNumberCompleted = Integer.parseInt(this.command.replaceAll("\\D+", "")) - 1; //find the corresponding index of done task
        task.set(taskNumberCompleted, task.get(taskNumberCompleted).completeTask());// set the corresponding task as done
        return super.task; //return task ArrayList after setting corresponding task to done

    }

}
