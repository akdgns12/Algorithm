package 문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_단어정렬_comparator사용 {
	
	/*
	 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램
	 * 1.길이가 짧은 것 부터
	 * 2.길이가 같으면 사전 순으로
	 */
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		String[] str = new String[n];
		
		for(int i=0; i<n; i++) {
			str[i] = br.readLine();
		}
		
		Arrays.sort(str, new Comparator<String>() {
			@Override
			//compare() 는 리턴값이 양수면 두 객체의 자리를 바꿔주는 역할
				public int compare(String o1, String o2) { // 문자열 배열 행을 기준으로 정렬
				if(o1.length() == o2.length()) { // 두 문자열의 길이가 같은 경우는
					return o1.compareTo(o2); //사전순으로 정렬
				}else {//그 외에는 문자열들의 길이로 비교
					return o1.length() - o2.length();
					
				}
			}
		});
		
		for(int i=0; i<n; i++) {
			if(i+1 != n) {
				if(str[i].equals(str[i+1])) {//현재 인덱스와 다음 인덱스에 해당하는 요소가 같은지 확인.
					continue;
				}
			}
			bw.write(str[i] + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
