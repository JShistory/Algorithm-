package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class _2583_BFS {
    static StringTokenizer st;
    static int[][] map;
    static boolean[][] visited;

    static int M;
    static int N;
    //상하좌우
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> data = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        visited = new boolean[M][N];
        map = new int[M][N];

        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int a = y1; a < y2; a++) {
                for (int b = x1; b < x2; b++) {
                    map[a][b] = 1;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0 && visited[i][j] == false) {
                    cnt = BFS(i,j);
                    data.add(cnt);
                }
            }
        }
        Collections.sort(data);

        for (int num : data) {
            sb.append(num + " ");
        }
        System.out.println(data.size());
        System.out.println(sb);
    }
    public static int BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x,y});
        int count = 1;
        while(!queue.isEmpty()){
            int[] data = queue.poll();
            int curX = data[0];
            int curY = data[1];

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = curY + dy[i];
                if(nx>=0 && ny>= 0 && nx<M && ny<N){
                    if(visited[nx][ny] == false && map[nx][ny] == 0){
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx,ny});
                        count ++;
                    }
                }
            }
        }
        return count;
    }
}
