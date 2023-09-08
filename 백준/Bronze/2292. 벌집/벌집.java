import java.util.*;
import java.io.*;
// 1 -> 7 -> 12 -> 18 -> 24
// 1 -> 2~7 -> 8~19 -> 20~37 -> 38~61 ~~~

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        int r = 2;
        int count = 1;
        if(N == 1){
            System.out.println(1);
        }

        else{
            while(r <= N){
                r = r +(6 * count);
                count++;
            }
            System.out.println(count);
        }

    }
}
