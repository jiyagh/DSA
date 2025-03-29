import java.util.*;

public class printPrime {
    public static boolean isPrime(int n){
        boolean p = true;
        for(int i=2; i<=Math.sqrt(n);i++){
            if(n%i==0){
                p=false;
                break;
            }

        }
        return p;

    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
            for(int i=a; i<=b; i++){
                if(isPrime(i)==true){
                    System.out.println(i);
                } else{
                    continue;
                }
            }
        
    }
    
}
