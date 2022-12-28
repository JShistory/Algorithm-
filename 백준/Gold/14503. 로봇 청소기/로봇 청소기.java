

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;


public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static StringTokenizer st;
    static int r,c,d,count,N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        count = 1;
        dfs(r,c,d);
        System.out.println(count);
    }

    static void dfs(int x, int y, int direction) {
        map[x][y] = -1;
   
        for(int i=0; i<4; i++){
            direction = (direction+3) % 4;
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if(nx >=0 && ny >=0 && nx < N && ny <M && map[nx][ny] == 0){
                count ++;
                dfs(nx,ny,direction);
                return;
            }
        }
        int back = (direction + 2 ) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];

        if(bx >=0 && by >=0 && bx <N && by<M && map[bx][by] != 1){
            dfs(bx,by,direction);
        }
    }
}
