import java.util.*;

public class binoco {
    public static int factorial (int a){
        int facto=1;
        if (a>0){
            for (int i=1; i<=a; i++){
                facto=facto*i;
            }
        }
        return facto;
    }

    public static int bino(int n, int r){
        int bin=factorial(n)/(factorial(r)*factorial(n-r));
        return bin;
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int r=sc.nextInt();
        System.out.println(bino(n,r));
    }
}
