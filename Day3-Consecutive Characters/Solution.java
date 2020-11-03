class Solution {
    public int maxPower(String str) {
        if(str.length() == 0)
            return 0;
        
        int j = 0, n = str.length(), maxLen = 0;
        for(int i = 1; i < n; i++)
        {
            if(str.charAt(i) != str.charAt(j))
            {
                maxLen = Math.max(maxLen, i-j);
                j = i;
            }
                
        }
        maxLen = Math.max(maxLen, n-j);
        return maxLen;
    }
}