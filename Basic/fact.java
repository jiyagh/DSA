
import java.util.*;

public class fact {
    public static int factorial (int a){
        int facto=1;
        if (a>0){
            for (int i=1; i<=a; i++){
                facto=facto*i;
            }
        }
        return facto;
    }

    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();

        System.out.println(factorial(n));
    }
}
