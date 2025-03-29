import java.util.*;

public class palindrome {
    public static boolean pali (int n){
        boolean p=true;
        int rev=n;
        int num=0;
        int count=0;
        while(rev>0){
            int rem=rev%10;
            num=rem+(num*10);
            count++;
            rev=rev/10;
        }
        if(n==num){
            p=true;
        } else {
            p=false;
        }
        return p;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(pali(n));
    }
}
