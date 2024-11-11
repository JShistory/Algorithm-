import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque<int[]> data = new ArrayDeque<>();
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < input.length; i++) {
            data.add(new int[]{Integer.parseInt(input[i]), i + 1});
        }
        int[] balloon = data.poll();
        sb.append(balloon[1] + " ");
        while (!data.isEmpty()) {
            if (balloon[0] > 0) {
                for (int i = 0; i < balloon[0] - 1; i++) {
                    data.offer(data.poll());
                }
                balloon = data.poll();

            } else if (balloon[0] < 0) {
                for (int i = 0; i < Math.abs(balloon[0]) - 1; i++) {
                    data.offerFirst(data.pollLast());
                }
                balloon = data.pollLast();
            }

            sb.append(balloon[1] + " ");
        }
        System.out.println(sb.toString().trim());
    }
}
