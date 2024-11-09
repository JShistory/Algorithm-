import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<input.length(); i++) {
            if(input.charAt(i) == '<') {
                int idx =  input.indexOf('>',i+1);
                sb.append(input.substring(i, idx+1));
                i = idx;
            }
            else if(input.charAt(i) == ' '){
                sb.append(" ");
                continue;
            }
            else {
                int spaceIdx = input.indexOf(' ', i);
                int specialIdx = input.indexOf('<',i);
                int idx = 0;
                if(spaceIdx == -1 && specialIdx == -1) {
                    idx = input.length();
                }
                else if(spaceIdx == -1) {
                    idx = specialIdx;
                }
                else if(specialIdx == -1) {
                    idx = spaceIdx;
                }

                else if(spaceIdx > specialIdx){
                    idx = specialIdx;
                }
                else if(spaceIdx < specialIdx) {
                    idx = spaceIdx;
                }
                StringBuilder reverse = new StringBuilder();
                reverse.append(input.substring(i,idx));
                sb.append(reverse.reverse());
                i = idx-1;
            }
        }
        System.out.println(sb);

    }
}