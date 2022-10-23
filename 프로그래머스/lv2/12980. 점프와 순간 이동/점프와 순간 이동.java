import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = n;
        int battery = 0;
        while(ans != 0){
            if(ans % 2 == 0){
                ans /=2;
            }
            else{
                ans -=1;
                battery += 1;
            }
        }

        return battery;
    }
}