class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> dq = new ArrayDeque<Integer>();

        for(int i = deck.length-1; i >= 0; i--){
            if(dq.isEmpty()){
                dq.add(deck[i]);
                continue;
            }

            int val = dq.pollLast();
            dq.addFirst(val);
            dq.addFirst(deck[i]);
        }

        return dq.stream().mapToInt(Integer::intValue).toArray();
    }
}