

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static boolean prime[];
    static List<Integer> data = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        prime = new boolean[2_000_001];
        eratos();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long number1 = Long.parseLong(st.nextToken());
            long number2 = Long.parseLong(st.nextToken());
            long sum = number1 + number2;

            if (sum < 4) {
                sb.append("NO\n");
            } else if (sum % 2 == 0) {
                sb.append("YES\n");
            } else {
                if (check(sum - 2)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb.toString());
    }

    static void eratos() {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= 2_000_000; i++) {
            if (!prime[i]) {
                data.add(i);
                for (int j = i * 2; j <= 2_000_000; j += i) {
                    prime[j] = true;
                }
            }
        }
    }

    static boolean check(long x) {
        if (x <= 2_000_000) {
            return !prime[(int) x];
        }

        for (int i = data.size()-1; i >= 0; i--) {
            if (x % data.get(i) == 0) {
                return false;
            }
        }

        return true;
    }
}
