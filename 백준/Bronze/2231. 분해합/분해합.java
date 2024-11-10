import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        boolean answer = false;
        for(int i=1; i<=1000000; i++) {
            int sum = 0;
            for(int j=0; j<String.valueOf(i).length(); j++) {
                sum += Integer.valueOf(String.valueOf(i).charAt(j) - '0');
            }
            if (sum + i == num) {
                sb.append(i);
                answer = true;
                break;
            }
        }

        if(!answer) {
            sb.append("0");
        }

        System.out.println(sb);
    }
}