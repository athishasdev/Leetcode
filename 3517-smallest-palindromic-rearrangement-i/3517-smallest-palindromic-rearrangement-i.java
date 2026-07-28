class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        Map<Character,Integer> map = new HashMap<>();

        for(char c : s.toCharArray())
            map.put(c,map.getOrDefault(c,0) + 1);

        int odd = 0;
        char oddc = 0;

        for(Map.Entry<Character,Integer> entity : map.entrySet()){
            if(entity.getValue() % 2 != 0){
                odd++;
                oddc = entity.getKey();
            }
        }

        if(odd > 1){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for(char c = 'a' ; c <= 'z' ; c++){
            if(map.containsKey(c)){
                int count = map.get(c);
                for(int i = 0; i < count / 2; i++){
                    sb.append(c);
                }
            }
        }
        
        String middle = (odd == 1) ? String.valueOf(oddc) : "";
        String last = new StringBuilder(sb).reverse().toString();

        return sb.toString() + middle + last;

    }
}