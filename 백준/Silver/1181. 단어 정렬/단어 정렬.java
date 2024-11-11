import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] data = new String[N];
        for(int i=0; i<N; i++) {
            data[i] = br.readLine();
        }
        Set<String> set = new HashSet<>(List.of(data));
        data = set.toArray(new String[0]);
        Arrays.sort(data, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        for(String str : data) {
            sb.append(str + "\n");
        }

        System.out.println(sb);
    }
}