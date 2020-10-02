
/* import libraries*/
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.util.*;
/** FinalLevel class which contains all the methods needed */
public class FinalLevel {
    public static String input; //input is for each statement input
    public static ArrayList<Task> task = new ArrayList<Task>(); // create an arrayList to store tasks
    public static File data = new File("duke.txt"); //Create file object

    public static FileOutputStream fos;
    /* load data from txt file*/
    static {
        try {
            fos = new FileOutputStream(data,true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Scanner in = new Scanner(System.in);
    public static FileInputStream fis;

    static {
        try {
            fis = new FileInputStream(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Scanner sc=new Scanner(fis);

    public static void main(String[] args) throws IOException {
        if(data.exists()==false){
            data.createNewFile();
        }
        greet(); // call greet() method to greet
        input = getNextStatement(); // get the input statement to execute.
        /* mainly to execute input statements*/
        while(!input.equals("bye")){ //if input is not "bye"
            try {
                /** print the list of tasks*/
                if (input.equals("list")) {
                    System.out.println("____________________________________________________________\n");
                    List list = new List(input,task); //create a new List object
                    task = list.performCommand(); //call performCommand() on list
                    System.out.println("____________________________________________________________\n");
                }
                /** mark one task as done */
                else if (input.startsWith("done")) {
                    System.out.println("____________________________________________________________\n");
                    int taskNumberCompleted = Integer.parseInt(input.replaceAll("\\D+", "")) - 1; //find the corresponding index of done task
                    Done done = new Done(input,task); //create a new Done object
                    task = done.performCommand();   //call performCommand on done
                    System.out.println(" Nice! I've marked this task as done:");
                    System.out.println(" " + task.get(taskNumberCompleted));
                    System.out.println("____________________________________________________________\n");
                }
                /** delete one task */
                else if (input.startsWith("delete")) {
                    System.out.println("____________________________________________________________\n");
                    System.out.println("Noted. I've removed this task:  ");
                    int taskNumberdeleted = Integer.parseInt(input.replaceAll("\\D+", "")) - 1; //find the corresponding index of task to be deleted
                    System.out.println(" " + "[" + task.get(taskNumberdeleted).getStatusIcon() + "] " + task.get(taskNumberdeleted).description);
                    Delete delete = new Delete(input,task);//create a new Delete object
                    task = delete.performCommand(); //call performCommand on delete
                    System.out.println("Now you have " + task.size() + " tasks in the list. ");
                    System.out.println("____________________________________________________________\n");}
                /** to find tasks containing a certain keyword*/
                else if (input.startsWith("find")){
                    System.out.println("____________________________________________________________\n");
                    System.out.println("Here are the matching tasks in your list:\n");
                    Find find = new Find(input,task);   //create a new Find object
                    task = find.performCommand(); //call performCommand on find
                    System.out.println("____________________________________________________________\n");
                }
                /** add a todo task*/
                else if (input.startsWith("todo")) {
                    Todo todo = new Todo(input); // create a todo object
                    task.add(todo); // add it to the arrayList
                    System.out.println("____________________________________________________________\n");
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("   " + todo.toString());
                    System.out.println("Now you have " + task.size() + " tasks in the list. ");
                    System.out.println("____________________________________________________________\n");
                }
                /** add a deadline task*/
                else if (input.startsWith("deadline")) {
                    String descriptionOfDeadline;
                    String by;
                    descriptionOfDeadline = input.substring(9, (input.indexOf("/") - 1)); //get content of deadline description
                    by = input.substring((input.indexOf("/") + 4)); //get time of event
                    Deadline ddl = new Deadline(descriptionOfDeadline, by); //create a new deadline object with description and time
                    task.add(ddl); // add to task arrayList
                    System.out.println("____________________________________________________________\n");
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("   " + ddl.toString());
                    System.out.println("Now you have " + task.size() + " tasks in the list. ");
                    System.out.println("____________________________________________________________\n");
                }
                /** add an event task*/
                else if (input.startsWith("event")) {
                    String descriptionOfevent;
                    String at;
                    descriptionOfevent = input.substring(6, (input.indexOf("/") - 1)); //get content of event description
                    at = input.substring((input.indexOf("/") + 4)); //get time of event
                    Event event = new Event(descriptionOfevent, at); //create a new event object with description and time
                    task.add(event); // add to task arrayList
                    System.out.println("____________________________________________________________\n");
                    System.out.println("Got it. I've added this task: ");
                    System.out.println("   " + event.toString());
                    System.out.println("Now you have " + task.size() + " tasks in the list. ");
                    System.out.println("____________________________________________________________\n");
                }
                else{ //dealing with undefined type of input
                    System.out.println("____________________________________________________________\n");
                    System.out.println("  OOPS!!! I'm sorry, but I don't know what that means :-(\n");
                    System.out.println("____________________________________________________________\n");
                }
            /*exception handling of wrong input*/
            }catch (Exception e){
                if(input.equals("todo")) //wrong format of todo statement
                {   System.out.println("____________________________________________________________\n");
                    System.out.println(" OOPS!!! The description of a todo cannot be empty.");
                    System.out.println("____________________________________________________________\n");
                }
                if(input.equals("deadline")) //wrong format of deadline statement
                {   System.out.println("____________________________________________________________\n");
                    System.out.println(" OOPS!!! The description of a deadline cannot be empty.");
                    System.out.println("____________________________________________________________\n");
                }
                if(input.equals("event")) //wrong format of event statement
                {   System.out.println("____________________________________________________________\n");
                    System.out.println(" OOPS!!! The description of a event cannot be empty.");
                    System.out.println("____________________________________________________________\n");
                }


            }

            input = getNextStatement(); // get next input statement

        }
        write(task,data); //call write method to write list into txt file.
        bye(); // call bye() method to say bye
    }

    /** method to write the list into a text file after "bye" statement*/
    public static void write(ArrayList<Task> task, File data) throws IOException {
        FileWriter writer = new FileWriter(data,false); //set append attribute to true so that it won't overwrite the file.
        for (int i = 0; i < task.size(); i++) {
            if(task.get(i) instanceof Deadline){

                writer.write("deadline " +(task.get(i)).toString() + "\n"); // print a deadline task
            }
            if(task.get(i) instanceof Event){
                writer.write("event " + (task.get(i)).toString() + "\n"); // print an event task
            }
            if(task.get(i) instanceof Todo){
                writer.write("todo " + (task.get(i)).toString() + "\n"); // print a todo task.
            }

        }
        writer.close(); // finish writing
    }
    /** method to get next input statement from txt file or input stream*/
    public static String getNextStatement(){
        if(sc.hasNextLine()){ //if can read input statement from txt file
            input=sc.nextLine();
            if(input.startsWith("todo")){
                input = "todo " + input.substring(12); // manipulate todo statement
            }
            if(input.startsWith("deadline")){
                input = "deadline " + input.substring(16,(input.indexOf("(") )) + "/ by" + input.substring(input.indexOf(":")+2,input.indexOf(")"));//manipulate deadline statement
            }
            if(input.startsWith("event")){
                input = "event " + input.substring(13,(input.indexOf("(") )) + "/ by" + input.substring(input.indexOf(":")+2,input.indexOf(")")); //manipulate event statement
            }
        }
        else {
            input=in.nextLine(); //get input statement from user input
        }
        return input;
    }
    /** method to greet*/
    public static void greet(){
        System.out.println("____________________________________________________________\n");
        System.out.println(" Hello! I'm Duke\n");
        System.out.println(" What can I do for you?\n");
        System.out.println("____________________________________________________________\n");
    }
    /** method to say bye*/
    public static void bye(){
        System.out.println("____________________________________________________________\n");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________\n");
    }
}
