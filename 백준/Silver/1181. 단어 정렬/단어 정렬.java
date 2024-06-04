import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        List<String> data = new ArrayList<>();
        for(int i=0; i<N; i++){
            String input = br.readLine();
            if(data.contains(input)){
                continue;
            }
            data.add(input);
        }
        data.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        for(String str : data){
            System.out.println(str);
        }
    }
}