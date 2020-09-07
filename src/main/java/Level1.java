
import java.util.Scanner;
import java.util.*;
public class Level1 {
    public static void main(String[] args){
        String input;
        Scanner in = new Scanner(System.in);
        System.out.println("____________________________________________________________\n");
        System.out.println(" Hello! I'm Duke\n");
        System.out.println(" What can I do for you?\n");
        System.out.println("____________________________________________________________\n");
        System.out.println(" Bye. Hope to see you again soon!\n");
        System.out.println("____________________________________________________________\n");
        input=in.nextLine();
        while(!input.equals("bye")){
            if(input.equals("list")){
                System.out.println("____________________________________________________________\n");
                System.out.println("list");
                System.out.println("____________________________________________________________\n");

            }
            else if(input.equals("blah")){
                System.out.println("____________________________________________________________\n");
                System.out.println("blah");
                System.out.println("____________________________________________________________\n");
            }
            input=in.nextLine();

        }
        System.out.println("____________________________________________________________\n");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________\n");
    }
}
