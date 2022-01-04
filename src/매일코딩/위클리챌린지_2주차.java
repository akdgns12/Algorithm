package 매일코딩;

public class 위클리챌린지_2주차 {

	public String solution(int[][] scores) {
		StringBuilder sb = new StringBuilder();
		String answer = "";
		for(int j=0; j<scores.length; j++) {
			int myScore = scores[j][j];
			double myTotalScore = 0;
			boolean isHighestScore = true;
			boolean isLowestScore = true;
			boolean isSameScore = false;
			for(int i=0; i<scores.length; i++) {
				myTotalScore += scores[i][j];
				if(myScore > scores[i][j]) {
					isHighestScore =false;
				}
				if(myScore < scores[i][j]) {
					isLowestScore = false;
				}
				if(i != j && myScore == scores[i][j]) {
					isSameScore = true;
				}
			}
			int studentCnt = scores.length;
			if(!isSameScore && (isHighestScore || isLowestScore)) {
				myTotalScore -= myScore;
				studentCnt--;
			}
			sb.append(scoreToRank(myTotalScore/studentCnt));
		}
		
		
		return answer;
	}   
	
	public static char scoreToRank(double score) {
		if(score >= (double)90)
			return 'A';
		if(score >= (double)80)
			return 'B';
		if(score >= (double)70)
			return 'C';
		if(score >= (double)60)
			return 'D';
		return 'F';
	}

}
