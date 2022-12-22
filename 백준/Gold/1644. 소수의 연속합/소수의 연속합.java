
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static boolean[] isPrime;
    static ArrayList<Integer> data = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int answer = 0;
        isPrime = new boolean[N + 1];
        eratos(N);

        for (int i = 0; i < data.size(); i++) {
            int number = 0;
            for (int j = i; j < data.size(); j++) {
                number += data.get(j);
                if (number > N) {
                    break;
                } else if (number == N) {
                    answer += 1;
                }
            }
        }
        
        System.out.println(answer);
    }

    static void eratos(int n) {
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i*i <= n; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        for(int i=0; i<=n; i++){
            if(!isPrime[i]){
                data.add(i);
            }
        }
    }
}
