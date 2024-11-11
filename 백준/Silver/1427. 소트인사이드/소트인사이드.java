import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String N = br.readLine();

        Integer[] data = new Integer[N.length()];
        for (int i = 0; i < N.length(); i++) {
            data[i] = N.charAt(i) - '0';
        }

        Arrays.sort(data, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


        for (int num : data) {
            sb.append(String.valueOf(num));
        }
        System.out.println(sb.toString());
    }
}
