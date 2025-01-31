import java.util.Scanner;

public class Main {
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < 2 * N - 1; i++) {
            for (int j = 0; j < Math.abs(i - (N - 1)); j++) {
                System.out.print(" ");
            }
            for (int s = 0; s < N - Math.abs(i - (N - 1)); s++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}