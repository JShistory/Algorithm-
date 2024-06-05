import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var str = new StringTokenizer(br.readLine());
        var N = Integer.parseInt(str.nextToken());
        var game = str.nextToken();

        var participants = new HashSet<String>();
        for (int i = 0; i < N; i++) {
            participants.add(br.readLine());
        }

        if(game.equals("Y")){
            System.out.println(participants.size());
        }
        else if(game.equals("F")){
            System.out.println(participants.size() / 2);
        }

        else if(game.equals("O")){
            System.out.println(participants.size() / 3);
        }
    }
}