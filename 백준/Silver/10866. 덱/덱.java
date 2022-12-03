
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            String[] strSplit = command.split(" ");
            if (command.startsWith("push_back")) {
                deque.addLast(strSplit[1]);

            } else if (command.startsWith("push_front")) {
                deque.addFirst(strSplit[1]);

            } else if (command.startsWith("front")) {
                if (deque.size() == 0) {
                    sb.append("-1");
                } else {
                    sb.append(deque.peekFirst());
                }
                sb.append("\n");
            } else if (command.startsWith("back")) {
                if (deque.size() == 0) {
                    sb.append("-1");
                } else {
                    sb.append(deque.peekLast());
                }
                sb.append("\n");
            } else if (command.startsWith("pop_front")) {
                if (deque.size() == 0) {
                    sb.append("-1");
                } else {
                    sb.append(deque.pollFirst());
                }
                sb.append("\n");
            } else if (command.startsWith("pop_back")) {
                if (deque.size() == 0) {
                    sb.append("-1");
                } else {
                    sb.append(deque.pollLast());

                }
                sb.append("\n");
            } else if (command.startsWith("size")) {
                sb.append(deque.size());
                sb.append("\n");
            } else if (command.startsWith("empty")) {
                if (deque.size() == 0) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
                sb.append("\n");
            }

        }
        System.out.println(sb.toString());
    }
}
