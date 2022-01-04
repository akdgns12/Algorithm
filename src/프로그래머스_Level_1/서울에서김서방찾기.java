package 프로그래머스_Level_1;
/*
 * String 배열 seoul의 element 중 "Kim"의 위치를 x
 * "김서방은 x에 있다"는 String을 반환하는 함수 solution
 * seoul에 "Kim"은 오직 한번만 나타나며 잘못된 값이 입력되는 경우는 없다.
 */
public class 서울에서김서방찾기 {
	public String solution(String[] seoul) {
		String answer ="";
		String Kim = "Kim";
		
		
		for(int i=0; i<seoul.length; i++) {
			if(seoul[i].equals(Kim)) {
				answer =  "김서방은 " + i + "에 있다";
				break;
			}
		}
		
		return answer;
	}
}
