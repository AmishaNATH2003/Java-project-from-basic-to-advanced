import java.util.*;
public class guessNumber {
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        int randomNumber=(int)(Math.random()*100)+1;
        int guess=0;
        System.out.println("Welcom to the Guess game!");
        while(guess!=randomNumber){
            System.out.println("Enter Guess the");
            guess=sc.nextInt();
            if(guess==randomNumber){
                System.out.println("Congratualtion Guess is correct");
            }else if(guess<randomNumber){
                System.out.println("Your guess is to low");
            }else{
                System.out.println("Your guess is to high");
            }
        }
        
    }
}
