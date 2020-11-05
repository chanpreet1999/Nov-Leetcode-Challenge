class Solution {
    public int minCostToMoveChips(int[] position) {
        int o = 0, e = 0;
        for(int ele : position)
        {
            if( (ele & 1) == 0 )
                e++;
            else
                o++;
        }
        
        return Math.min(e, o);
    }
}