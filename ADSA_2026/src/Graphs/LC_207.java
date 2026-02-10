package Graphs;
import java.util.*;

public class LC_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

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
        ArrayList<Integer> ans=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                q.offer(i);
        }

        while(!q.isEmpty()){
            int node=q.poll();
            ans.add(node);
            for(int adjnode:adjL.get(node)){
                indegree[adjnode]--;
                if(indegree[adjnode]==0)
                    q.offer(adjnode);
            }
        }
        if(numCourses==ans.size())return true;
        return false;

    }
}
