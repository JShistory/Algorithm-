
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] data = new int[N];

        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);
        long lo =0;
        long hi = data[N - 1];
        long money = Integer.parseInt(br.readLine());
        long answer = 0;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long sum = 0; // 내야 할 세금 ?
            for (int country_money : data) {
                if (country_money >= mid){
                    sum += mid;
                }
                else{
                    sum += country_money;
                }
            }
            if(sum > money){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
                answer = Math.max(answer, mid);
            }

        }
        System.out.println(answer);

    }

    public static void binary(int start, int end) {

    }
}
