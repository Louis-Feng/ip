import java.util.ArrayList;
/** parent class */
public abstract class Command {

    public String command;
    public ArrayList<Task> task;
    /** constructor*/
    public Command(String command,ArrayList<Task> task) {
        this.command = command;
        this.task = task;
    }


    //abstract method for all its subclass to implement
    public abstract ArrayList<Task> performCommand();
}