package 매일코딩;

import java.util.ArrayList;

// 1. 주어지는 numbers변수의 각 문자열로 만들 수 있는 모든 숫자를 구하는 로직
// 2. 만들어진 각 숫자가 소수인지 판별하는 로직
public class 소수찾기 {
	static int answer = 0;
	static ArrayList<Integer> arr = new ArrayList<>();
	static boolean[] visited = new boolean[7];
	
	public int solution(String numbers) {
		String temp = ""; // numbers의 각 문자 붙여나갈 변수
		
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

