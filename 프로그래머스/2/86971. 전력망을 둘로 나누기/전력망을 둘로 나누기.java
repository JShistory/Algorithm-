import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            graph[a].add(b);
            graph[b].add(a);
            
            //System.out.println(graph[a]);
            //System.out.println(graph[b]);
        }
        
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));
            
            int count = countNodes(graph, a, n);
            
            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
            
            graph[a].add(b);
            graph[b].add(a);
        }
        return answer;
    }
    
    int countNodes(List<Integer>[] graph, int start, int n) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start);
        visited[start] = true;
        int count = 1;
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            
            for(int next : graph[node]) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count++;
                }
            }
        }
        
        return count;
    }
}