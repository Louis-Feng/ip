import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
public class Level3 {
    public static void main(String[] args){
        String input;
        ArrayList<Task> task = new ArrayList<Task>();
        Scanner in = new Scanner(System.in);
        System.out.println("____________________________________________________________\n");
        System.out.println(" Hello! I'm Duke\n");
        System.out.println(" What can I do for you?\n");
        System.out.println("____________________________________________________________\n");
        input=in.nextLine();
        while(!input.equals("bye")){
            if(input.equals("list")){
                System.out.println("____________________________________________________________\n");
                for (int i = 0; i < task.size(); i++) {

                    System.out.println((i+1)+":"+"["+task.get(i).getStatusIcon()+"] "+task.get(i).description);
                }
                System.out.println("____________________________________________________________\n");
            }
            else if(input.startsWith("done")){
                System.out.println("____________________________________________________________\n");
                int taskNumberCompleted = Integer.parseInt(input.replaceAll("\\D+",""))-1;
                task.set(taskNumberCompleted,task.get(taskNumberCompleted).completeTask());
                System.out.println(" Nice! I've marked this task as done:");
                System.out.println(" "+":"+"["+task.get(taskNumberCompleted).getStatusIcon()+"] "+task.get(taskNumberCompleted).description);
                System.out.println("____________________________________________________________\n");}
            else{
                task.add(new Task(input));
                System.out.println("____________________________________________________________\n");
                System.out.println("added:" + input);
                System.out.println("____________________________________________________________\n");


            }
            input=in.nextLine();

        }
        System.out.println("____________________________________________________________\n");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________\n");
    }
}
