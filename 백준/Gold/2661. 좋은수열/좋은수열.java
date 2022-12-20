import java.util.Scanner;

public class Main {
    static int N;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        backtracking("");

    }

    static void backtracking(String str) {
        if (str.length() == N) {
            System.out.println(str);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if (isGood(str + i)) {
                backtracking(str + i);
            }
        }
    }

    static boolean isGood(String str) {
        int size = str.length();

        for (int i = 1; i <= size/2; i++) {
            String check_1 = str.substring(str.length() - i - i, str.length() - i);
            String check_2 = str.substring(str.length() - i, str.length());
            if (check_1.equals(check_2)) {
                return false;
            }
        }
        return true;
    }
}
