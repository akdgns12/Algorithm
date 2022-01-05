package 매일코딩;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
//
public class 단어정렬 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// 단어들을 저장할 배열
		String[] arr = new String[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextLine();
		}
		
		sc.nextLine(); // 개행 버림
		//compare 메소드 리턴 타입 3가지
		/*
		 * -양의 정수
		 * -0
		 * -음의 정수양의 정수일 경우 위치 바꾸고,
		 * -0이나 음의정수일 경우 그대로
		 */
		Arrays.sort(arr, new Comparator<String>() {
			public int compare(String s1, String s2) {
				//단어 길이가 같을 경우
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2); // 사전 순 정렬
				}
				//그 외의 경우
				else {
					return s1.length() - s2.length(); // ex) s1의 길이가 길다면 리턴값 양수 -> s1, s2위치 바꾼다
				}
			}
		});
		
		System.out.println(arr[0]);
		
		for(int i=1; i< N; i++) {
			// 중복되지 않는 단어만 출력
			if(!arr[i].equals(arr[i-1])) {
				System.out.println(arr[i]);
			}
		}
	}

}
