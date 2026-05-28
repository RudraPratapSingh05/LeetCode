class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> nums = new ArrayList<>();
        int left=0,top=0;
        int bottom=matrix.length-1,right=matrix[0].length-1;
        if(matrix==null||matrix.length==0) return nums;
        while(top<=bottom && left<=right){
            for(int col=left;col<=right;col++){
                nums.add(matrix[top][col]);
            }
            top++;
            for (int row = top; row <= bottom; row++) {
                nums.add(matrix[row][right]);
            }
            right--; 
            if(top<=bottom){
            for(int col=right;col>=left;col--){
                nums.add(matrix[bottom][col]);
            }
            bottom--;}
            if(left<=right){
            for(int row=bottom;row>=top;row--){
                nums.add(matrix[row][left]);
            }
            left++;}
        }
        return nums;
    }
}