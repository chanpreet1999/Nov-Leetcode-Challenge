class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        
        int count  = 0;
        String nstr = String.valueOf(n);
        
        Arrays.sort( digits );
        
        for(int i = 1; i <= nstr.length()-1; i++ )
            count += (int)Math.pow( digits.length, i );
        
        int i = 0;
        
        while(i < nstr.length() )
        {
            int j = 0;
            while( j < digits.length && Integer.parseInt(digits[j]) < nstr.charAt(i) - '0' )
            {
                count +=(int)Math.pow( digits.length, nstr.length()-i-1 );
                j++;
            }
            if(j == digits.length || Integer.parseInt(digits[j]) > nstr.charAt(i) - '0')
                break;
            i++;
        }
        
        
        if(i == nstr.length())
            count++;
        
        return count;
    }
}