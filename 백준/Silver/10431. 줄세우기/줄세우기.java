
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int P = Integer.valueOf(br.readLine());
		
		for(int i=0; i<P; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] data = new int[20];
			st.nextToken();
			int j = 0;
			while(st.hasMoreTokens()) {
				data[j++] = Integer.valueOf(st.nextToken());
			}
			int count = 0;
			for(int k=data.length-1; k>0; k--) {
				int checkNumber = data[k];
				for(int l= k-1; l>=0; l--) {
					if(checkNumber < data[l]) {
						count++;
					}
				}
			}
			sb.append(i+1 + " " + count + "\n");
			
		}
		System.out.println(sb.toString());
	}
	

}
