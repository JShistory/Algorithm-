
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x; //세로
        this.y = y; //가로
    }
}

public class Main {
    static StringTokenizer st;
    static int[][] data;
    static Queue<Point> tomato = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int day = 0;
    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        //가로
        m = Integer.parseInt(st.nextToken());
        //세로
        n = Integer.parseInt(st.nextToken());
        data = new int[n][m];
        //맵 생성
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if (data[i][j] == 1) {
                    tomato.add(new Point(i, j));
                }
            }
        }

        System.out.println(BFS());


    }

    static int BFS() {
        while (!tomato.isEmpty()) {

            day += 1;
            Point point = tomato.poll();
            int x = point.x;
            int y = point.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (data[nx][ny] == 0) {
                        data[nx][ny] = data[x][y] + 1;
                        tomato.add(new Point(nx, ny));
                    }
                }
            }
        }

        int day = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (data[i][j] == 0) {
                    return -1;
                }
                day = Math.max(day, data[i][j]);
            }
        }
        return day - 1;
    }
}
