class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A.length == 0 || A[0].length == 0)
            return A;
        
        A = revRows( A, A.length, A[0].length );
        return invert(A, A.length, A[0].length);
    }
    
    int[][] revRows( int[][] A, int rows, int cols )
    {
        for(int r = 0; r < rows; r++)
        {
            int i  = 0, j = cols-1;
            while(i < j)
            { 
                int temp = A[r][i];
                A[r][i] = A[r][j];
                A[r][j] = temp;
                
                i++;
                j--;
            }
        }
        return A;
    }
    
    int[][] invert( int[][] A, int rows, int cols )
    {
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                A[i][j] = A[i][j] == 0 ? 1 : 0;
            }
        }
        return A;
    }
    
}