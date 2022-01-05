package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//
public class Z {
	static int count = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int size = (int)Math.pow(2, N); // 한 변의 사이즈
		
		find(size, r, c);
		System.out.println(count);
	}
	/*
	 * 1. 처음에 재귀를 쓰지 않고 규칙을 찾아보려다가 정말 불가능하다는 것을 두 시간만에 깨닫고 재귀를 선택했다..
	 * 2. 재귀로 구현은 간단하다.
	 * 배열을 사분면으로 나누고, 입력받은 r, c가 몇 번째 사분면에 속하는지만 알면 된다.
	 * 3. 재귀를 호출할 때마다 현재 r,c의 위치에 따라 앞에 몇 번의 방문을 했는지 더하는 변수 count를 선언한다.
	 * 4. find 메소드를 정의하고, 매개변수로 한 변의 사이즈 size와 타겟 위치 인덱스인 r, c를 넘겨받는다.
	 * 4-1. r과 c가 1사분면에 속한다면, 앞에서 아무데도 방문하지 않았으므로 count를 그냥 두고,
	 * find메소드에 현재 size의 절반, 1사분면에서의 r,c 상대위치 r,c를 넘겨준다.
	 * 4-2. r과 c가 2사분면에 속한다면, 앞에서 1사분면을 방문해야하므로 count에 (size*size)/4를 더한다.
        (한 사분면의 크기: 전체 배열 크기의 4등분)
        find메소드에 현재 size의 절반, 2사분면에서의 r,c 상대위치 r, c-size/2를 넘겨준다.
        4-3. r과 c가 3사분면에 속한다면, 앞에서 1,2 사분면을 방문해야하므로 count에 (size*size)/4 * 2를 더한다.
        find메소드에 현재 size의 절반, 3사분면에서의 r,c 상대위치 r-size/2, c를 넘겨준다.
        4-4. r과 c가 4사분면에 속한다면, 앞에서 1,2,3 사분면을 방문해야하므로 count에 (size*size)/4 * 3를 더한다.
        find메소드에 현재 size의 절반, 4사분면에서의 r,c 상대위치 r-size/2, c-size/2를 넘겨준다.
        4-5. 위를 반복하다가 size가 1이 되면 재귀를 끝낸다.
		5. count 출력
	 */
	public static void find(int size, int r, int c) {
		if(size == 1) 
			return;
		
		if(r < size/2 && c < size/2) {
			find(size/2, r, c);
		}
		else if(r < size/2 && c >= size/2) {
			count += size * size / 4;
			find(size/2, r, c - size/2);
		}
		else if(r >= size/2 && c < size/2) {
			count += (size * size / 4) * 2;
			find(size/2, r - size/2, c);
		}
		else {
			count += (size * size / 4) * 3;
			find(size/2, r - size/2, c - size/2);
		}
	}
}
