import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        for(int i=-999; i<=999; i++) {
            for(int j=-999; j<=999; j++){
                if(x1 * i + y1 * j == c && x2 * i + y2 * j == f) {
                    sb.append(i + " " + j);
                }
            }
        }
        System.out.println(sb);
    }
}