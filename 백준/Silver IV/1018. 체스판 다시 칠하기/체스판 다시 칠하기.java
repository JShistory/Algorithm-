import java.util.*;
import java.io.*;
public class Main {
	static int count;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		String[][] chess = new String[N][M];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				chess[i][j] = Character.toString(s.charAt(j));
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				check(i,j,chess,"B");
				check(i,j,chess,"W");

				
			}
		}
		System.out.println(answer);
	}
	
	static void check(int n, int m, String[][] chess,String color) {
		int xSize = n + 7;
		int ySize = m + 7;
		count = 0;
		
		if(xSize >= chess.length || ySize >= chess[0].length) {
			return ;
		}

		String memory = color;

		for(int i=n; i<n+8; i++) {
			for(int j=m; j<m+8; j++) {
				if(!chess[i][j].equals(memory)) {
					count++;
				}
				if(memory.equals("B")) {
					memory = "W";
				}
				else {
					memory = "B";
				}
			}
			if(memory.equals("B")) {
				memory = "W";
			}
			else {
				memory = "B";
			}
			
		}
		answer = Math.min(answer, count);
		return ;
	}

}
