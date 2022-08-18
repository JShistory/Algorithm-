import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i : moves){
            for(int j=0; j<board.length; j++){
                if(board[j][i-1] == 0){
                    continue;
                }    
                else{
                    if(stack.peek() == board[j][i-1]){
                        
                        answer +=2;
                        stack.pop();
                        
                    }
                    else{
                        stack.push(board[j][i-1]);
                    }
                    board[j][i-1] = 0;
                    break;
                    
                    
                }
            }
        }
        return answer;
    }
}