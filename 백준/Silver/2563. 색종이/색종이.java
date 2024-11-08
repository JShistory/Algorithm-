import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[][] maps = new int[100][100];
        int[][] xy = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] inputDataSplit = br.readLine().split(" ");
            xy[i][0] = Integer.valueOf(inputDataSplit[0]);
            xy[i][1] = Integer.valueOf(inputDataSplit[1]);
        }

        for(int i=0; i<xy.length; i++) {
            int x = xy[i][0];
            int y = xy[i][1];
            for(int j=x; j<x+10; j++) {
                for (int k = y; k < y + 10; k++) {
                    maps[j][k] = 1;
                }
            }
        }
        int answer = 0;
        for(int i=0; i<maps.length; i++) {
            for(int j=0; j<maps[0].length; j++) {
                if(maps[i][j] == 1) {
                    answer ++;
                }
            }
        }
        System.out.println(answer);
    }
}