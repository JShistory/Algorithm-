import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> lowerData = new PriorityQueue<>();
        PriorityQueue<Integer> higerData = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            if(i%2 == 0){
                higerData.add(number);
            }
            else{
                lowerData.add(number);
            }

            if(!higerData.isEmpty() && !lowerData.isEmpty()){
                if(higerData.peek() > lowerData.peek()){
                    int tmp = lowerData.poll();
                    lowerData.add(higerData.poll());
                    higerData.add(tmp);
                }
            }
            System.out.println(higerData.peek());
        }

    }
}


