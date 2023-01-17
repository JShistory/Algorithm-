import java.util.LinkedList;
import java.util.List;

class Solution {
    static String[][] data;
    static boolean[][] visited;

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        data = new String[m][n];

        for (int i = 0; i < m; i++) {
            String[] board_data = board[i].split("");
            for (int j = 0; j < n; j++) {
                data[i][j] = board_data[j];
            }
        }

        while (true) {
            int num = update(m, n);

            if (num == 0) {
                break;
            }
            answer += num;
        }

        return answer;
    }

    static int update(int m, int n) {
        visited = new boolean[m][n];
        int cnt = 0;

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (data[i][j].equals("0")) {
                    continue;
                }
                if (validBlock(i, j) == true) {
                    visited[i][j] = true;
                    visited[i][j + 1] = true;
                    visited[i + 1][j] = true;
                    visited[i + 1][j + 1] = true;
                }
            }

        }

        for (int i = 0; i < n; i++) {
            List<String> temp = new LinkedList<>();
            for (int j = m - 1; j >= 0; j--) {
                if (visited[j][i] == true) {
                    cnt++;
                    continue;
                }
                temp.add(data[j][i]);
            }

            for (int j = m - 1, k = 0; j >= 0; j--, k++) {
                if (k < temp.size()) {
                    data[j][i] = temp.get(k);
                } else {
                    data[j][i] = "0";
                }

            }
        }

        return cnt;

    }

    static boolean validBlock(int x, int y) {
        String ch = data[x][y];
        if (ch.equals(data[x][y + 1]) && ch.equals(data[x + 1][y]) && ch.equals(data[x + 1][y + 1])) {
            return true;
        }
        return false;
    }
}
