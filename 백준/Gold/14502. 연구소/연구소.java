import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int wall = 3;
    private static int answer = 0;
    private static List<int[]> virus;
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] maps = new int[N][M];

        virus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] mapInput = br.readLine().split(" ");
            for (int j = 0; j < mapInput.length; j++) {
                maps[i][j] = Integer.parseInt(mapInput[j]);
                if(maps[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }
        dfs(0, maps);
        System.out.println(answer);
    }

    static void dfs(int count, int[][] maps) {
        if (count == wall) {
            int[][] tempMap = new int[maps.length][maps[0].length];
            for (int i = 0; i < maps.length; i++) {
                for (int j = 0; j < maps[i].length; j++) {
                    tempMap[i][j] = maps[i][j];
                }
            }
            tempMap = checkVirus(tempMap);
            answer = Math.max(answer, getAnswer(tempMap));
            return;
        }

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                if (maps[i][j] == 0) {
                    maps[i][j] = 1;
                    count+=1;
                    dfs(count, maps);
                    maps[i][j] = 0;
                    count -= 1;
                }
            }
        }
    }

    static int[][] checkVirus(int[][] maps) {
        boolean[][] check = new boolean[maps.length][maps[0].length];
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < virus.size(); i++) {
            queue.add(virus.get(i));
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int x = poll[0];
                int y = poll[1];
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length) {
                        if (maps[nx][ny] == 0) {
                            maps[nx][ny] = 2;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return maps;
    }

    static int getAnswer(int[][] maps) {
        int count = 0;
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                if (maps[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}