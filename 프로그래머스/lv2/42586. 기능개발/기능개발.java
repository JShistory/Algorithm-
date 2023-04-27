import java.util.ArrayList;
import java.util.List;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[]{};
        List<Integer> answerData = new ArrayList<>();
        List<Integer> dayCount = new ArrayList<>();

        for(int i=0; i< progresses.length; i++){
            int count = 0;
            for(int j=progresses[i]; j<100; j+=speeds[i]){
                count+= 1;
            }
            dayCount.add(count);
        }

        int standard = dayCount.get(0);
        int count = 1;
        for(int i=1; i< dayCount.size(); i++){
            if( standard < dayCount.get(i)){
                answerData.add(count);
                standard = dayCount.get(i);
                count = 1;
            }
            else{
                count ++;
            }

            if( i == dayCount.size()-1){
                answerData.add(count);
            }

        }
        System.out.println(answerData);
        answer = answerData.stream()
                .mapToInt(i ->i)
                .toArray();
        return answer;
    }
}