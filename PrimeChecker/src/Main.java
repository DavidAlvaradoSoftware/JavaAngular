import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        boolean isPrime = isNumberPrime(number);

        // Check if the number is prime

        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }

    // A prime number is a number that is greater than 1,
    // and is only divisible by 1 and itself.
    private static boolean isNumberPrime(int num){
        // base cases:
        //      1, 0, and negative numbers are not prime.
        if(num <= 1) return false;
        //      2 is prime, and is the ONLY even prime number.
        if(num == 2) return true;

        // 2 is the only even prime number, and all even numbers are divisible by 2.
        // We will check if the number entered by user is divisible by 2.
        if(num % 2 == 0) return false;

        // Up until this point, if none of the base cases forced the method to return
        // we will brute force the answer.
        // we will iterate through all ODD numbers since we already checked if it was even.
        // the limit of the for loop will be the square root of the number. This is because
        // the square root is roughly the middle number of the ordered set of multiples of a given number.
        // 16 => [1,2,4,8,16]
        for(int i = 3; i < Math.sqrt(num); i+=2){
            if (num % i == 0) return false;
        }

        return true;
    }
}
