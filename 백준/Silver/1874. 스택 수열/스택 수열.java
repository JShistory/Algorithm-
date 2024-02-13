import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		boolean err = false;
		int idx = 1;
		for(int i=0; i<n; i++) {
			int data = Integer.valueOf(br.readLine());
			for( ; idx<=data; idx++) {
				stack.push(idx);
				sb.append("+\n");
			}
			
			if(stack.peek()==data) {
				stack.pop();
				sb.append("-\n");
			} else {
				err = true;
			}
			
			
		}
		if(err) {
			System.out.println("NO");
		}
		else {
			System.out.println(sb);
		}
	}

}
