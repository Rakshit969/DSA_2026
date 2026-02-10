package Graphs;
import java.util.*;

public class topologicalSort {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here


        List<List<Integer>> adj = new ArrayList<>();

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[V];
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];

            adj.get(u).add(v);

            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i =0; i<V; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int nbr : adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr]==0){
                    q.offer(nbr);
                }
            }
        }
        return ans;
    }
}
