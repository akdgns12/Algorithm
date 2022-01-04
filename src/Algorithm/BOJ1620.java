package Algorithm;
//나는야 포켓몬 마스터 이다솜

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 문자열탐색에서 Hashmap이 가장 효율이 좋다
// HashMap<String, Integer>로 문자열에 맞는 번호를 담고, String[] 로 번호(인덱스)에 맞는 문자열을 담아
// 상황에 맞게(입력 값이 문자인지 수자인지 구분해서)대응되는 값을 출력하면 끝!
public class BOJ1620 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 포켓몬의 개수 n
		int n = Integer.parseInt(st.nextToken());
		// 맞춰야 하는 문제의 개수 m
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> nameMap = new HashMap<String, Integer>();
		String[] nameArr = new String[n+1];
		StringBuilder sb = new StringBuilder();
		
		//입력
		for(int i=1; i<n+1; i++) {
			String name = br.readLine(); //포켓몬 이름들
			nameMap.put(name,i); // name에 맞는 번호 담고
			nameArr[i]=name;	// 번호에 맞는 name 담고
		}
		
		// while(variable-->0) 개념
		// 루프가 돌때마다 m값이 1씩 줄게되고 줄은 값이 0보다 클 경우에만 돈다.
		while(m-->0) {
			String findStr = br.readLine();
			if(isStringNumber(findStr)) { //숫자(인덱스)를 입력받은 경우
				int index = Integer.parseInt(findStr);
				sb.append(nameArr[index]);
			}
			else { // 문자를 입력받은 경우
				sb.append(nameMap.get(findStr));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	// 이 문자열이 숫자인지 아닌지 판단하는 함수
	public static boolean isStringNumber(String s) {
		try {
			Double.parseDouble(s);
			return true;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
}
