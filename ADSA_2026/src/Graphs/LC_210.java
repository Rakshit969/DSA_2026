package Graphs;
import java.util.*;

public class LC_210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjL=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            adjL.add(new ArrayList<>());
        }

        int[] indegree=new int[numCourses];

        for(int[] e:prerequisites){
            int u=e[0];
            int v=e[1];
            adjL.get(v).add(u);
            indegree[u]++;
        }

        Queue<Integer> q=new LinkedList<>();
        int[] ans = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                q.offer(i);
        }
        int idx =0;

        while(!q.isEmpty()){
            int node=q.poll();
            ans[idx++]=node;
            for(int adjnode:adjL.get(node)){
                indegree[adjnode]--;
                if(indegree[adjnode]==0)
                    q.offer(adjnode);
            }
        }
        if (idx != numCourses) return new int[0];

        return ans;
    }
}
