import java.util.*;

class Point{
    int x;
    int y;
    int count;
    Point(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    public int solution(String[] board) {
        int answer = 0;
        int start_X = 0;
        int start_Y = 0;
        char[][] maps = new char[board.length][board[0].length()];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length(); j++){
                maps[i][j] = board[i].charAt(j);
                if(maps[i][j] == 'R'){
                    start_X = i;
                    start_Y = j;
                }
            }
        }
        answer = BFS(start_X, start_Y, maps,0,board);
        return answer;
    }
    
    int BFS(int start_X, int start_Y, char[][] maps, int count,String[] board){
        Queue<Point> queue = new LinkedList<>();
        visited = new boolean[board.length][board[0].length()];
        queue.add(new Point(start_X, start_Y, count));
        visited[start_X][start_Y] = true;
        while(!queue.isEmpty()){
            Point data = queue.poll();
            int x = data.x;
            int y = data.y;
            int cnt = data.count;
            if(maps[x][y] == 'G'){
                return cnt;
            }
            
            for(int i=0; i<4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                
                while(nx>=0 && nx<board.length && ny>=0 && ny<board[0].length() && maps[nx][ny] != 'D'){
                    nx += dx[i];
                    ny += dy[i];

                }
                nx -= dx[i];
                ny -= dy[i];
                if(visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, cnt + 1));
                }
                
                  
            }
        }
        return -1;
    }
}