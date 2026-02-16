class Solution {
    public int removeDuplicates(int[] nums) {
        LinkedHashSet<Integer> s = new LinkedHashSet<>();
        for(int i =0;i<nums.length;i++){
            s.add(nums[i]);
        }
        int k=0;
        for(int uv:s){
            nums[k]=uv;
            k++;
        }
        return k;
    }
}