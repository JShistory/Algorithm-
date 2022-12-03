
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        List<Integer> data1 = new ArrayList<>();
        while (st1.hasMoreTokens()) {
            data1.add(Integer.parseInt(st1.nextToken()));
        }
        Collections.sort(data1);

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<Integer> data2 = new ArrayList<>();
        while (st2.hasMoreTokens()) {
            data2.add(Integer.parseInt(st2.nextToken()));
        }

        int sum = 0;
        for(int i=0; i<N; i++){
            sum += (Collections.max(data2) * Collections.min(data1));
            data2.remove(Collections.max(data2));
            data1.remove(Collections.min(data1));
        }
        System.out.println(sum);
    }
}
