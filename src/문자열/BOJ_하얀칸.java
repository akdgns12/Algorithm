package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_하얀칸 {
/*
 * 체스판 8*8크기
 * 검정칸과 하얀칸 번갈아가면서 색칠되어있음.
 * 가장 왼쪽 위칸은 (0,0) 하얀색.
 * 체스판 상태 주어졌을 때, 하얀 칸 위에 말이 몇개 있는지 출력하는 프로그램
 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//체스판
		char[][] map = new char[8][8];
		//하얀 칸 위의 말 개수
		int cnt = 0;
		
		String str = "";
		for(int i=0; i<8; i++) {
			str = br.readLine();
			for(int j=0; j<8; j++) {
				map[i][j] = str.charAt(j);
			
				//(i+j)를 2로 나눈 나머지가 0인 경우 -> 하얀 칸.
				if((i+j)%2==0 && map[i][j] == 'F') {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
