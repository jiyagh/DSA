package loops;

import java.util.*;



public class fact {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int fact=1;
        if(n>0){
            for(int i=1; i<=n; i++){
                fact=fact*i;
            }
        } else{
            fact=1;
        }
        System.out.println("Factorial is: " +fact);
    }
}
