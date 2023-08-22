import java.util.*;
class point{
    int x;
    int y;
    point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static List<point> island = new ArrayList<>();
    static boolean[][] visited;
    public int[] solution(String[] maps) {
        
        List<Integer> answerList = new ArrayList<>();
        char[][] map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] != 'X'){

                    island.add(new point(i,j));
                }
            }
        }
        
        int count = 0;
        for(int i=0; i<island.size(); i++){
            
            point data = island.get(i);
            if(visited[data.x][data.y] == false){
                // System.out.println(data.x);
                // System.out.println(data.y);
                count = BFS(data.x,data.y,map);
                answerList.add(count);
                count = 0;
            }
            
        }
        // System.out.println(answerList);
        int[] answer = new int[answerList.size()];
        if(answerList.size() == 0){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        Collections.sort(answerList);
        for(int i=0; i<answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    int BFS(int x,int y,char[][] map){
        Deque<point> deque = new ArrayDeque<>();
        deque.add(new point(x,y));
        int count = Integer.valueOf(map[x][y]-'0');
        visited[x][y] = true;
        while(!deque.isEmpty()){
            point data = deque.removeFirst();
            x = data.x;
            y = data.y;
            
            for(int i=0; i<4; i++){
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if(nx >= 0 && nx < map.length && ny >= 0 && ny <map[0].length && visited[nx][ny] == false){
                    if(map[nx][ny] != 'X'){
                        count += Integer.valueOf(map[nx][ny]-'0');
                        deque.offer(new point(nx,ny));
                        visited[nx][ny] = true;
                        // System.out.println(map[nx][ny]);
                        // System.out.println("nx = " +nx);
                        // System.out.println("ny = "+ ny);
                        // System.out.println("count = "+count);
                    }
                }
            }
            
        }
        return count;
    }
}