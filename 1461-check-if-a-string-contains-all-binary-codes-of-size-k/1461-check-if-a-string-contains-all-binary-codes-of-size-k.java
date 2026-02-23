class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length()<k) return false;
        int reqcount = 1<<k;
        Set<String> seen = new HashSet<>();
        for(int i=0;i<=s.length()-k;i++){
            String code = s.substring(i,i+k);
            seen.add(code);
            if(seen.size()==reqcount){
                return true;
            }
        }
        return false;
    }
}