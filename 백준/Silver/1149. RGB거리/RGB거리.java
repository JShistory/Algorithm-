
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N+1][3];
        int[][] dp = new int[N+1][3];


        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][0] = data[1][0];
        dp[1][1] = data[1][1];
        dp[1][2] = data[1][2];

        int answer = 0;
        for(int i=1; i<=N; i++){
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + data[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + data[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + data[i][2];
            answer = Arrays.stream(dp[i]).min().getAsInt();
        }
        System.out.println(answer);
    }
}
