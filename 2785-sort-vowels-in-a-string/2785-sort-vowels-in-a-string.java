class Solution {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        List<Character> vowelset = new ArrayList<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        for(char c:s.toCharArray()){
            if(vowelset.contains(c)){
                vowels.add(c);
            }
        }
        Collections.sort(vowels);
        StringBuilder result = new StringBuilder();
        int vowelidx = 0;
        for(char c:s.toCharArray()){
            if(vowelset.contains(c)){
                result.append(vowels.get(vowelidx));
                vowelidx++;
            }else{
                result.append(c);
            }
        }
        return result.toString();
    }
}