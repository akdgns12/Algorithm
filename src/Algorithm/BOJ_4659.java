package Algorithm;


// ���ڿ� + ���ǹ� ����
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

	// StringTokenizer st = new StringTokenizer(br.readLine());
	// StringTokenizer token�� �Է¹޴� ���(���ٿ� ������ �����ڷ� �������ڵ��� �ִ� ���)
	// ���پ� �о ��ūȭ��.
// ��й�ȣ �����ϱ�
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
			// 1. ���� ���� �ϳ��� �ݵ�� ����
			if(candidate.contains("a") || candidate.contains("e") || candidate.contains("i") || candidate.contains("o") || candidate.contains("u")) {
				// 2. divide �޼ҵ带 ���� 2. ���ӵ� 3���� ���� ���� �Ÿ���
				if(divide(candidate)) {
					// 3. checkDouble �޼ҵ带 ���� �������� �ι����� ��� �Ÿ���. ee�� oo ����
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
			bw.newLine(); // �ٹٲ�
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
		// ���ӵǴ� ����, ���ӵǴ� ���� �Ÿ��� �޼ҵ�
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
		
		// �α��� �̻� ���� �Ǵ� �� �Ÿ��� �޼ҵ�
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
