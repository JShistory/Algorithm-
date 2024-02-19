
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[][] people = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			people[i][0] = Integer.valueOf(st.nextToken());
			people[i][1] = Integer.valueOf(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			int ranking = 1;
			for(int j=0; j<N; j++) {
				if(i == j) continue;
				
				if(people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
					ranking++;
				}
			}
			sb.append(ranking +" ");
		}
		
		System.out.println(sb.toString());
	}

}
