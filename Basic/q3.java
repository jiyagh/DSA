import java.util.*;

public class q3{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        float pencilCost= sc.nextFloat();
        float penCost= sc.nextFloat();
        float eraserCost= sc.nextFloat();

        float totalCost= pencilCost+penCost+eraserCost;
        float gst= totalCost*18/100;

        System.out.println("total cost="+totalCost); 
        System.out.println("and GST="+gst);
 
    }
}