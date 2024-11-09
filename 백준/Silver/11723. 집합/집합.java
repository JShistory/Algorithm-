import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Set<Integer> S = new HashSet<>();
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            String command1 = input[0];
            String command2 = "";
            if (!command1.equals("all") && !command1.equals("empty")){
                command2 = input[1];
            }
            switch (command1) {
                case "add":
                    S.add(Integer.parseInt(command2));
                    break;
                case "remove":
                    S.remove(Integer.parseInt(command2));
                    break;
                case "check":
                    if (S.contains(Integer.parseInt(command2))) {
                        sb.append("1");
                    } else {
                        sb.append("0");
                    }
                    sb.append("\n");
                    break;
                case "toggle":
                    if (!S.contains(Integer.parseInt(command2))) {
                        S.add(Integer.parseInt(command2));
                    } else {
                        S.remove(Integer.parseInt(command2));
                    }
                    break;
                case "all":
                    S = new HashSet<>();
                    for (int j = 1; j <= 20; j++) {
                        S.add(j);
                    }
                    break;
                case "empty":
                    S = new HashSet<>();
                    break;
            }
        }
        System.out.println(sb);

    }
}