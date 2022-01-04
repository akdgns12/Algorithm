package 매일코딩;

public class 쿼드압축후개수세기 {
	// 프로그래머스 lv2 / 쿼드압축 후 개수세기 / dfs
	public class Solution {
	    static int zero; // 각 개수 카운트
	    static int one;
	    static int[][] map; //arr 참조변수
	    
		public int[] solution(int[][] arr) {
			int[] answer = {};
	        int n = arr.length;
	        map = arr;
	        zero = 0;
	        one = 0;
	        check(0,0, n);
	        
	        answer = new int[2];
	        answer[0] = zero;
	        answer[1] = one;
	        
	        return answer;
	        }
	    
	    public void check(int x, int y, int k){
	        if(isPossible(x,y,k)){ //(x,y)에서 k범위까지가 같은값으로 이루어져 있다면
	            int val = map[x][y]; //그 값 가져오기
	            if(val==1) one++; // 맞는 변수 ++
	            else zero++;
	            return;
	        }
	        
	        //같은 값으로 이루어져 있지 않다면
	        int half = k/2; //범위 줄이기
	        //새 범위로 다시 호출
	        check(x, y, half);
	        check(x, y+half, half);
	        check(x+half, y, half);
	        check(x+half, y+half, half);
	    }
	    
	    public boolean isPossible(int x, int y, int k){
	        int val = map[x][y]; //배열을 체크할 기준 값
	        for(int i=x; i<x+k; i++){
	            for(int j=y; j<y+k; j++){ 
	                if(map[i][j] != val) return false; //다른게 하나라도 있으면 F
	            }
	        }
	        return true; //모두 다 같은 값
	    }
	}
}
