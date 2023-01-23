class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int size = p.length();
        long num = Long.parseLong(p);

        for(int i=0; i<t.length() - size + 1; i++){
            long diff = Long.parseLong(t.substring(i,i+size));
            if(diff <= num){
                answer += 1;
            }

        }
        return answer;
    }
}