class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String codes[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        StringBuilder sb;
        Set<String> hs = new HashSet();
        
        for(String word : words) {
            
            sb = new StringBuilder();
            
            for(int i = 0; i < word.length(); i++)
                sb.append( codes[ word.charAt(i) - 'a' ] );
            
            hs.add( sb.toString() );
        }
        
        return hs.size();
    }
}