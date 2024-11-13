import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] sudoku = new int[9][9];
    private static List<int[]> zero = new ArrayList<>();
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
                if (sudoku[i][j] == 0) {
                    zero.add(new int[]{i, j});
                }
            }
        }
        dfs(0);

    }

    private static void dfs(int depth) {
        if (depth == zero.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sudoku[i][j] + " ");
                }
                sb.append("\n");
            }

            System.out.println(sb.toString());
            System.exit(0);
        }

        int[] zeroArrays = zero.get(depth);
        for (int x = 1; x <= 9; x++) {
            if (checkSudoku(zeroArrays[0], zeroArrays[1], x)) {
                sudoku[zeroArrays[0]][zeroArrays[1]] = x;
                dfs(depth+1);
                sudoku[zeroArrays[0]][zeroArrays[1]] = 0;
            }
        }
    }

    private static boolean checkSudoku(int cx, int cy, int num) {
        //행 검사
        for (int y = 0; y < 9; y++) {
            if (num == sudoku[cx][y]) {
                return false;
            }
        }
        //열 검사
        for (int x = 0; x < 9; x++) {
            if (num == sudoku[x][cy]) {
                return false;
            }
        }

        int[] zone = getZone(cx, cy);

        int startX = zone[0];
        int startY = zone[1];

        for (int i = startX; i <= startX + 2; i++) {
            for (int j = startY; j <= startY + 2; j++) {
                if (num == sudoku[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] getZone(int x, int y) {
        int xIndex = x / 3;
        int yIndex = y / 3;

        if (xIndex <= 0 && yIndex <= 0) {
            return new int[]{0, 0};
        } else if (xIndex <= 0 && yIndex <= 1) {
            return new int[]{0, 3};
        } else if (xIndex <= 0 && yIndex <= 2) {
            return new int[]{0, 6};
        } else if (xIndex <= 1 && yIndex <= 0) {
            return new int[]{3, 0};
        } else if (xIndex <= 1 && yIndex <= 1) {
            return new int[]{3, 3};
        } else if (xIndex <= 1 && yIndex <= 2) {
            return new int[]{3, 6};
        } else if (xIndex <= 2 && yIndex <= 0) {
            return new int[]{6, 0};
        } else if (xIndex <= 2 && yIndex <= 1) {
            return new int[]{6, 3};
        } else if (xIndex <= 2 && yIndex <= 2) {
            return new int[]{6, 6};
        }
        return new int[]{0, 0};
    }
}