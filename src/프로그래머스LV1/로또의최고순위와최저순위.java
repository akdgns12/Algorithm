class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        
        int matched = 0 ;
        int zeroCnt = 0;
        
        for(int l : lottos){
            if(l == 0)
                zeroCnt++;
            else{
                for(int j : win_nums){
                    if(l == j){
                        matched++;
                        break;
                    }
                }
            }
        }
        
        int min = matched;
        int max = zeroCnt + matched;
        
        int[] answer = {Math.min(7-max, 6), Math.min(7-min, 6)};
        return answer;
    }
}