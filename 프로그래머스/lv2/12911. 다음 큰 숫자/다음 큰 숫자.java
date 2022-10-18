class Solution {
    public int solution(int n) {
        int answer = 0;
        int bignumber = 0;
        String binaryString = Integer.toBinaryString(n);
        bignumber = countChar(binaryString,'1');

        for(int i=n+1; i<1000001; i++){
            binaryString = Integer.toBinaryString(i);
            if(countChar(binaryString,'1') == bignumber){
                answer = Integer.parseInt(binaryString, 2);
                break;
            }
        }
        return answer;
    }
    public static int countChar(String str, char ch){
        int count = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ch){
                count +=1;
            }
        }
        return count;
    }
}