
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[][] map;
    static ArrayList<Node> chicken = new ArrayList<>();
    static ArrayList<Node> home = new ArrayList<>();
    static int N;
    static int M;
    static boolean[] visited;
    static int ans;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    home.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }

        }
        ans = Integer.MAX_VALUE;
        visited = new boolean[chicken.size()];
        DFS(0,0);
        System.out.println(ans);

    }
    public static void DFS(int start, int depth){
        if(depth == M){
            int res = 0;
            for(int i=0; i<home.size(); i++){
                int min_value = Integer.MAX_VALUE;
                for(int j=0; j<chicken.size(); j++){
                    if(visited[j]){
                        int distance = Math.abs(home.get(i).x - chicken.get(j).x) + Math.abs(home.get(i).y - chicken.get(j).y);
                        min_value = Math.min(min_value,distance);
                    }
                }
                res+=min_value;
            }
            ans = Math.min(ans,res);
            return;
        }


        for(int i=start; i<chicken.size(); i++){
            visited[i] = true;
            DFS(i+1,depth+1);
            visited[i] = false;
        }
    }
}
