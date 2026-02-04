package Graphs;

public class LC_841 {
    //DFS
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms .size();
        boolean[] visited = new boolean[n];

        int source =0;

        dfs(source, visited, rooms);
        for(boolean t: visited){
            if(!t)
                return false;
        }
        return true;

    }
    public void dfs(int source, boolean[] visited, List<List<Integer>> rooms){

        visited[source]= true;

        for(int nbr: rooms.get(source)){
            if(!visited[nbr]){
                dfs(nbr, visited, rooms);

            }
        }

    }
}
