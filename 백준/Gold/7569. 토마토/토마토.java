import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Point{
    int h;
    int n;
    int m;
    Point(int h, int n, int m){
        this.h = h;
        this.n = n;
        this.m = m;
    }
}
public class Main {
    static StringTokenizer st;
    static int[][][] tomatoBox;
    static Queue<Point> queue = new LinkedList<>();
    static int H;
    static int N;
    static int M;
    static int[] dm = {-1,1,0,0,0,0};
    static int[] dn = {0,0,-1,1,0,0};
    static int[] dh = {0,0,0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomatoBox = new int[H][N][M];

        for(int h=0; h<H; h++){
            for(int n=0; n<N; n++){
                st = new StringTokenizer(br.readLine());
                for(int m=0; m<M; m++){
                    tomatoBox[h][n][m] = Integer.parseInt(st.nextToken());
                    if(tomatoBox[h][n][m] == 1){
                        queue.add(new Point(h,n,m));
                    }
                }
            }
        }
        System.out.println(BFS());
    }

    public static int BFS(){
        while(!queue.isEmpty()){
            Point data = queue.poll();
            int h = data.h;
            int n = data.n;
            int m = data.m;
            for(int i=0; i<6; i++){
                int nh = h + dh[i];
                int nn = n + dn[i];
                int nm = m + dm[i];
                if(nm>=0 && nn>=0 && nh>=0 && nm<M && nn<N && nh<H){
                    if(tomatoBox[nh][nn][nm] == 0){
                        queue.add(new Point(nh,nn,nm));
                        tomatoBox[nh][nn][nm] = tomatoBox[h][n][m] + 1;
                    }
                }
            }
        }
        int date = Integer.MIN_VALUE;
        for(int h=0; h<H; h++){
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if(tomatoBox[h][n][m] == 0){
                        return -1;
                    }
                    date = Math.max(date, tomatoBox[h][n][m]);
                }
            }
        }
        if(date == 0){
            return 0;
        }
        return date-1;
    }
}