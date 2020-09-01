import java.util.Scanner;
import java.util.ArrayList;
public class Level2 {
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
            if(!input.equals("list")){
            task.add(new Task(input));
            System.out.println("____________________________________________________________\n");
            System.out.println("added:" + input);
            System.out.println("____________________________________________________________\n");
            }
            else{
                System.out.println("____________________________________________________________\n");
                for (int i = 0; i < task.size(); i++) {

                    System.out.println((i+1)+":"+task.get(i).description);
                }
                System.out.println("____________________________________________________________\n");
            }
            input=in.nextLine();

        }
        System.out.println("____________________________________________________________\n");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________\n");
    }
}

