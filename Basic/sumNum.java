import java.util.*;

public class sumNum {
    public static int sum(int n){
        int sum=0;
        while(n>0){
            int rem=n%10;
            sum=sum+rem;
            n=n/10;
        }
        return sum;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(sum(n));
    }
}
