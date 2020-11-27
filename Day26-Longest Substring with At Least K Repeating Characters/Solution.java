class Solution {
    public int longestSubstring(String str, int k) {
        
        int n = str.length();
        
        if(k <= 1)
            return n;
        
        if( n == 0 || n < k )
            return 0;
        
        int pri[] = new int[26];
        int l = 0;
        
        for(char ch : str.toCharArray())
            pri[ ch - 'a' ]++;
        
        while(l < n && pri[ str.charAt(l) - 'a' ] >= k )
            l++;
        
        if( l >= n-1 )
            return l;
      
        int l1 = longestSubstring( str.substring( 0, l ), k );
        
        while(l  < n && pri[ str.charAt(l) - 'a' ] < k)
            l++;
        
        int l2 =  (l < n) ?  longestSubstring( str.substring( l ), k ) : 0;
        
        
        return Math.max( l1, l2);
    }
    
    
}