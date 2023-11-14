import java.util.*;
class Solution {
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                DFS(computers,i);
                answer++;
            }
        }
        return answer;
    }
    void DFS(int[][] computers,int node){
        visited[node] = true;
        
        for(int j=0; j<computers.length; j++){
            if(node != j && computers[node][j] == 1 && visited[j] == false){
                DFS(computers,j);
            }
        }
    }
}