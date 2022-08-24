import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        if(s.charAt(0) == ')')
            return false;
        for(int i=0; i<s.length(); i++){
            if(!(stack.isEmpty()) && s.charAt(i) == ')' && stack.peek().equals('(')){
                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        
        if(stack.isEmpty()){
            return true;
        }
        else
            return false;
    
    }
}