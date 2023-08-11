class Solution {
    public int solution(String s) {
        int answer = 0;
        int idx = 0, jdx = 0;
        char c = s.charAt(0);
        for(int i=0; i<s.length(); i++){
            if(idx == jdx){
                answer++;
                c = s.charAt(i);
            }

            if(s.charAt(i) == c) idx ++;
            else jdx ++;
        }
        return answer;
    }
}