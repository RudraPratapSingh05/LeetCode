class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int minD = Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            int diff = arr[i+1] - arr[i];
            if(diff<minD){
                minD = diff;
            }
        }
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]-arr[i]==minD){
                result.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }
        return result;
    }
}