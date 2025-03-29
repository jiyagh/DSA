import java.util.*;

public class prod{
    public static int multi(int a, int b){
        return a*b;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b= sc.nextInt();
        System.out.println(multi(a,b));
    }
}