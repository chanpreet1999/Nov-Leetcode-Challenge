class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
   
        List<Integer> al = new ArrayList<>();
   
        if(n == 1)
        {
            al.add(0);
            return al;
        }
        
        ArrayList<Integer>[] graph = new ArrayList[n];
        int indegree[] = new int[n];
        
        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        
        for(int[] e : edges)
        {
            int u = e[0];
            int v = e[1];
        
            indegree[u]++;
            indegree[v]++;
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++)
        {
             if(indegree[i] == 1)
                q.add(i);
        }   
        
       while(n > 2)
       {
           int size = q.size();
           n -= size;
           
           while( size-- > 0 )
           {
               int cur = q.remove();
               for(int v : graph[cur])
               {
                   if(--indegree[v] == 1)
                       q.add(v);
               }
           }
       }
        
        while(!q.isEmpty())
            al.add( q.remove() );
        
        return al;
    }
}