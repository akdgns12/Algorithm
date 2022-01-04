package 매일코딩;

public class 라인3번_2021 {
	public int[] solution(int[] enter, int[] leave) {
		int len = enter.length;
		int[] answer = new int[len];
		int[] idx = new int[len+1];
		
		for(int i=0; i<len; i++) {
			idx[enter[i]] = i;  
		}
		
		for(int i=0; i<len; i++) {
			for(int j=0, late = enter[i]; j<len; j++) {
				int e = enter[i], l = leave[j];
				if(e == l)
					break;
				if(idx[l] > late || (late > idx[e] && idx[l] < late)) {
					answer[e-1]++;
					answer[l-1]++;
					late = Math.max(idx[l], late);
				}
			}
		}
		
		return answer;
	}
}
