class Solution {
    public int calculate(String str) {
        
        Stack<Character> operator = new Stack<>();
        Stack<Integer> operand = new Stack<>();
        
        int i = 0;
        
        while(i < str.length())
        {
            char ch = str.charAt(i);
            if(ch == ' ')
            {
                i++;
                continue;
            }
                
            else if( ch >= '0' && ch <= '9' )
            {
                int val = 0;
                while( i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9' )
                {
                    val = val * 10 + (str.charAt(i) - '0');
                    i++;
                }
                operand.push(val);
            }
            else
            {
                while( !operator.isEmpty() && getPriority( ch ) <=  getPriority( operator.peek() ) )
                {
                    int val2 = operand.pop();
                    int val1 = operand.pop();
                    char op = operator.pop();
                    
                    operand.push( calc( val1, val2, op ) );
                }
                operator.push(ch);
                i++;
            }
        }
        
        while( !operator.isEmpty() )
        {
            int val2 = operand.pop();
            int val1 = operand.pop();
            char op = operator.pop();
            
            operand.push( calc( val1, val2, op ) );
        }
        
        return operand.size() == 0 ? 0 : operand.pop();
    }
    
    int getPriority( char ch ) {
        if(ch == '+' || ch == '-')
            return 1;
        else
            return 2;
    }
    
    int calc( int v1, int v2, char op )
    {
        switch(op)
        {
            case '+' : return v1 + v2;
            case '-' : return v1 - v2;
            case '*' : return v1 * v2;
            case '/' : return v1 / v2;
                
        }
        return -1;
    }
}