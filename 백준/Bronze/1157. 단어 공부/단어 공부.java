import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        data = data.toLowerCase();

        int[] ascii = new int[26];
        for(int i=0; i<data.length(); i++){
            ascii[data.charAt(i)-'a'] += 1;
        }


        char answer = '?';
        int max = 0;
        for(int i=0; i<ascii.length; i++){
            if(max < ascii[i]){
                max = ascii[i];
                answer = (char)(i+'A');
            }
            else if(max == ascii[i]){
                answer = '?';
            }
        }

        System.out.println(answer);


    }
}
