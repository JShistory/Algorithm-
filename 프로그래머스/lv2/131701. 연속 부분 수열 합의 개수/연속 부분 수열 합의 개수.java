import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int[] dataElements = new int[elements.length * 2];
        for(int i=0; i< elements.length; i++){
            dataElements[i]  = elements[i];
            dataElements[i+ elements.length] = elements[i];
        }
        System.out.println(Arrays.toString(dataElements));
        HashSet<Integer> data = new HashSet<>();
        for(int i=1; i<=elements.length; i++){
            for(int j=0; j<elements.length; j++){
                data.add(Arrays.stream(dataElements, j, j+i).sum());
            }
        }
        
        return data.size();
    }
}