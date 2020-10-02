import java.util.ArrayList;
/** List class is the subclass of Command class
 * its main method is to iterate the whole task ArrayList to print out every statement*/
public class List extends Command {
    /** constructor*/
    public List(String command,ArrayList<Task> task){
        super(command,task);

    }
    //implement method to print all tasks
    public ArrayList<Task> performCommand() {
        for (int i = 0; i < task.size(); i++) {
            if (task.get(i) instanceof Deadline) {
                System.out.println((i + 1) + ":" + (Deadline) task.get(i)); // print deadline task in its format
            }
            if (task.get(i) instanceof Event) {
                System.out.println((i + 1) + ":" + (Event) task.get(i)); // print event task in its format
            }
            if (task.get(i) instanceof Todo) {
                System.out.println((i + 1) + ":" + (Todo) task.get(i)); // print todo task in its format
            }

        }
        return task;
    }
}
