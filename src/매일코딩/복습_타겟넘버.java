package �����ڵ�;

public class ����_Ÿ�ٳѹ� {
	   static int answer;
	    
	    public int solution(int[] numbers, int target) {
	        answer = 0;
	        dfs(numbers, target, 0, 0);
	        
	        return answer;
	    }
	    
	    public static void dfs(int[] numbers, int target, int idx, int sum){
	        if(idx == numbers.length){
	            if(sum == target)
	                answer++;
	            return;
	        }
	        
	        int add = sum + numbers[idx];
	        int minus = sum - numbers[idx];
	        
	        dfs(numbers, target, idx+1, add);
	        dfs(numbers, target, idx+1, minus);
	    }
	}
