import java.util.*;
public class calculator {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        String ch = sc.next();

        switch(ch){
            case "a": System.out.println(a+b);
                        break;
            case "b": System.out.println(a-b);
                        break;  
            case "c": System.out.println(a*b);
                        break;
            case "d": System.out.println(a/b);
                        break;
            case "e": System.out.println(a%b);
                        break;
            default: System.out.println("invalid char");
                        break;
        }

    }
    
}
