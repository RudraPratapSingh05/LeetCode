class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> more = new ArrayList<>();

        for(int num:nums){
            if(num<pivot) less.add(num);
            else if(num==pivot) equal.add(num);
            else more.add(num);
        }
        int[] result = new int[nums.length];
        int i=0;
        for(int num:less) result[i++] = num;
        for(int num:equal) result[i++] = num;
        for(int num:more) result[i++] = num;
        return result;
    }
}