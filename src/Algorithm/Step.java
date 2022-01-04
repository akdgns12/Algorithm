package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//5086 ����� ���
/*
public class Step {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a==0 && b==0) break;
			
			if(b%a==0)
				System.out.println("factor");
			else if(a%b==0)
				System.out.println("multiple");
			else
				System.out.println("neither");
		}
	}

}
*/
// 1037 �� ���
/*
public class Step {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int max= 0;
		int min=0;
		
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
			if(i==0) {
				max = arr[0];
				min = arr[0];
			}
				if(max<arr[i]) 
				max = arr[i];
			
			 if(min>arr[i]) 
				min = arr[i];
			
		}	
		System.out.println(max*min);
	}
}*/

//11653 ���μ�����
/*
public class Step{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=2; i*i<=n; i++) {
			while(n%i==0) {
				System.out.println(i);
				n/=i;
			}
		}
		if(n>1) {
			System.out.println(n);
	}
}
}*/
// ���� 2748 �Ǻ���ġ ����
/*
public class Step{
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		long[] list = new long[n+1];
		list[0]=0;
		list[1]=1;
		
		for(int i=2; i<=list.length; i++) {
			list[i]=list[i-1]+list[i-2];
			
		}
		System.out.println(list[n]);
	}
}*/
// ���� ���ڿ� ���� ���� 11654 �ƽ�Ű �ڵ�
/*
public class Step{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ascii = sc.next();
		int result = ascii.charAt(0); // charAt() -> �ε��� ���� �ش��ϴ� n��°�� ���ڸ� ������ 
		
		System.out.println(result);
	}
}*/
// ���� 11654 �� �����ϰ� ó���ð� ���� ���
	//
/*
public class Step{
	public static void main(String[] args) throws Exception {
		int ascii = System.in.read();            //inputStream�� ����Ʈ ������ �����͸� �������� �� inputstream�� �Է� �޼ҵ��� read()�� 1 ����Ʈ ������ �о� ���δ�.��� byte�̻��� ���ڰ� �о����� 1byte ���� �о���̰� ������ ���ڴ� ��Ʈ������ �����ִ�.
		System.out.println(ascii);
	}
}*/
// System.in�� ����Ʈ��Ʈ���� InputStream Ÿ���̰� �� �Է¹�������δ� ���ڸ� �����ϰ� �ޱ� ����� InputStreamReader�� �����ָ鼭 ����Ʈ ���� �����͸�  ���� ������ ó���� �� �ֵ��� �����ش�.BufferReader�� ����� ����.
// BufferReader br = new BufferReader(new InputStreamReader(System.in)); -> BufferReader�� ���� ��ü ����, ����
// �������ڸ� ����Ʈ ���� [InputStream]�� ���ڸ� �Է¹޾� ����(character) [InputStreamReader]�� ó���� �� ����(buffer) [BufferedReader]�� ��Ƶξ��ٰ� ���� ������ �Ǹ� ���۸� ���鼭 �����͸� ������ ���̴�.

// ���� 11720�� ������ ��
/*
public class Step{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String inputs = sc.next();
		sc.close();
		
		int result = 0;
		for(int i=0; i<n; ++i) {
			result += inputs.charAt(i) -'0';
		}
		System.out.println(result);
		
	}
}*/
// ���� 10809�� ���ĺ� ã��
/*
public class Step{
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int[] arr = new int[26];
	
	for(int i=0; i<arr.length; i++) {
		arr[i] = -1;
	}
	
	String s = br.readLine();
	
	for(int i = 0; i<s.length(); i++) {
		char ch = s.charAt(i);
		
		if(arr[ch - 'a'] == -1) {
			arr[ch -'a'] = i;
		}
	}
	
	for(int val : arr) {
		System.out.println(val + " ");
	}
	}
}*/

// ���� 2675�� ���ڿ� �ݺ�
/*
public class Step{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		for(int i = 0; i< num; i++) {
			int cnt = sc.nextInt();
			String str = sc.nextLine();
			
			String result = "";
			for( int j = 0; j < str.length(); j++) {
				for( int k = 0; k< cnt; k++)
					result += str.charAt(j);
			}
			result = result.replaceAll(" ", ""); // " " -> "" �� ��ü replace�� ���� ���������� replaceall�� replace���� ó������ ���ϴ� ���ڿ��� ó���� ����.
			System.out.println(result);
		}
		sc.close();
	}
}*/

// ���� 1157�� �ܾ����
/*
public class Step{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().toUpperCase();
		
		int[] cnt = new int[26];
		int max = 0;
		char result = '?';
		
		for ( int i = 0; i < str.length(); i++) {
			cnt[str.charAt(i) - 65]++;         // 65 = A max���� �� ���� ���� ���ĺ��� �ִٸ� ������ ����
			if(max<cnt[str.charAt(i) - 65]) {
				max = cnt[str.charAt(i) - 65];
				result = str.charAt(i);
			}
			else if(max==cnt[str.charAt(i)-65]) {
				result = '?';
			}
		}
		System.out.println(result);
	}
}*/

// ���� 1152�� �ܾ��� ����
/*
public class Step{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().trim();       // split()�޼��� ��� �����ڸ޼��� ����� ���� �������� �и��ϸ� ����
		// trim() �޼��� ����� ���ڿ��� �� �� ���� ����
		
		if(str.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(str.split(" ").length);
		}	
	}
}*/

// ���� 2908 ���
/*
public class Step{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		sc.close();
		
		// Integer.parseInt -> String �� Int��
		A = Integer.parseInt(new StringBuilder().append(A).reverse().toString());  
		//Interger.parseInt�� ��ȣ���� �Է¹��� ���� 
		B = Integer.parseInt(new StringBuilder().append(B).reverse().toString()); // append�� ���� ���ڿ� ���ʿ� ���ڿ� �߰�
	}
	
}*/

//***** ������� ���� 5622�� ���̾�
/*
public class Step {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int cnt = 0;
		int k = s.length();
		
		
		for(int i=0; i<k; i++) {
			switch(s.charAt(i)) {
			case 'A' : case 'B' : case 'C' :
				cnt += 3;
				break;
				
			case 'D' : case 'E' : case 'F' :
				cnt += 4;
				break;
				
			case 'G' : case 'H' : case 'I' :
				cnt +=5;
				break;
			case 'J' : case 'K' : case 'L' :
				cnt +=6;
				break;
			case 'M' : case 'N' : case 'O' :
				cnt +=7;
				break;
			case 'P' : case 'Q' : case 'R' : case 'S' :
				cnt +=8;
				break;
			case 'T' : case 'U' : case 'V' :
				cnt +=9;
				break;
			case 'W' : case 'X' : case 'Y' : case 'Z' :
				cnt +=10;
				break;
			}
		}
		System.out.println(cnt);
		
	}
}*/

// ���� 2941�� ũ�ξ�Ƽ�� ���ĺ�
/*
public class Step{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int len = str.length();
		int count = 0;
 
		for (int i = 0; i < len; i++) {
 
			char ch = str.charAt(i);
 
			if(ch == 'c' && i < len - 1) {			// ���� ch �� c ���?
				//���� ch ���� ���ڰ� '=' �Ǵ� '-' �̶��?
				if(str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {		
					// i+1 ������ �ϳ��� �����̹Ƿ� ���� ���ڸ� �ǳ� �ٱ� ���� 1 ����
					i++;		
				}
				
			}
		    
			else if(ch == 'd' && i < len - 1) {
				if(str.charAt(i + 1) == '-') {	// d- �� ���
						i++;
					}
				else if(str.charAt(i + 1) == 'z' && i < len - 2) {
					
					if(str.charAt(i + 2) == '=') {	// dz= �� ���
						i += 2;
					}
				}
			}
		    
			else if((ch == 'l' || ch == 'n') && i < len - 1) {
				if(str.charAt(i + 1) == 'j') {	// lj �Ǵ� nj �� ���
					i++;
				} 
			}
		    
 
			else if((ch == 's' || ch == 'z') && i < len - 1) {
				if(str.charAt(i + 1) == '=') {	// s= �Ǵ�z= �� ���
					i++;
				}
			
		    }
		    
			count++;
 
		}
 
		System.out.println(count);
		

	}
}*/
//�ڵ�� ���� 1001
/*
public class Step{
	public static void main(String[] args) {
		System.out.println("Hello");
	}
}*/
//�ڵ�� ���� 1002
//public class Step{
//	public static void main(String[] args) {
//		System.out.println("Hello World");
//	}
//}
//�ڵ�� ���� 1003
//public class Step{
//	public static void main(String[] args) {
//		System.out.println("Hello\nWorld");
//	}
//}
//�ڵ�� ���� 1004
//public class Step{
//	public static void main(String[] args) {
//		System.out.println("'Hello'");
//	}
//}
//�ڵ�� ���� 1005
//public class Step{
//	public static void main(String[] args) {
//		System.out.println("\"Hello World\"");
//	}
//}
//�ڵ�� ���� 1006
//public class Step{
//	public static void main(String[] args) {
//		System.out.println("\"!@#$%^&()\"");
//	}
//}
//�ڵ�� ���� 1007
//public class Step{
//	public static void main(String[] args) {
//		System.out.println("\"C:\\Download\\hello.cpp\"");
//	}
//}
//�ڵ�� ���� 1008
//public class Step{
//	public static void main(String[] args) {
//		System.out.println("\u250C\u252C\u2510");
//		System.out.println("\u251C\u253C\u2524");
//		System.out.println("\u2514\u2534\u2518");
//}
//}
//�ڵ�� ���� 1009
public class Step{
	public static void main(String[] args) {
		
	}
}