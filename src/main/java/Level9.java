/** Level 9 class which contains all the methods needed */
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class Level9 {
    public static void main(String[] args) throws IOException {
        String input;
        ArrayList<Task> task = new ArrayList<Task>();
        File data = new File("D:\\ip\\src\\main\\data\\duke.txt");
        FileOutputStream fos = new FileOutputStream(data,true);


        Scanner in = new Scanner(System.in);
        FileInputStream fis=new FileInputStream(data);
        Scanner sc=new Scanner(fis);


        System.out.println("____________________________________________________________\n");
        System.out.println(" Hello! I'm Duke\n");
        System.out.println(" What can I do for you?\n");
        System.out.println("____________________________________________________________\n");
        if(sc.hasNextLine()){
            input=sc.nextLine();
            if(input.startsWith("todo")){
                input = "todo " + input.substring(11);
            }
            if(input.startsWith("deadline")){
                input = "deadline " + input.substring(16,(input.indexOf("(") )) + "/ by" + input.substring(input.indexOf(":")+2,input.indexOf(")"));
            }
            if(input.startsWith("event")){
                input = "event " + input.substring(13,(input.indexOf("(") )) + "/ by" + input.substring(input.indexOf(":")+2,input.indexOf(")"));
            }
        }
        else {
            input=in.nextLine();
        }
        while(!input.equals("bye")){
            try {
                if (input.equals("list")) {
                    System.out.println("____________________________________________________________\n");
                    for (int i = 0; i < task.size(); i++) {
                        if(task.get(i) instanceof Deadline){
                            System.out.println((i + 1) + ":"  + (Deadline)task.get(i));
                        }
                        if(task.get(i) instanceof Event){
                            System.out.println((i + 1) + ":"  + (Event)task.get(i));
                        }
                        if(task.get(i) instanceof Todo){
                            System.out.println((i + 1) + ":"  + (Todo)task.get(i));
                        }

                    }
                    System.out.println("____________________________________________________________\n");
                } else if (input.startsWith("done")) {
                    System.out.println("____________________________________________________________\n");
                    int taskNumberCompleted = Integer.parseInt(input.replaceAll("\\D+", "")) - 1;
                    task.set(taskNumberCompleted, task.get(taskNumberCompleted).completeTask());
                    System.out.println(" Nice! I've marked this task as done:");
                    System.out.println(" "  + "[" + task.get(taskNumberCompleted).getStatusIcon() + "] " + task.get(taskNumberCompleted).description);
                    System.out.println("____________________________________________________________\n");
                } else if (input.startsWith("todo")) {
                    Todo todo = new Todo(input);
                    task.add(todo);
                    System.out.println("____________________________________________________________\n");
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("   " + todo.toString());

                    System.out.println("Now you have " + task.size() + " tasks in the list. ");
                    System.out.println("____________________________________________________________\n");
                }
                else if (input.startsWith("delete")) {
                    System.out.println("____________________________________________________________\n");
                    System.out.println("Noted. I've removed this task:  ");
                    int taskNumberdeleted = Integer.parseInt(input.replaceAll("\\D+", "")) - 1;
                    System.out.println(taskNumberdeleted);
                    System.out.println(" " + "[" + task.get(taskNumberdeleted).getStatusIcon() + "] " + task.get(taskNumberdeleted).description);
                    task.remove(taskNumberdeleted);
                    System.out.println("Now you have " + task.size() + " tasks in the list. ");
                    System.out.println("____________________________________________________________\n");}
                else if (input.startsWith("find")){
                    System.out.println("____________________________________________________________\n");
                    System.out.println("Here are the matching tasks in your list:\n");
                    String keyword = input.substring(4);
                    int count = 1;
                    for(int i=0;i< task.size();i++){
                        if(task.get(i).description.contains(keyword)){

                            System.out.println(count +": " + task.get(i));
                            count ++;
                        }

                    }

                    System.out.println("____________________________________________________________\n");
                }
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

                    System.out.println("Now you have " + task.size() + " tasks in the list. ");
                    System.out.println("____________________________________________________________\n");
                }
                else if (input.startsWith("event")) {
                    String descriptionOfevent;
                    String at;
                    descriptionOfevent = input.substring(6, (input.indexOf("/") - 1));
                    at = input.substring((input.indexOf("/") + 4));
                    Event event = new Event(descriptionOfevent, at);
                    task.add(event);
                    System.out.println("____________________________________________________________\n");
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("   " + event.toString());

                    System.out.println("Now you have " + task.size() + " tasks in the list. ");
                    System.out.println("____________________________________________________________\n");
                }
                else{
                    System.out.println("____________________________________________________________\n");
                    System.out.println("  OOPS!!! I'm sorry, but I don't know what that means :-(\n");
                    System.out.println("____________________________________________________________\n");
                }
            }catch (Exception e){
                if(input.equals("todo"))
                {   System.out.println("____________________________________________________________\n");
                    System.out.println(" OOPS!!! The description of a todo cannot be empty.");
                    System.out.println("____________________________________________________________\n");
                }
                if(input.equals("deadline"))
                {   System.out.println("____________________________________________________________\n");
                    System.out.println(" OOPS!!! The description of a deadline cannot be empty.");
                    System.out.println("____________________________________________________________\n");
                }
                if(input.equals("event"))
                {   System.out.println("____________________________________________________________\n");
                    System.out.println(" OOPS!!! The description of a event cannot be empty.");
                    System.out.println("____________________________________________________________\n");
                }


            }

            if(sc.hasNextLine()){
                input=sc.nextLine();}
            else {
                input=in.nextLine();
            }

        }
        write(task,data); //call write method to write list into txt file.
        System.out.println("____________________________________________________________\n");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________\n");
    }

    /** method to write the list into a text file after "bye" statement*/
    public static void write(ArrayList<Task> task, File data) throws IOException {
        FileWriter writer = new FileWriter(data,true); //set append attribute to true so that it won't overwrite the file.
        writer.write("\n");
        for (int i = 0; i < task.size(); i++) {
            if(task.get(i) instanceof Deadline){
                writer.write("deadline " +(task.get(i)).toString() + "\n");}
            if(task.get(i) instanceof Event){
                writer.write("event " + (task.get(i)).toString() + "\n");}
            if(task.get(i) instanceof Todo){
                writer.write("todo " + (task.get(i)).toString() + "\n");}

        }
        writer.close();
    }
}
