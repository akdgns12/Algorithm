package 매일코딩;
import java.util.*;
public class 위클리챌린지6주차 {
	
	class Solution {
	    public int[] solution(int[] weights, String[] head2head) {
	        int len = weights.length;
	        int[][] rank = new int[len][4];
	        for(int i = 0; i < len; i++) {
	            int w = weights[i], cnt = 0, win = 0, over = 0;
	            for(int j = 0; j < len; j++) {
	                char c = head2head[i].charAt(j);
	                cnt += c == 'N' ? 0 : 1;
	                win += c == 'W' ? 1 : 0;
	                over += c == 'W' && weights[i] < weights[j] ? 1 : 0;
	            }
	            rank[i][0] = i + 1;
	            rank[i][1] = (int)((double)win / cnt * 10000000);
	            rank[i][2] = over;
	            rank[i][3] = weights[i];
	        }
	        Arrays.sort(rank, (a, b) -> {
	            if(a[1] != b[1]) return b[1] - a[1];
	            if(a[2] != b[2]) return b[2] - a[2];
	            if(a[3] != b[3]) return b[3] - a[3];
	            return a[0] - b[0];
	        });
	        int[] answer = new int[len];
	        for(int i = 0; i < len; i++) answer[i] = (int)rank[i][0];
	        return answer;
	    }
	}
