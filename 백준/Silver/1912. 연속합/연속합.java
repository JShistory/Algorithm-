
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = data[0];
        int max = data[0];

        for (int i = 1; i < data.length; i++) {
            dp[i] = Math.max(dp[i - 1] + data[i], data[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);


    }
}
