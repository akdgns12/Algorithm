package 프로그래머스level2;
/*
 * leo는 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억하지만, 전체 카펫의 
 * 크기는 기억하지 못함.
 */
// 갈색 격자의 수 brown, 노란색 격자의 수 yellow
// 카펫의 가로,세로 크기를 순서대로 배열에 담아 return 하도록 solution
public class 카펫 {
	public int[] solution(int brown, int yellow) {
		int[] answer = {};
		int x,y = 0; // 가로 세로
		int sum = (brown + 4) / 2;
		
		for( y = 3; y<=sum; y++) {
			x = sum - y;
			if(x<y) break;
			
			if((x-2) * (y-2) == yellow) {
				answer[0] = x;
				answer[1] = y;
				break;
			}
		}
		
		return answer;
	}
}
