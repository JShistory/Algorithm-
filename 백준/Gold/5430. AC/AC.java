

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> deque;
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            boolean error = false;
            boolean isRight = true;
            String[] command = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");
            deque = new ArrayDeque<Integer>();
            for(int a=0; a<n; a++){
                deque.add(Integer.parseInt(st.nextToken()));
            }


            for(int j=0; j<command.length; j++){
                if(command[j].startsWith("R")){
                    isRight = !isRight;
                    continue;
                }

                if(isRight){
                    if(deque.pollFirst() == null){
                        error = true;
                    }

                }
                else{
                    if(deque.pollLast() == null){
                        error = true;
                    }

                }
            }
            if(error){
                sb.append("error\n");
                continue;
            }
            sb.append('[');
            if(deque.size() > 0){
                if(isRight){
                    sb.append(deque.pollFirst());
                    while(!deque.isEmpty()){
                        sb.append(",").append(deque.pollFirst());
                    }
                }
                else{
                    sb.append(deque.pollLast());
                    while(!deque.isEmpty()){
                        sb.append(",").append(deque.pollLast());
                    }
                }
            }
            sb.append("]").append("\n");
        }
        System.out.println(sb.toString());
    }
}
