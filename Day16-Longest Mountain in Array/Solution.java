class Solution {
    public int longestMountain(int[] a) {
       
        if(a.length < 3)
            return 0;
        
        
        boolean dec = false;
        int count = 1, n = a.length;
        int maxLen = 0;
        int st = 0, i = 0;
            
        while(st < n)
        {
            st = i;
            count = 1;
            dec = false;
            
            while( i < n-1 && a[i] < a[i+1] )
            {
                i++;
                count++;
            }
            while( i < n-1 && a[i] > a[i+1] && count != 1 )
            {
                i++;
                count++;
                dec = true;
            }
            
            if(dec)
                maxLen = Math.max( maxLen, count );
            
            if(st == i)
            {
                st++;
                i++;
            }
        }
        return maxLen > 2 ? maxLen : 0;
        
    }
}