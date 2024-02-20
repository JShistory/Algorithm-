import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int tScore = Integer.valueOf(st.nextToken());
		int P = Integer.valueOf(st.nextToken());
		if(N == 0) {
			System.out.println(1);
			return ;
		}
		st = new StringTokenizer(br.readLine());
		List<Integer> scores = new ArrayList<>();
		while(st.hasMoreTokens()) {
			scores.add(Integer.valueOf(st.nextToken()));
		}
		
		int min = Collections.min(scores);
		
		if(min >= tScore && N == P) {
			System.out.println(-1);
			return ;
		}
		
		List<Integer> data = new ArrayList<>();

		int count = Collections.frequency(scores, tScore);
		scores.add(tScore);
		Collections.sort(scores, Collections.reverseOrder());
		for(int i=0; i<Math.min(P,scores.size()); i++) {
			data.add(scores.get(i));
		}
		
		System.out.println(data.indexOf(tScore) + 1);		
	}
}
