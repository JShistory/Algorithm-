import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            int c = Integer.valueOf(st.nextToken());
            int max = Math.max(a, Math.max(b, c));

            if(a == 0 && b == 0 && c == 0){
                break;
            }

            if(a+b+c- max <= max){
                sb.append("Invalid\n");
            }
            else if(a == b && b == c && a == c){
                sb.append("Equilateral\n");
            }
            else if(a != b && b != c && a != c){
                sb.append("Scalene\n");
            }
            else if(a == b || a == c || b == c){
                sb.append("Isosceles\n");
            }

        }
        System.out.println(sb);

    }
}
