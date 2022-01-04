package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문 {
	static int T;
	static char[] arr;
	static String str;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		// 0 : 회문, 1 : 유사회문, 2 : 일반 문자열
		for(int t = 0; t<T; t++) {
			str = br.readLine();
			arr = str.toCharArray();
			int left = 0;
			int right = str.length()-1;
			if(check(left, right)) { // 회문인지 검사
				System.out.println(0);
				continue;
			}
			if(checkS(left, right)) { // 유사회문 검사
				System.out.println(1);
			}else { // 위의 두개의 조건함수에 해당되지 않는다면 그 외 일반 문자열
				System.out.println(2);
			}
		}
}
	
	// 양 끝에서 비교해나가다가 다른 부분에서 둘 중 하나 삭제해보고 회문이 맞는지
	// 검사하면 되는 문제, 모든 곳을 삭제해볼 필요 없이 처음 달라지는 부분만! 삭제하면 된다.
	public static boolean check(int left, int right) {
		while(left <= right) {
			if(arr[left] != arr[right]) {// 다름
				return false;
			}
			left += 1;
			right -= 1;
		}
		return true;
	}
	// 유사회문 검사
	public static boolean checkS(int left, int right) {
		while(left <= right) {
			if(arr[left] != arr[right]) { // 다름
				boolean a = check(left+1, right);
				boolean b = check(left, right-1);
				if(a == false && b == false) {
					return false;
				}else return true;
			}
			left += 1;
			right -= 1;
		}
		return true;
	}
}
