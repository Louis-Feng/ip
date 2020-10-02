import java.util.ArrayList;
/** Delete class is the subclass of Command class
 * its main method is to delete one task from the arrayList task*/
public class Delete extends Command {
    public int taskNumberdeleted;
    /** constructor*/
    public Delete(String command,ArrayList<Task> task){
        super(command,task);


    }
    //implement method to delete a task
    public ArrayList<Task> performCommand(){
        int taskNumberdeleted = Integer.parseInt(this.command.replaceAll("\\D+", "")) - 1;
        task.remove(taskNumberdeleted); //remove that task from arrayList
        return super.task;

    }
}
