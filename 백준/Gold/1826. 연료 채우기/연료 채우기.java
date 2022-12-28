
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Oil> soil = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            soil.add(new Oil(a, b));
        }

        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int answer = 0;

        PriorityQueue<Integer> fuel = new PriorityQueue<>(Collections.reverseOrder());

        while (P < L) {
            while (!soil.isEmpty() && soil.peek().distance <= P) {
                fuel.add(soil.poll().oil_amount);
            }
            if (fuel.isEmpty()) {
                System.out.println(-1);
                return;
            }
            answer++;
            P += fuel.poll();

        }
        System.out.println(answer);


    }

    public static class Oil implements Comparable<Oil> {
        int distance;
        int oil_amount;

        public Oil(int distance, int oil_amount) {
            this.distance = distance;
            this.oil_amount = oil_amount;
        }

        @Override
        public int compareTo(Oil o) {
            return this.distance - o.distance;
        }
    }
}
