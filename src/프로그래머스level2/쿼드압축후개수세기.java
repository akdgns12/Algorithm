package 프로그래머스level2;

/*
 * 재귀문제.
 * 해당 배열에 포함된 숫자가 모두 동일한지 체크.
 * 만약 아니라면, 네 부분으로 나눠준다. 맞다면 그 부분은 더 이상 탐색하지 않는다.
 * 1.arr의 크기가 1이라면 해당 arr의 요소가 0인지, 1인지 세어준다
 * 2. arr의 크기가 1이 아니라면, 해당 arr의 요소가 같은 요소인지 세어준다.
 * 2-1 같은 경우, 해당 부분에 해당하는 요소(0 or 1)의 카운트를 증가시켜준다.
 * 2-2 같지 않은 경우, 네 부분으로 나눠서 재귀함수를 돌려준다.
 */
public class 쿼드압축후개수세기 {
	static int[][] map;// arr참조변수
	static int zero, one;  // 각 개수 카운트
	public int[] solution(int[][] arr) {
		int[] answer = {};
		int n = arr.length;
		map = arr;
		zero = 0;
		one = 0;
		check(0,0,n);
		
		answer = new int[2];
		answer[0] = zero;
		answer[1] = one;
		return answer;
	}
	//시작점 (x,y)에서 k만큼 체크한다는 뜻
	public void check(int x, int y, int k) {
		if(isPossible(x, y, k)) {// (x,y)에서 k범위까지가 같은값으로 이루어져 있으면
			int val =map[x][y]; //그 값 가져오기
			if(val == 1) one++; //맞는 변수++
			else zero++;
			return;
		}
		
		//같은 값으로 이루어져 있다면
		int half = k/2; //범위 줄이기
		//새 범위로 다시 재귀호출
		check(x, y, half);
		check(x, y+half, half);
		check(x+half, y, half);
		check(x+half, y+half, half);
	}
	
	//파라미터로 받은 범위가 같은 값으로 이루어져 있는지 확인하는 메소드
	public boolean isPossible(int x, int y, int k) {
		int val = map[x][y]; //배열을 체크할 기준 값
		for(int i=x; i<x+k; i++) {
			for(int j=y; j<y+k; j++) {
				if(map[i][j] !=val)return false; //다른게 하나라도 있으면 F
			}
		}
		return true; //모두 다 같은 값
	}
}


