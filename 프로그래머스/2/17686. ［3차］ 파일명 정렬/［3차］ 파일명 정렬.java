import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        String[][] file = new String[files.length][3];
        for(int i=0; i<files.length; i++){
            
            int startDigitIndex = -1;
            int endDigitIndex = -1;
            boolean firstNumber = false;
            int size = 0;
            for(int j=0; j<files[i].length(); j++){
                if(Character.isDigit(files[i].charAt(j))){
                    if(!firstNumber){
                        startDigitIndex = j;
                        firstNumber = true;
                    }
                    size ++;
                }else{
                    if(firstNumber) break;
                }
            }
            endDigitIndex = startDigitIndex + size-1;
            // System.out.println(startDigitIndex);
            // System.out.println(endDigitIndex);
            String head = files[i].substring(0,startDigitIndex);
            String number = files[i].substring(startDigitIndex, endDigitIndex+1);
            String tail = files[i].substring(endDigitIndex+1);
           
            file[i][0] = head;
            file[i][1] = number;
            file[i][2] = tail;
            
        }
        // Arrays.sort(file, (o1, o2) -> {
        //     if(o1[0].toLowerCase().compareTo(o2[0].toLowerCase(Locale.ROOT)) > 0){
        //         return 1;
        //     }else if(o1[0].toLowerCase().compareTo(o2[0].toLowerCase(Locale.ROOT)) < 0){
        //         return -1;
        //     }else{
        //         if(Integer.parseInt(o1[1]) > Integer.parseInt(o2[1])){
        //             return 1;
        //         }else if(Integer.parseInt(o1[1]) < Integer.parseInt(o2[1])){
        //             return -1;
        //         }else{
        //             return 0;
        //         }
        //     }
        // });
        Arrays.sort(file, (o1,o2) ->{
            if(o1[0].toLowerCase().compareTo(o2[0].toLowerCase()) > 0){
                return 1;
            }
            else if(o1[0].toLowerCase().compareTo(o2[0].toLowerCase()) < 0){
                return -1;
            }
            else{
                if(Integer.valueOf(o1[1]) > Integer.valueOf(o2[1])){
                    return 1;
                }
                else if(Integer.valueOf(o1[1]) < Integer.valueOf(o2[1])){
                    return -1;
                }
                else{
                    return 0;
                }
            }
            
        });

        for(int a=0; a<file.length; a++){
            answer[a] = file[a][0] + file[a][1] + file[a][2];
        }
        
        return answer;
    }
}