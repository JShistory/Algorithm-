
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;
    int z;

    Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {
    static StringTokenizer st;
    static int[][][] tomatoBox;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<Point> queue;
    static int M;
    static int N;
    static int H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        //가로,세로,높이
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomatoBox = new int[H][N][M];
        queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomatoBox[i][j][k] = Integer.parseInt(st.nextToken());
                    if (tomatoBox[i][j][k] == 1) {
                        queue.add(new Point(k, j, i));
                    }
                }
            }
        }

        System.out.println(BFS());

    }

    public static int BFS() {

        while (!queue.isEmpty()) {
            Point data = queue.poll();
            int x = data.x;
            int y = data.y;
            int z = data.z;
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < M && ny < N && nz < H) {
                    if (tomatoBox[nz][ny][nx] == 0) {
                        queue.add(new Point(nx, ny, nz));
                        tomatoBox[nz][ny][nx] = tomatoBox[z][y][x] + 1;
                    }
                }

            }
        }
        int date = Integer.MIN_VALUE;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomatoBox[i][j][k] == 0) {
                        return -1;
                    }
                    date = Math.max(date, tomatoBox[i][j][k]);
                }
            }
        }
        if (date == 1) {
            return 0;
        }
        return date-1;
    }
}
