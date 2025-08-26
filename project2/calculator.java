
import java.util.Scanner;

public class calculator {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);  
        System.out.print("Enter first number: ");
        double nums1= sc.nextDouble();
        System.out.print("Enter what opression you want to perform(+, -, *, /):");
        char op=sc.next().charAt(0);
        System.out.print("Enter second number:");
        double nums2=sc.nextDouble();
        switch(op){
            case '+':
            System.out.println("Result:" + (nums1+nums2));
            break;
            case '-':
            System.out.println("Result: " + (nums1-nums2));
            break;
            case '*':
            System.out.println("Result: " +(nums1*nums2));
            break;
            case '/':
            if(nums2!=0){
                System.out.println("result: " +(nums1/nums2));
            }else{
                System.out.println("There are error! because its dvided by 0");
            }
        }
    }
  
}
