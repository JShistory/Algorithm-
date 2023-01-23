class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        answer[0] = -1;
        
        for (int i = 1; i < s.length(); i++) {
            //만약에 banana에서
            //    4번째 인덱스인 n을 찾는다면
            //    0~3까지의 문자열을 체크해서 판별함.
            int x = s.lastIndexOf(s.substring(i, i + 1), i - 1);

            if (x == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - x;
            }
        }

        return answer;
    }
}