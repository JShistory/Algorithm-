class Solution {
       public String solution(int n, int t, int m, int p){
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t*m; i++){
            String temp = Integer.toString(i,n);
            sb1.append(temp);
        }

        for(int i = p-1; i<m*t; i+=m){
            sb.append(sb1.charAt(i));
        }
        return sb.toString().toUpperCase();
    }
}
