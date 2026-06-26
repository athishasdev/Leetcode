class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String word : strs){
            char[] ch = word.toCharArray();
            Arrays.sort(ch);

            String s = new String(ch);

            map.computeIfAbsent(s,k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }
}