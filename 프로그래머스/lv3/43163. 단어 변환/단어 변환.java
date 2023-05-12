import java.util.*;

class dataPoint{
    String str;
    int count;
    dataPoint(String str, int count){
        this.str = str;
        this.count = count;
    }
}
class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        int count = 0;
        
        for(String s : words){
            if(s.equals(target)){
                answer ++;
            }
        }
        if(answer != 1){
            return 0;
        }
        visited = new boolean[words.length];
        dfs(begin,target,words,count);
        return answer;
    }
    public void dfs(String begin, String target, String[] words, int count){
        if(begin.equals(target)){
            answer = count;
            return;
        }
        for(int k = 0; k<words.length; k++){
            int cnt = 0;
            if(visited[k] == true){
                continue;
            }
            for(int i=0; i<words[k].length(); i++){
                if(begin.charAt(i) != words[k].charAt(i)){
                    cnt++;
                }
            }
            if(cnt == 1){
                visited[k] = true;
                dfs(words[k],target,words,count+1);
                visited[k] = false;
            }
        }
    }
}