package 신한은행유사문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 나이순정렬 {
	// BOJ 10814 나이순 정렬 / just 정렬
	// 나이 오름차순, 나이 같으면 먼저 가입한 순 정렬
	static int N; // 회원수
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken(); // 그대로 문자로 받아준다 정렬을 하기 위해 이방법이 편함
			arr[i][1] = st.nextToken();
		}
		
		// compare 메소드 양수,0,음수 반환
		// 양의 정수일 경우 두 객체의 위치 변경
		Arrays.sort(arr, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				// 여기서 숫자로 바꿔 비교해준다 
				// 결과적으로 이렇게 비교하면 오름차순 변경
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]); 
			}
		});
		
		for(int i=0; i<N; i++) {
			System.out.println(arr);
		}
		
	}
}
