import java.util.*;
import java.io.*;

class Point {
	int x;
	int y;
	int cnt;
	Point(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static int mapNumber = 2;
	static boolean[][] visited;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int j = 0;
			while(st.hasMoreTokens()) {
				map[i][j++] = Integer.valueOf(st.nextToken());
				
			}
		}

		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					numbering(i,j);
					
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 0) {
					visited = new boolean[map.length][map[0].length];
					bfs(i,j);
				}
			}
		}
		System.out.println(answer);
		
		
		
	}
	
	static void numbering(int x, int y) {
		Queue<Point> data = new LinkedList<>();
		data.offer(new Point(x,y,0));
		visited = new boolean[map.length][map[0].length];
		visited[x][y] = true;
		map[x][y] = mapNumber;
		while(!data.isEmpty()) {
			Point p = data.poll();
			x = p.x;
			y = p.y;
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && visited[nx][ny] == false) {
					if(map[nx][ny] == 1) {
						map[nx][ny] = mapNumber;
						visited[nx][ny] = true;
						data.offer(new Point(nx,ny,0));
					}
				}
			}
		}
		mapNumber++;
	}
	
	static void bfs(int x, int y) {
		Queue<Point> data = new LinkedList<>();
		data.offer(new Point(x,y,0));
		visited[x][y] = true;
		int cnt = 0;
		int currentMapNumber = map[x][y];
		while(!data.isEmpty()) {
			Point p = data.poll();
			x = p.x;
			y = p.y;
			cnt = p.cnt;
			
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && visited[nx][ny] == false && map[nx][ny] != currentMapNumber) {
					visited[nx][ny] = true;
					if(map[nx][ny] == 0) {
						data.offer(new Point(nx,ny,cnt+1));
					}
					else {
						answer = Math.min(answer, cnt);
					}
				}
			}
		}
		
	}

}
