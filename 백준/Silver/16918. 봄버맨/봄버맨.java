import java.util.*;
import java.io.*;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int R;
	static int C;
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.valueOf(st.nextToken());
		C = Integer.valueOf(st.nextToken());
		int N = Integer.valueOf(st.nextToken());
		char[][] map1 = new char[R][C];
		int[][] count = new int[R][C];
		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map1[i][j] = str.charAt(j);
				if(map1[i][j] == 'O') {
					count[i][j] = 3;
				}
				
			}
		}
		
		int time = 1;
		while(time < N) {
			time++;
			boomInstall(time, map1, count);
			if(time == N)break;
			time+=1;
			boom(time, map1, count);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				sb.append(map1[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void boomInstall(int time, char[][] map1, int[][] count) {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map1[i][j] == '.') {
					map1[i][j] = 'O';
					count[i][j] = time+3;
					
				}
			}
		}
	}
	
	static void boom(int time, char[][] map1, int[][] count) {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(count[i][j] == time) {
					map1[i][j] ='.';
					for(int k =0; k<4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(nx>=0 && ny>=0 && nx <R && ny < C ) {
							map1[nx][ny] ='.';
						}
					}
				}
			}
		}
	}

}
