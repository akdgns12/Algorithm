package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class 수강신청 {
	// 1. 클릭 2번이상 한 학생 대기목록에서 삭제
	// 2. 맨 앞에서부터 최대 수강 가능인원 선정
	// 3. 최종적으로 수강신청에 성공한 인원 출력
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken()); // 과목의 수강 인원
		int L = Integer.parseInt(st.nextToken()); // 학생들이 버튼 클륵한 순서를 기록한 대기목록의 길이
		LinkedHashSet<String> set = new LinkedHashSet<>();
		
		for(int i=0; i<L; i++) {
			String number = br.readLine();
			if(set.contains(number)) set.remove(number);
			set.add(number);
		}
		
		Iterator<String> it = set.iterator();
		int cnt = 0;
		while(it.hasNext() && cnt < K) {
			System.out.println(it.next());
			cnt++;
		}		
	}

}
