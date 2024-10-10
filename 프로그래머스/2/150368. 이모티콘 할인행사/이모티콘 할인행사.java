import java.util.*;
class Solution {
    private int[] sale = {10, 20, 30, 40};
    private int[][] users;
    private int[] emoticons;
    private int[] answer = new int[2];
    public int[] solution(int[][] users, int[] emoticons) {
        int[] rates = new int[emoticons.length];
        this.users = users;
        this.emoticons = emoticons;
        combi(rates, 0);
        return answer;
    }
    private void combi(int[] rates, int depth){
        if (depth == rates.length) {
            checkAnswer(rates);
            return;
        }
        
        for(int i=0; i<sale.length; i++) {
            rates[depth] = sale[i];
            combi(rates, depth + 1);
        }
    }
    
    private void checkAnswer(int[] rates) {
        int[] result = new int[2];
        for(int i=0; i<users.length; i++) {
            int totalPrice = 0;
            for(int j=0; j<emoticons.length; j++) {
                int discountPercent = rates[j];
                if (discountPercent >= users[i][0]) {
                    totalPrice += emoticons[j] * (100 - rates[j]) / 100;
                }
            }
            
            if (totalPrice >= users[i][1]) {
                result[0]++;
            }
            else {
                result[1] += totalPrice;
            }
        }
        if (result[0] > answer[0]) {
            answer[0] = result[0];
            answer[1] = result[1];
        }
        else if (result[0] == answer[0] && result[1] > answer[1]) {
            answer[0] = result[0];
            answer[1] = result[1];
        }
    }
}