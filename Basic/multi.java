package loops;

import java.util.Scanner;

public class multi {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=10;i++){
            
            System.out.print(i+"*");
            System.out.print(n+"=");
            System.out.print(i*n);
            System.out.println();
        }
    }
}
