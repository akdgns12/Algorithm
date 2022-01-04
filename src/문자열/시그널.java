package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 시그널 {
	static char[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int leng = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		map = new char[5][leng/5];
		
		//5등분해서 배열에 넣는다
		for(int i=0; i<5; i++) {
			map[i] = str.substring(i*leng/5, leng/5*(i+1)).toCharArray();
		}
		
		//입력 끝
		
		ArrayList<Integer> list = new ArrayList<>();
		
		//맨 윗줄 만 검사
		
		for(int i=0; i<leng/5; i++) {
			//#이면 검사한다
			if(map[0][i] == '#') {
				
				if(i+2 <= leng/5) {
					if(map[0][i+1] == '#' && map[0][i+2] == '#') {
						
						list.add(choice(i)); //###인 경우 (2,3,5,6,7,8,9)중 찾아서 저장한다
						
						i = i + 3; //3칸을 먹기 때문에 i = i + 3
						
						if(i >= leng/5) break; //i+3이 범위를 벗어나면 다음 for문에서 에러가 나기때문에, 종료구문을 쓴다.
						
						continue; //아래 (1,4)들어가면 안되므로, continue;
					}
				}
				
				/*
				 * ###이 아닌 경우, 즉 1(#)이거나 4(#.#)일 때
				 * 1은 (3,i)가 '#' 이지만, 4는 '.'이다
				 * 
				 * .#. .#.#. <-- 이 부분의 앞은 같으므로 확인하지 않는다
				 * .#. .#.#.
				 * .#. .###.	
				 * .#. ...#. <-- 이 부분이 ('#' or '.'인지 확인)
				 * .#. ...#. <-- 이 부분을 확인해도 무방.
				 */
				if(map[3][i] == '#') list.add(1); //(3,i)가 #이면 1을
				else {//그렇지 않으면 4를 추가한다. 4역시 3칸을 차지하기 떄문에, i = i+3을 꼭 해준다.
					list.add(4);
					i = i+3;
					if(i >= leng/5) break; //i+3의 결과가 범위를 벗어나려면 에러가 나기 때문에, 종료구문을 써준다.
				}
			}
		}
		
		for(int n : list) {
			System.out.println(n);
		}
	}
	
	//###인 경우, (2,3,5,6,7,8,9)를 찾는 함수.
	private  static int choice(int x) {
		StringBuilder sb = new StringBuilder();
		//한 줄의 Strin으로 만든다.
		for(int i=0; i<5; i++) {
			for(int j=0; j<3; j++) {
				sb.append(map[i][j+x]);
			}
		}
		return check(sb.toString());
	}
	
	//찾는다.
	private static int check(String sb) {
		int result = 10;
		String[] num = new String[10];
		
		//1과 4는 필요없다.
		num[0] = "####.##.##.####";
		num[2] = "###..#####..###";
		num[3] = "###..####..####";
		num[5] = "####..###..####";
		num[6] = "####..####.####";
		num[7] = "###..#..#..#..#";
		num[8] = "####.#####.####";
		num[9] = "####.####..####";
		
		for(int i=0; i<num.length; i++) {
			if(sb.equals(num[i])) {
				result = i;
				break;
			}
		}
		return result;
	}

}
