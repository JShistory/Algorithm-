import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        Arrays.sort(plans, (a, b) -> a[1].compareTo(b[1]));
        Stack<Task> paused = new Stack<>();
        Task current = null;
        for(int i=0; i<plans.length; i++) {
            String name = plans[i][0];
            int startTime = convertTime(plans[i][1]);
            int playTime = Integer.valueOf(plans[i][2]);
            
            if(current != null) {
                int timeDiff = startTime - current.startTime;
                if(timeDiff >= current.playTime) {
                    int remainTime = timeDiff - current.playTime;
                    answer.add(current.name);
                    while(remainTime > 0 && !paused.isEmpty()) {
                        Task pausedTask = paused.pop();
                        if(pausedTask.playTime > remainTime) {
                            pausedTask.playTime -= remainTime;
                            paused.push(pausedTask);
                            break;
                        }
                        else if(pausedTask.playTime <= remainTime) {
                            remainTime -= pausedTask.playTime;
                            answer.add(pausedTask.name);
                            
                        }
                    }
                }
                else {
                    current.playTime -= timeDiff;
                    paused.push(current);
                }
            }
            
            current = new Task(name,startTime,playTime);
        }
        answer.add(current.name);
        while(!paused.isEmpty()) {
            answer.add(paused.pop().name);
        }
        return answer.toArray(new String[answer.size()]);
    }
    int convertTime(String strTime) {
        String[] splitTime = strTime.split(":");
        return Integer.valueOf(splitTime[0]) * 60 + Integer.valueOf(splitTime[1]);
    }
}

class Task {
    String name;
    int startTime;
    int playTime;
    
    Task(String name, int startTime, int playTime) {
        this.name = name;
        this.startTime = startTime;
        this.playTime = playTime;
    }
    
}