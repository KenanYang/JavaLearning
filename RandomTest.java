import java.util.Random;


public class RandomTest{
    public static void main(String[] args){
        // method 1
        Random rand = new Random();
        int number = rand.nextInt(2);  // Generate a number which is either 0 or 1
        System.out.printf("%d\n", number);
        // method 2
        int number2 = (int)(Math.random() * 2);
        System.out.printf("%d\n", number2);
    }
}
