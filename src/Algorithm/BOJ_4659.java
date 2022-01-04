package Algorithm;


// 문자열 + 조건문 문제
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

	// StringTokenizer st = new StringTokenizer(br.readLine());
	// StringTokenizer token을 입력받는 경우(한줄에 공백을 구분자로 여러문자들이 있는 경우)
	// 한줄씩 읽어서 토큰화함.
// 비밀번호 발음하기
public class BOJ_4659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		ArrayList<String> candidates = new ArrayList();
		String line = "";
		while(true) {
			line = br.readLine();
			if(line.equals("end"))break;
			candidates.add(line);
		}		
		
		for(String candidate : candidates) {
			boolean temp = false;
			// 1. 조건 모음 하나를 반드시 포함
			if(candidate.contains("a") || candidate.contains("e") || candidate.contains("i") || candidate.contains("o") || candidate.contains("u")) {
				// 2. divide 메소드를 통해 2. 연속된 3개의 모음 자음 거르고
				if(divide(candidate)) {
					// 3. checkDouble 메소드를 통해 같은글자 두번오는 경우 거른다. ee와 oo 제외
					if(checkDouble(candidate)) {
						temp = true;
					}
				}
			}
			if(temp) {
				bw.write("<" + candidate + "> is acceptable.");
			}else {
				bw.write("<" + candidate + "> is not acceptable.");
			}
			bw.newLine(); // 줄바꿈
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
		// 연속되는 모음, 연속되는 자음 거르는 메소드
		public static boolean divide(String candidate) {
			boolean temp = false;
			int continuousC = 0;
			int continuousV = 0;
			for(int i=0; i<candidate.length(); i++) {
				temp = false;
				switch(candidate.charAt(i)) {
				case 'a' :
				case 'e' :
				case 'i' :
				case 'o' :
				case 'u' : continuousC++; continuousV=0; break;
				default : continuousC =0; continuousV++;
				}
				if(continuousC ==3 || continuousV ==3) {
					break;
				}
			}
			if(continuousC<3 && continuousV <3) {
				temp = true;
			}
			return temp;
		}
		
		// 두글자 이상 연속 되는 것 거르는 메소드
		public static boolean checkDouble(String candidate) {
			boolean temp = false;
			for(int i=0; i<candidate.length(); i++) {
				temp = true;
				if(candidate.length()==1) {
					break;
				}else if(i < candidate.length() -1) {
					if(candidate.charAt(i) == candidate.charAt(i+1)) {
						if(candidate.charAt(i) != 'e' && candidate.charAt(i) != 'o') {
							temp = false;
						}
					}
				}
				if(!temp) {
					break;
				}
			}
			return temp;
		}
}
