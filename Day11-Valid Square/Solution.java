class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Integer> hs = new HashSet<>();
      
        hs.add( calcDist( p1, p2 ) );
        hs.add( calcDist( p2, p3 ) );
        hs.add( calcDist( p3, p4 ) );
        hs.add( calcDist( p1, p4 ) );
        
        hs.add( calcDist( p1, p3 ) );
        hs.add( calcDist( p2, p4 ) );
        
        return (!hs.contains(0) & hs.size() == 2 );
        
    }
    
    Integer calcDist( int p1[], int p2[] )
    {
        return  ( ( p2[0] - p1[0] )*( p2[0] - p1[0] ) + ( p2[1] - p1[1] )*( p2[1] - p1[1] ) );
        
    }
}