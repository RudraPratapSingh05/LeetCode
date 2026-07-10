class Solution {
    public String sortVowels(String s) {
        String vowelset = "aeiouAEIOU";
        List<Character> vowels = new ArrayList<>();
        for(char c:s.toCharArray()){
            if(vowelset.contains(String.valueOf(c))){
                vowels.add(c);
            }
        }
        Collections.sort(vowels);
        StringBuilder sb = new StringBuilder(s);
        int index = 0;
        for(int i=0;i<s.length();i++){
            if(vowelset.contains(String.valueOf(s.charAt(i)))){
                sb.setCharAt(i, vowels.get(index));
                index++;
            }else{
                sb.setCharAt(i, s.charAt(i));
            }
        }
        return sb.toString();
    }
}