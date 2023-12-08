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
    static boolean visited[][];

    public int solution(String[] maps) {
        int answer = -1;
        int start_X = 0;
        int start_Y = 0;
        
        int labor_X = 0;
        int labor_Y = 0;
        char[][] maps_data = new char[maps.length][maps[0].length()];
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                maps_data[i][j] = maps[i].charAt(j);
                if(maps_data[i][j] == 'S'){
                    start_X = i;
                    start_Y = j;
                }
                if(maps_data[i][j] == 'L'){
                    labor_X = i;
                    labor_Y = j;
                }
            }
        }
        int data1 = BFS(start_X, start_Y, maps_data,maps,'L');
        int data2 = BFS(labor_X, labor_Y, maps_data,maps,'E');
        System.out.println(data1);
        System.out.println(data2);
        if(data1 == -1 || data2 == -1){
            return -1;
        }
        return data1+data2;
    }
    int BFS(int start_X, int start_Y, char[][] maps,String[] map,char target){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(start_X, start_Y,0));
        visited = new boolean[map.length][map[0].length()];
        visited[start_X][start_Y] = true;
        int num = 0;
        while(!queue.isEmpty()){
            Point data = queue.poll();
            int x = data.x;
            int y = data.y;
            int count = data.count;
            if(maps[x][y]==target){
                return count;
            }
            
            for(int i=0; i<4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                
                if(nx>=0 && nx < map.length && ny >=0 && ny<map[0].length() && visited[nx][ny] == false){
                    if(maps[nx][ny] != 'X'){
                    visited[nx][ny] = true;
                    queue.add(new Point(nx,ny,count+1));
                    
                    }
                }
            }
        }
        return -1;
        
    }
}