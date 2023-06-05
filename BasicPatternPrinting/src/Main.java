import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int numRows = scanner.nextInt();
        String output = "";

        if(numRows > 0) {
            for (int i = 0; i < numRows; i++) {
                output += "*";
                System.out.println(output);
            }
        }
    }
}
