import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int[] data = new int[N];
        int[] sumData = new int[N+1];
        sumData[0] = 0;
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            data[i] = Integer.valueOf(st1.nextToken());
            if(i != 0){
                sumData[i] = data[i-1] + sumData[i-1];
            }
        }
        sumData[N] = data[N-1] + sumData[N-1];

        for(int i=0; i<M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int n1 = Integer.valueOf(st2.nextToken());
            int n2 = Integer.valueOf(st2.nextToken());
            System.out.println(sumData[n2] - sumData[n1-1]);
        }
    }
}
