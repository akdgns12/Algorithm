package 완전탐색;

public class 카펫_level2 {
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		
		int area = brown + yellow;
		
		for(int i=1; i<=area; i++) {
			int row = i; //세로
			int col = area/row; //가로
			
			//카펫의 가로길이는 세로길이와 같거나, 세로 길이보다 길다
			if(row > col)
				continue;
			
			if((row-2)*(col-2) == yellow) {
				answer[0] = col;
				answer[1] = row;
				return answer;
			}
		}
		return answer;
	}
}
