package 이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2470 {
	// 두 용액 / 골 5 / 이분탐색 비슷한 문제
	/*
	 *  1. 음수, 양수가 섞인 배열을 우선 오름차순 정렬
	 *   -> 맨 왼쪽은 가장 낮은 음수, 맨 오른쪽은 가장 큰 양수
	 *   가운데로 갈수록 점점 절댓값은 작아진다.
	 *  2. 그래서 양 끝부터 시작해서 탐색을 시작한다.
	 *  왼쪽 index를 i, 오른쪽 index를 j라고 할 때
	 *  i -> , <- j
	 *  로 진행하며 i가 j보다 커지기 전까지 while문을 만족하는 반복문을 짠다
	 *  3. 그래서 i의 원소와 j의 원소의 합의 절댓값을 저장하며
	 *  이전의 계산했던 절댓값보다 큰지 작은지 비교
	 *  
	 *  만약 이전의 절댓값보다 작은 경우
	 *  정답에 가까워지기 때문에
	 *  이 두 원소를 별도로 저장해두고, 위 절댓값을 이번에 계산해서 나온 절댓값으로 갱신
	 *  이를 while 조건을 벗어날 때까지 반복
	 */
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		binarySearch();
	}
	// 기준을 뭘로 잡아야 하는지 고민
	/*
	 * 배열 정렬 후 두 원소의 합 
	 * target = 0;
	 * 두 원소의 합이 타겟에 가장 가까운 것 찾아야 하므로
	 * 
	 */
	public static void binarySearch() {		
		int i = 0;
		int j = arr.length-1;
		
		int gap = Integer.MAX_VALUE;
		int ans1 = 0;
		int ans2 = 0;
		
		int sum;
		int temp;
		
		while(i < j) {
			sum = arr[i] + arr[j];
			temp = Math.abs(sum); // 두 원소의 합의 절댓값
			if(temp < gap) {
				gap = temp;
				ans1 = arr[i];
				ans2 = arr[j];
			}
			if(sum > 0) // 합이 양수라면 j를 줄여 합이 0에 가깝게
				j--;
			else  // 반대로 합이 음수라면 i를 늘려 합이 0에 가깝게
				i++;
				
		}
		System.out.println(ans1 + " " + ans2);
	}
}
