class Solution {
    public boolean canReach(int[] a, int st) {
        return helper(a, st);
    }
    
    boolean helper( int a[], int st )
    {
        if( a[st] == 0 )
            return true;
        
        int temp = a[st];
        a[st] = -a[st];
        boolean res = false;
        
        if( temp + st  < a.length && a[ temp + st ] >= 0  )
            res = res || helper( a, st + temp );
            
        if( st - temp >= 0 && a[st - temp] >= 0 )
            res = res || helper( a, st - temp );
        
        return res;
    }
}