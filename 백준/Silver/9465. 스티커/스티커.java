
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for(int i=0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] data = new int[2][n+1];
            int[][] dp = new int[2][n+1];
            for(int j=0; j<2; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=1; k<=n; k++){
                    data[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            // 0 50
            // 0 30
            dp[0][1] = data[0][1];
            dp[1][1] = data[1][1];
            for(int k=2; k<=n; k++){
                dp[0][k] = Math.max(dp[1][k-1], dp[1][k-2]) + data[0][k];
                dp[1][k] = Math.max(dp[0][k-1], dp[0][k-2]) + data[1][k];
            }
            System.out.println(Math.max(dp[0][n],dp[1][n]));
        }

    }
}
