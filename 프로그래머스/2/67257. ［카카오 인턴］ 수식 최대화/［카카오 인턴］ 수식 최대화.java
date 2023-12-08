import java.util.*;
class Solution {
    public long solution(String expression) {
long answer = Long.MIN_VALUE;
        String op[][] = {{"+", "-", "*"}, {"+", "*", "-"}, {"-", "*", "+"},
                {"-", "+", "*"}, {"*", "-", "+"}, {"*", "+", "-"}};
        List<String> data = new ArrayList<>();
        int index = 0;
        for(int i=0; i<expression.length(); i++){
            if(expression.charAt(i) == '+' ||expression.charAt(i) == '-' ||expression.charAt(i) == '*' ){
                data.add(expression.substring(index,i));
                data.add(expression.charAt(i) + "");
                index = i+1;
            }
        }
        data.add(expression.substring(index));

        for(int i=0; i<op.length; i++){
            List<String> sub_data = new ArrayList<>(data);
            for(int j=0; j<3; j++){
                for(int k=0; k< sub_data.size(); k++){
                    if(op[i][j].equals(sub_data.get(k))){
                        sub_data.set(k-1,Calc(sub_data.get(k-1),sub_data.get(k),sub_data.get(k+1)));
                        sub_data.remove(k);
                        sub_data.remove(k);
                        k--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(sub_data.get(0))));
        }

        return answer;
    }
    private static String Calc(String num1, String op, String num2){
        long data1 = Long.parseLong(num1);
        long data2 = Long.parseLong(num2);

        if (op.equals("+"))
            return data1+data2 +"";
        if (op.equals("-"))
            return data1-data2 +"";
        return data1 * data2 + "";
    }

}