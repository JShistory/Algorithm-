
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> data = new HashSet<>();
        while (st.hasMoreTokens()) {
            data.add(Integer.parseInt(st.nextToken()));
        }
        TreeSet<Integer> Tree = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        Tree.addAll(data);
        for (int num : Tree) {
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString());
    }
}
