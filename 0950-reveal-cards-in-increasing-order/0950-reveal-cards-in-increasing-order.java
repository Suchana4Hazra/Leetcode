class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        
        Arrays.sort(deck);
        
        Queue<Integer> qu = new LinkedList<>();
        
        for(int i=0;i<deck.length;i++) {
            
            qu.add(i);
        }
        int[] result = new int[deck.length];
        
        for(int card : deck) {
            
            int idx = qu.poll();
            result[idx] = card;
            if(!qu.isEmpty()) qu.add(qu.poll());
        }
        return result;
    }
}