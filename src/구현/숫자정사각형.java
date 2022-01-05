package 구현;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//
/*
 * 먼저 주어진 N, M 중 더 큰값을 찾는다.

문제에서 3 x 5로 주어진 경우, 최대로 가능한 정사각형은 3 x 3이므로, 더 작은 3까지만 반복하면 되기 때문이다.

area = 4개의 꼭짓점이 정사각형일때, 넓이를 구하는 변수고

maxArea = 위 area와 비교해서 더 큰값을 저장하고, 최종적으로 출력할 변수다.

i+k 와 j+k가 각각 M, N 보다 작아야 배열의 범위 이내라고 할 수 있다.

4개의 꼭짓점이 같을 조건은 3개의 꼭짓점만 확인해주면 된다.

(0,0) , (0,1)

(1,0) , (1,1)

위와 같이 4개의 점이 있을때, A = B && A = C && A = D 이면 자동적으로 B = C = D 가 보장되기 때문이다.

또한 4개의 점을 찾기 위해 인덱스를 조작해야하는데, 행과 열, 행열에 각각 k를 더하면 일정한 4개의 꼭짓점이 된다.
 */
public class 숫자정사각형 {
	static int n,m;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int min = Math.min(n, m);
		int area = 0;
		int maxArea = 0;
		
		map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j) -'0';
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int k=0; k<min; k++) {
					if(i+k < n && j+k < m) { //배열 범위 이내
						//4개의 꼭짓점이 정사각형이 되는 조건
						if(map[i][j] == map[i][j+k] && map[i][j] == map[i+k][j] && map[i][j] == map[i+k][j+k]) {
							area = (k+1) * (k+1);
							maxArea = Math.max(maxArea, area);
						}
					}
				}
			}
		}
		System.out.println(maxArea);
		
	}
}
