
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	private static int[] operation = new int[4];
	private static int[] numbers;
	private static int MAX = Integer.MIN_VALUE;	// 최댓값 
	private static int MIN = Integer.MAX_VALUE;	// 최솟값
	private static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			operation[i]= Integer.valueOf(st.nextToken()); 
		}
		
		dfs(numbers[0], 1);
		System.out.println(MAX + "\n" + MIN);
	}
	
	static void dfs(int num, int idx) {
		if (idx == N) {
			MAX = Math.max(num, MAX);
			MIN = Math.min(num, MIN);
			return;
		}
		
		for(int i=0; i<4; i++) {
			if (operation[i] > 0) {
				
				operation[i]--;
				
				switch (i) {
				case 0: dfs(num + numbers[idx], idx+1); break;
				case 1: dfs(num - numbers[idx], idx+1); break;
				case 2: dfs(num * numbers[idx], idx+1); break;
				case 3: dfs(num / numbers[idx], idx+1); break;
				}
				
				operation[i]++;
			}
		}
	}
}
