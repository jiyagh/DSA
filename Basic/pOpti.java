import java.util.*;
// import java.math;

public class pOpti {
    public static boolean isPrime(int n){
        boolean p=true;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                p=false;
                break;
            }
        }
        return p;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(isPrime(n));

    }
    
}
