package �����ڵ�;

import java.util.ArrayList;

// 1. �־����� numbers������ �� ���ڿ��� ���� �� �ִ� ��� ���ڸ� ���ϴ� ����
// 2. ������� �� ���ڰ� �Ҽ����� �Ǻ��ϴ� ����
public class �Ҽ�ã�� {
	static int answer = 0;
	static ArrayList<Integer> arr = new ArrayList<>();
	static boolean[] visited = new boolean[7];
	
	public int solution(String numbers) {
		String temp = ""; // numbers�� �� ���� �ٿ����� ����
		
		for(int i=0; i<numbers.length(); i++) {
			rec(numbers, temp, i);
		}
		
		for(int x :arr) {
			isPrime(x);
		}
		return answer;
	}
	
	public static void rec(String numbers, String temp, int len) {
		if(temp.length() == len) {
			if(!arr.contains(Integer.parseInt(temp)))
				arr.add(Integer.parseInt(temp));
			
			return;
		}
		
		for(int i=0; i<numbers.length(); i++) {
			if(visited[i]) continue;
				temp += numbers.charAt(i);
				visited[i] = true;
				rec(numbers, temp, len);
				visited[i] = false;
				temp = temp.substring(0,temp.length()-1);
			
			}
		}
	
	public static void isPrime(int num) {
		if(num == 0) return;
		if(num == 1) return;
		
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num % i == 0) return;
		}
		
		answer++;
	}
	}

