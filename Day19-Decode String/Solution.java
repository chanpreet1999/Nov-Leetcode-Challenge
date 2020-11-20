class Solution {
    
    public String decodeString(String s) {
        
        Stack<Integer> countSt = new Stack<>();
        Stack<StringBuilder> strSt = new Stack<>();
        StringBuilder res = new StringBuilder();
        int i = 0;
        
        while( i < s.length() )
        {
            char ch = s.charAt(i);
            
            if( Character.isDigit( s.charAt(i) ) )
            {
                int num = 0;
                while( Character.isDigit( s.charAt(i) ) )
                {
                    num = num * 10 + s.charAt(i) -'0';
                    i++;
                }
                countSt.push( num );
            }
            
            else if( ch == '['  )
            {
                strSt.push( res );
                res = new StringBuilder();
                i++;
            }
            else if( ch == ']'  )
            {
                StringBuilder sb =  strSt.pop() ;
                int count = countSt.pop();
                while( count-- > 0 )
                {
                    sb.append( res );
                }
                res = sb;
                i++;
            }
            else
            {
                res.append(ch);
                i++;
            }
        }
        
        return res.toString();
        
    }
}