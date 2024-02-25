import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] lake;
    static int R;
    static int C;
    static int end_x;
    static int end_y;
    static boolean[][] visited;
    static Queue<gps> water;
    static Queue<gps> baekjo;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.valueOf(st.nextToken());
        C = Integer.valueOf(st.nextToken());
        lake = new char[R][C];

        baekjo = new LinkedList<>();
        water = new LinkedList<>();
        boolean firstBaekjo = false;
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                lake[i][j] = str.charAt(j);
                if (lake[i][j] == '.') {
                    water.add(new gps(i, j));
                }
                else if (lake[i][j] == 'L') {
                    if(firstBaekjo){
                        end_x = i;
                        end_y = j;
                        lake[i][j] = '.';
                        water.add(new gps(i,j));
                    }
                    else{
                        lake[i][j] = '.';
                        baekjo.add(new gps(i, j));
                        water.add(new gps(i,j));
                        firstBaekjo = true;
                    }


                }

            }
        }

        visited = new boolean[R][C];
        int day = 0;
        while(true) {
            boolean meet = check();
            if (meet) {
                break;
            }
            BFS();
            day += 1;
//         System.out.println("----------");
//         for(char[] data : lake) {
//            System.out.println(Arrays.toString(data));
//         }
//         System.out.println("----------");
//
//         System.out.println(baekjo.get(0).x + " " + baekjo.get(0).y);



        }
        System.out.println(day);
    }

    static void BFS() {

        int size = water.size();

        while (size-- > 0) {
            gps p = water.poll();
            int x = p.x;
            int y = p.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if (lake[nx][ny] == 'X') {
                        lake[nx][ny] = '.';
                        water.offer(new gps(nx, ny));
                    }
                }
            }
        }

    }

    static boolean check() {
        Queue<gps> data = new LinkedList<>();


        while (!baekjo.isEmpty()) {
            gps p = baekjo.poll();
            int x = p.x;
            int y = p.y;
            visited[x][y] = true;
            if(x == end_x && y == end_y){
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (lake[nx][ny] == '.') {
                        baekjo.offer(new gps(nx, ny));
                    }
                    else if(lake[nx][ny] == 'X'){
                        data.add(new gps(nx,ny));
                    }

                }
            }
        }
        baekjo = data;
        return false;
    }

}

class gps {
    int x;
    int y;


    gps(int x, int y) {
        this.x = x;
        this.y = y;

    }

    gps() {

    }
}