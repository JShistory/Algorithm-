
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int N;
    static int[][] data;
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N];
        combi(0, 0);
        System.out.println(ans);
    }

    static void combi(int idx, int cnt) {
        if (cnt == N / 2) {
            score();
            return;
        }

        for (int i = idx; i < N; i++) {
            visited[i] = true;
            combi(i + 1, cnt + 1);
            visited[i] = false;
        }
    }

    static void score() {
        int start_team = 0;
        int link_team = 0;
        int tmp = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] == true && visited[j] == true) {
                    start_team += data[i][j];
                    start_team += data[j][i];
                } else if (visited[i] == false && visited[j] == false) {
                    link_team += data[i][j];
                    link_team += data[j][i];
                }
            }
        }
        tmp = Math.abs(start_team - link_team);
        if (tmp == 0) {
            System.out.println(tmp);
            System.exit(0);
        }
        ans = Math.min(ans, tmp);

    }
}
