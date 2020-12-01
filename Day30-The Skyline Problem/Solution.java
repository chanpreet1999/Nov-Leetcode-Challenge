class Solution {
    
    class Event implements Comparable<Event>{
        int x, height;
        boolean isClosing;
        Event(int x, int height, boolean isClosing) {
            this.x = x;
            this.height = height;
            this.isClosing = isClosing;
        }
        
        @Override
        public  int compareTo(Event o) {
            return x != o.x ? x - o.x : Boolean.compare(isClosing, o.isClosing);
        }
    }
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
        TreeMap<Integer, Integer> avalHeights = new TreeMap<>();
        List< List<Integer> > ans  = new ArrayList<>( buildings.length );
        int n = buildings.length;
        if(n == 0)
            return ans;
        
        Event events[] = new Event[ buildings.length*2 ];
        
        for(int i = 0; i < n; i++) {
            int[] building = buildings[i];
            
            events[2*i] = new Event( building[0], building[2], false );
            events[2*i + 1] = new Event( building[1], building[2], true );
        }
        
        Arrays.sort(events);
        int curHeight = 0;
        avalHeights.put( 0, 1 );
        for(int i = 0, j; i < n<<1; i = j)
        {
            for(j = i; j < 2*n && events[i].x == events[j].x; j++ )
            {
                Event event = events[j];
                if(event.isClosing)
                {
                    int counter = avalHeights.get( event.height );
                    if(counter == 1)
                    {
                        avalHeights.remove( event.height );
                    }
                    else
                    {
                        avalHeights.put( event.height, counter-1 );
                    }
                }
                else    
                {
                    Integer counter = avalHeights.get(event.height);
                    if(counter == null)
                    {
                        avalHeights.put( event.height, 1);
                    }
                    else
                    {
                        avalHeights.put( event.height, counter+1);
                    }
                }
            }
            
            int x = events[i].x;
            int height = avalHeights.lastKey();
            if(height != curHeight)
            {
                List<Integer> temp = new ArrayList<>();
                temp.add(x);
                temp.add(height);
                ans.add( temp );
                curHeight = height;
            }
        }
        return ans;
    }
}