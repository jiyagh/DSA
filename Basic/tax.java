import java.util.*;

public class tax {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter salary in lakhs");
        float income=sc.nextFloat();
        float tax;
        if(income<5){
            tax=0;
            System.out.println("No tax paid");
        } 
        else if(income<10 && income>=5){
            tax=income*20/100;
            System.out.println("Tax paid is:" +tax);
        }
        else{
            tax=income*30/100;
            System.out.println("Tax paid is: " +tax);
        }
    }
}
