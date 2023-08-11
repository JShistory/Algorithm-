import java.util.ArrayList;
import java.util.List;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        List<Character> skipList = new ArrayList<>();
        for (int i = 0; i < skip.length(); i++) {
            skipList.add(skip.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            for (int j = 1; j <= index; j++) {
                c += 1;
                if ( c> 'z'){
                    c -= 26;
                }
                if (skipList.contains(c)) {
                    j--;
                }


            }
            answer += c;
        }

        

        return answer;
    }
}
