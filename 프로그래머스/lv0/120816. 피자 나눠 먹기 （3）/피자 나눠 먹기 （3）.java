class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        answer += (n/slice);
        if(n - (answer * slice) > 0){
            answer += 1;
        }
        return answer;
    }
}