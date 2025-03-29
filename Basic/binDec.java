import java.util.*;

public class binDec {
    
    public static int bin(int a){
        int bin=0;
        int count=0;
        while(a>0){
            int rem=a%10;
            bin=bin+(rem*(int)(Math.pow(2,count)));
            count++;  
            a=a/10; 
        }
        return bin;

    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(bin(n));
    }
}
