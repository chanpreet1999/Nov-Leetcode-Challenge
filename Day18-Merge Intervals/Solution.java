class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();
        
        Arrays.sort( intervals, (a,b)->{
            if(a[0] == b[0])
                return a[1] - b[1];
            else
                return a[0] - b[0];
        } );
        
        int maxEnding = intervals[0][1];
        int st = intervals[0][0];
        for( int i = 1; i < intervals.length; i++ )
        {
            if(maxEnding >= intervals[i][0])
            {
                maxEnding = Math.max( maxEnding, intervals[i][1]);
                st = Math.min( st, intervals[i][0] );
            }
            else
            {
                ans.add(new int[]{st, maxEnding});
                maxEnding = intervals[i][1];
                st = intervals[i][0];
            }
                
        }
        ans.add(new int[]{st, maxEnding});
        return ans.toArray(new int[]);
    }
}