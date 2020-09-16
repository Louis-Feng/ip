import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
public class Level6 {
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
            try {
                if (input.equals("list")) {
                    System.out.println("____________________________________________________________\n");
                    for (int i = 0; i < task.size(); i++) {

                        System.out.println((i + 1) + ":" + "[" + task.get(i).getStatusIcon() + "] " + task.get(i).description);
                    }
                    System.out.println("____________________________________________________________\n");
                } else if (input.startsWith("done")) {
                    System.out.println("____________________________________________________________\n");
                    int taskNumberCompleted = Integer.parseInt(input.replaceAll("\\D+", "")) - 1;
                    task.set(taskNumberCompleted, task.get(taskNumberCompleted).completeTask());
                    System.out.println(" Nice! I've marked this task as done:");
                    System.out.println(" " + ":" + "[" + task.get(taskNumberCompleted).getStatusIcon() + "] " + task.get(taskNumberCompleted).description);
                    System.out.println("____________________________________________________________\n");
                } else if (input.startsWith("todo")) {
                    Todo todo = new Todo(input);
                    task.add(todo);
                    System.out.println("____________________________________________________________\n");
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("   " + todo.toString());

                    System.out.println("Now you have " + task.size() + " todo borrow booktasks in the list. ");
                    System.out.println("____________________________________________________________\n");



                }
                else if (input.startsWith("delete")) {
                    System.out.println("____________________________________________________________\n");
                    System.out.println("Noted. I've removed this task:  ");
                    int taskNumberdeleted = Integer.parseInt(input.replaceAll("\\D+", "")) - 1;
                    //System.out.println(taskNumberdeleted);
                    System.out.println(" " + "[" + task.get(taskNumberdeleted).getStatusIcon() + "] " + task.get(taskNumberdeleted).description);
                    task.remove(taskNumberdeleted);

                    System.out.println("Now you have " + task.size() + " todo borrow booktasks in the list. ");
                    System.out.println("____________________________________________________________\n");}
                else if (input.startsWith("deadline")) {
                    String descriptionOfDeadline;
                    String by;
                    descriptionOfDeadline = input.substring(9, (input.indexOf("/") - 1));
                    by = input.substring((input.indexOf("/") + 4));
                    Deadline ddl = new Deadline(descriptionOfDeadline, by);
                    task.add(ddl);
                    System.out.println("____________________________________________________________\n");
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("   " + ddl.toString());

                    System.out.println("Now you have " + task.size() + " todo borrow booktasks in the list. ");
                    System.out.println("____________________________________________________________\n");
                } else if (input.startsWith("event")) {
                    String descriptionOfevent;
                    String at;
                    descriptionOfevent = input.substring(6, (input.indexOf("/") - 1));
                    at = input.substring((input.indexOf("/") + 4));
                    Event event = new Event(descriptionOfevent, at);
                    task.add(event);
                    System.out.println("____________________________________________________________\n");
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("   " + event.toString());

                    System.out.println("Now you have " + task.size() + " todo borrow booktasks in the list. ");
                    System.out.println("____________________________________________________________\n");
                }
                else{
                    System.out.println("____________________________________________________________\n");
                    System.out.println(" ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n");
                    System.out.println("____________________________________________________________\n");
                }
            }catch (Exception e){
                if(input.equals("todo"))
                {   System.out.println("____________________________________________________________\n");
                    System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                    System.out.println("____________________________________________________________\n");
                }
                if(input.equals("deadline"))
                {   System.out.println("____________________________________________________________\n");
                    System.out.println("☹ OOPS!!! The description of a deadline cannot be empty.");
                    System.out.println("____________________________________________________________\n");
                }
                if(input.equals("event"))
                {   System.out.println("____________________________________________________________\n");
                    System.out.println("☹ OOPS!!! The description of a event cannot be empty.");
                    System.out.println("____________________________________________________________\n");
                }


            }

            input=in.nextLine();


        }
        System.out.println("____________________________________________________________\n");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________\n");
    }
}
