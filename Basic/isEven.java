import java.util.*;

public class isEven {
    public static boolean isEven(int a){
        if(a%2==0){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(isEven(n));
    }
}
