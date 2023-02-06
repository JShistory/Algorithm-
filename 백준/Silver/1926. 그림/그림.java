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
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;
    static int size;
    static Queue<Point> data = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 1 && visited[i][j] == false){
                    data.add(new Point(i,j));
                    visited[i][j] = true;
                    BFS();
                    answer = Math.max(answer,size);

                    count +=1;

                }
            }
        }
        if(answer == Integer.MIN_VALUE){
            System.out.println("0");
            System.out.println("0");
        }
        else {
            System.out.println(count);
            System.out.println(answer);
        }



    }

    static int BFS() {
        size = 1;
        while (!data.isEmpty()) {
            Point temp = data.poll();
            int x = temp.x;
            int y = temp.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == 1 && visited[nx][ny] == false) {
                        visited[nx][ny] = true;
                        data.add(new Point(nx,ny));
                        size += 1;
                    }

                }
            }
        }
        return size;
    }
}
