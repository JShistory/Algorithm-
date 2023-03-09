class Solution {
    public int solution(int a, int b, int n) {
    int answer = 0;
    while (true) {
            if (n >= a) {
                answer += (n / a) * b;
                n = (n / a) * b + (n%a);
            }else {
                break;
            }

        }
    return answer;
}
    
}