import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            LinkedList<int[]> print = new LinkedList<>();
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int[] priory = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int j = 0;
            while (st.hasMoreElements()) {
                priory[j++] = Integer.parseInt(st.nextToken());
            }
            for (int index = 0; index < N; index++) {
                print.offer(new int[]{index, priory[index]});
            }
            int count = 0;
            while(!print.isEmpty()) {
                int[] data = print.poll();
                boolean isMax = true;
                for (int k=0; k<print.size(); k++) {
                    if(data[1] < print.get(k)[1]) {
                        isMax = false;
                        break;
                    }
                }
                if (isMax) {
                    count++;
                    if (data[0] == M) {
                        break;
                    }
                }
                else {
                    print.add(data);
                }
            }
            System.out.println(count);
        }



    }
}