import java.util.ArrayList;
/** Done class is the subclass of Command class
 * its main method is to mark one task as done*/
public class Done extends Command {
    public int taskNumberCompleted;
    /** constructor*/
    public Done(String command,ArrayList<Task> task){
        super(command,task);


    }
    //implement method to mark a task as done
    public ArrayList<Task> performCommand(){
        int taskNumberCompleted = Integer.parseInt(this.command.replaceAll("\\D+", "")) - 1; //find the corresponding index of done task
        task.set(taskNumberCompleted, task.get(taskNumberCompleted).completeTask());// set the corresponding task as done
        return super.task; //return task ArrayList after setting corresponding task to done

    }

}
