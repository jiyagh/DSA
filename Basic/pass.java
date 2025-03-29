import java.util.*;

public class pass {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int marks=sc.nextInt();

        if (marks>=33){
            System.out.println("Pass");
        }
        else{
            System.out.println("Fail");
        }

        String result=(marks>=33)?"pass":"fail";

        System.out.println(result);

    }
}
