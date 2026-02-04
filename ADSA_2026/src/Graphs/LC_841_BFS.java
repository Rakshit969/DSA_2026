package Graphs;
import java.util.*;
public class LC_841_BFS {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] visited=new boolean[n];
        Queue<Integer> q=new LinkedList<>();

        visited[0]=true;
        q.offer(0);
        while(!q.isEmpty()){
            int x=q.poll();
            for(int z:rooms.get(x)){
                if(visited[z]==false){
                    visited[z]=true;
                    q.offer(z);
                }
            }
        }
        for(boolean bool:visited){
            if(!bool) return false;
        }
        return true;

    }
}
