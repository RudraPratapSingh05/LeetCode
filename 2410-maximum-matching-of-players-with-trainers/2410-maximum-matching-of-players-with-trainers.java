class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int p=0;
        for(int t=0;t<trainers.length;t++){
            if(p<players.length){
                if(trainers[t]>=players[p]){
                    p++;
                }}
        }
        return p;
    }
}