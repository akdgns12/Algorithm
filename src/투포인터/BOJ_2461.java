package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2461 {
	// 대표 선수 / 골2 / 투 포인터
	static int[] arr;
	static int N, M;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N*M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 한 반에서 대표를 뽑는 경우의 수 = mC1 = m, 반이 N개이기 때문에 M^N의 경우의 수
		/*
		 * 하지만, 이 문제는 결국 각 반 대표들 간 최대-최소 값을 구해야 하는 문제
		 * 각 반 대표의 능력치가 10,20,30,40,100인 경우 100-10=90이고 마찬가지로
		 * 10,11,12,13,100의 경우에도 90이다.
		 * 결론적으로 최대 or 최소 값만 변화시키면 된다
		 */
		/*
		 * 로직
		 * 1. 각 반을 능력치 순으로 내림차순으로 정렬한다
		 * 2. 각 반의 처음 값(가장 큰 값)을 하나씩 뽑는다
		 * 3. 그 값들 중 가장 큰 값과 작은 값을 비교하여 저장
		 * 4. 가장 큰 값은 제거하고, 그 반에서 해당 값의 다음 인덱스 값을 다시 찾는다
		 * 5. 하나의 반의 모든 사람을 탐색했다면 종료하고, 아니면 3번으로 돌아가서 비교
		 */
		Arrays.sort(arr);
		// 대표로 선발된 모든 학생들 능력치의 최댓값과 최솟값 차이가 최소가 되는경우의 값 return
		int start = arr[0];
		int end = arr[N-1];
		int max = 0;
		int min = 0;
		int ans = 0;
		
	
			
			while(end < arr.length) {
				max = arr[end];
				min = arr[start];
				ans = Math.min(ans, max-min);
				start++;
				end++;
				if(end == arr.length) break;
			}
		
		
		System.out.println(ans);
		
	}
}
