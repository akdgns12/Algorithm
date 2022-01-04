package 매일코딩;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * - 처음 0분에는 모든 놀이기구의 개수만큼 아이들이 탑승한다. 즉, 0분에는 총 M명의 아이들이 탑승가능
 * - N분이 지났을 때는 각각의 놀이기구에 총 몇명의 아이들이 탑승했는지를  N / 놀이기구 운행 시간(분)으로 알 수 있다.
 *
 *	n분쨰에는 n % 놀이기구의 운행시간(분) = 0인 놀이기구에 새로운 아이가 탑승한다.
 *
 *	n분까지 놀이기구에 탑승한 아이들의 수를 구할 수 있다면, (n-1)분까지의 놀이기구에 탑승한 아이들의 수 역시 구할 수 있을 것이다.
 *	n분까지 놀이기구에 탑승한 아이들 수 - (n-1)분까지 놀이기구에 탑승한 아이들 수 = n분째에 놀이기구에 탑승한 아이들 수 
 *
 *	그리고 놀이기구 1번부터 차례대로 확인하면서 운행시간이 n분으로 나누어떨어지면 카운트를 하여서
 *	마지막으로 n분으로 나누어 나머지가 0이 되는 놀이기구의 번호를 확인하면 된다.
 */

public class BOJ_골드2_놀이공원 {
	static long N;
	static int M;
	static int[] time;
	static int answer;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		time = new int[M];
		answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		if(N <= M) {
			System.out.println(N);
			return;
		}
		else 
			Search();
		System.out.println(answer);
	
	}
	
	public static void Search() {
		long start = 1;
		long end = 2000000000 * 30L; // end값은 N*M으로 잡아야한다.
		
		while(start <= end) {
			long mid = (start + end) / 2;
			long next = sum(mid); // 현재 분 수에서 아이들의 총합
			if(N <= next) { //구하려는 번호보다 아이들의 총합이 더 크거나 같은 경우
				int ans = calc(sum(mid-1)-1, mid); //현재 (분 수의 -1분)의 아이들의 총합 +1이 현재 분수의 시작 분 수
				if(ans == -1) end = mid -1; //만약 N을 못찾았다면
				else {//찾았다면
					answer = ans + 1;
					break;
				}
			}
			else 
				start = mid + 1;
		}
	}
	
	public static long sum(long mid) { // 현재 분 수에서의 아이들의 총합
		long ans = 0;
		for(int i=0; i<M; i++) 
			ans += mid / time[i];// (분 수) / (놀이기구 운행시간)
		return ans+M; // 0분(+M)
	}
	
	public static int calc(long cur, long mid) { //cur : (mid-1)분의 아이들 총 수 + 1
		for(int i = 0; i<M; i++) {
			if(mid %time[i] == 0) { // 0으로 나누어 떨어지는 경우는아이들이 놀이기구를 탑승하는 경우
				if(cur == N) return i; // 찾고하 하는 아이가 타는 놀이기구 번호를 알게되면 return
				else cur++;
			}
		}
		return -1; // 못 찾은 경우
	}
}
