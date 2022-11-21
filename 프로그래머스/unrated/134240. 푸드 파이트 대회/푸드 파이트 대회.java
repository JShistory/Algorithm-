class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i=1; i<food.length; i++){
            if(food[i]%2 != 0){
                for(int j=0; j<food[i]/2; j++){
                    answer += i;
                }
            }else if(food[i]%2 == 0){
                for(int j=0; j<food[i]/2; j++){
                    answer +=i;
                }
            }
        }
        answer += '0';
        for(int i=answer.length()-2; i>=0; i--){
            answer += answer.charAt(i) -'0';
        }
    
        return answer;
    }
}