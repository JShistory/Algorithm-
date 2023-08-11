import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> data = new Stack<>();
        for (int i = 0; i < ingredient.length; i++) {

            data.push(ingredient[i]);
            if(data.size() >= 4){
                int a = data.pop();
                int b = data.pop();
                int c = data.pop();
                int d = data.pop();

                if(a == 1 && b == 3 && c == 2 && d == 1){
                    answer +=1;
                }
                else{
                    data.push(d);
                    data.push(c);
                    data.push(b);
                    data.push(a);
                }
            }
        }
        return answer;
    }
}