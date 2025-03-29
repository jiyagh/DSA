import java.util.*;

public class decBin {
    public static int dec (int a){
        int dec=0;
        int count=0;
        while(a>0){
            int rem=a%2;
            dec=dec+(rem*(int)Math.pow(10, count));
            count++;
            a=a/2;
        }
        return dec;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(dec(n));
    }
}
