
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(st1.hasMoreTokens()){
            int num1 = Integer.parseInt(st1.nextToken());
            if(map.containsKey(num1)){
                sb.append(map.get(num1)).append(" ");
            }
            else{
                sb.append("0 ");
            }
        }
        System.out.println(sb.toString());


    }
}
