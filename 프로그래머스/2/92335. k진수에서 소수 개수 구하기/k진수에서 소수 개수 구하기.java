import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String[] data = convertJinsu(n,k).split("0");
        for(String str : data){
            if(str.equals("")){
                continue;
            }
            if(isPrime(Long.valueOf(str))){
                answer++;
            }
        }
        return answer;
    }
    
    String convertJinsu(int n, int jinsu){
        String data = "";
        while(n != 0){
            data = n%jinsu + data;
            n /=jinsu;
        }
        return data;
    }
    public boolean isPrime(long n){
        if(n<2) return false;
        
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}