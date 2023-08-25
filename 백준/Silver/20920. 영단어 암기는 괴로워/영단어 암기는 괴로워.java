import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        HashMap<String,Integer> words = new LinkedHashMap<>();

        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());

        for(int i=0; i<N; i++){
            String word = br.readLine();
            if(word.length() >= M){
                words.put(word,words.getOrDefault(word,0)+1);
            }
        }

        List<String> keySet = new ArrayList<>(words.keySet());

        keySet.sort((o1, o2) -> {
            int c1 = words.get(o1);
            int c2 = words.get(o2);

            if(c1==c2){
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
            return c2-c1;
        });

        for(String answer : keySet){
            sb.append(answer+"\n");
        }

        System.out.println(sb.toString());


    }
}
