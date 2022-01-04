package �����ڵ�;

public class ��������İ������� {
	// ���α׷��ӽ� lv2 / ������� �� �������� / dfs
	public class Solution {
	    static int zero; // �� ���� ī��Ʈ
	    static int one;
	    static int[][] map; //arr ��������
	    
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
	        if(isPossible(x,y,k)){ //(x,y)���� k���������� ���������� �̷���� �ִٸ�
	            int val = map[x][y]; //�� �� ��������
	            if(val==1) one++; // �´� ���� ++
	            else zero++;
	            return;
	        }
	        
	        //���� ������ �̷���� ���� �ʴٸ�
	        int half = k/2; //���� ���̱�
	        //�� ������ �ٽ� ȣ��
	        check(x, y, half);
	        check(x, y+half, half);
	        check(x+half, y, half);
	        check(x+half, y+half, half);
	    }
	    
	    public boolean isPossible(int x, int y, int k){
	        int val = map[x][y]; //�迭�� üũ�� ���� ��
	        for(int i=x; i<x+k; i++){
	            for(int j=y; j<y+k; j++){ 
	                if(map[i][j] != val) return false; //�ٸ��� �ϳ��� ������ F
	            }
	        }
	        return true; //��� �� ���� ��
	    }
	}
}
