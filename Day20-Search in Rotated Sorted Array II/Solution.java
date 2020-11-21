class Solution {
    public boolean search(int[] nums, int target) {
        int si = 0, ei = nums.length-1;
        while(si <= ei)
        {
            int mid = (si+ei)>>1;
            
            if(nums[mid] == target || nums[si] == target || nums[ei] == target)
                return true;
            
            //left strictly sorted
            else if(nums[si] < nums[mid])
            {
                if( target >= nums[si] && target <= nums[mid] )
                    ei = mid-1;
                else
                    si = mid+1;
            }
            
            else if(nums[ei] > nums[mid])
            {
                if( target <= nums[ei] && target >= nums[mid] )
                    si = mid+1;
                else
                    ei = mid-1;
            }
            else
                si++;
        }
        return false;
    }
}