class Solution {
    public boolean isSameAfterReversals(int num) {
        String orignal = Integer.toString(num);
        String r1 = new StringBuilder(orignal).reverse().toString();
        int revint = Integer.parseInt(r1);
        String r2 = new StringBuilder(Integer.toString(revint)).reverse().toString();
        int finalint = Integer.parseInt(r2);
        return finalint==num;
    }
}