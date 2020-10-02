import java.util.ArrayList;
/** Find class is the subclass of Command class
 * its main method is to find the occurrence of a keyword and print the task containing the keyword*/
public class Find extends Command {
    public String keyword;
    /** constructor*/
    public Find(String command,ArrayList<Task> task){
        super(command,task);


    }
    //implement method to find keywords
    public ArrayList<Task> performCommand(){
        keyword = this.command.substring(4); // to get the keyword string
        int count = 1;
        /*iterate the task arrayList to find corresponding items*/
        for(int i=0;i< task.size();i++){
            if(task.get(i).description.contains(keyword)){
                System.out.println(count +": " + task.get(i));
                count ++;
            }
        }
    return  task;
    }
}
