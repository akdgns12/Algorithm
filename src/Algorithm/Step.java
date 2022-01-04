package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//5086 배수와 약수
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
// 1037 번 약수
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

//11653 소인수분해
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
// 문제 2748 피보나치 수열
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
// 문제 문자열 구현 문제 11654 아스키 코드
/*
public class Step{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ascii = sc.next();
		int result = ascii.charAt(0); // charAt() -> 인덱스 안의 해당하는 n번째의 문자를 추출함 
		
		System.out.println(result);
	}
}*/
// 문제 11654 더 간단하고 처리시간 빠른 방법
	//
/*
public class Step{
	public static void main(String[] args) throws Exception {
		int ascii = System.in.read();            //inputStream은 바이트 단위로 데이터를 내보내며 이 inputstream의 입력 메소드인 read()는 1 바이트 단위로 읽어 들인다.고로 byte이상의 문자가 읽어지면 1byte 값만 읽어들이고 나머지 문자는 스트림에만 남아있다.
		System.out.println(ascii);
	}
}*/
// System.in은 바이트스트림인 InputStream 타입이고 이 입력방법만으로는 문자를 온전하게 받기 힘드니 InputStreamReader로 감싸주면서 바이트 단위 데이터를  문자 단위로 처리할 수 있도록 도와준다.BufferReader도 비슷한 원리.
// BufferReader br = new BufferReader(new InputStreamReader(System.in)); -> BufferReader의 흔한 객체 생성, 선언
// 정리하자면 바이트 단위 [InputStream]로 문자를 입력받아 문자(character) [InputStreamReader]로 처리한 뒤 버퍼(buffer) [BufferedReader]에 담아두었다가 일정 조건이 되면 버퍼를 비우면서 데이터를 보내는 것이다.

// 문제 11720번 숫자의 합
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
// 문제 10809번 알파벳 찾기
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

// 문제 2675번 문자열 반복
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
			result = result.replaceAll(" ", ""); // " " -> "" 로 교체 replace와 성능 동일하지만 replaceall은 replace에서 처리하지 못하는 문자열도 처리가 가능.
			System.out.println(result);
		}
		sc.close();
	}
}*/

// 문제 1157번 단어공부
/*
public class Step{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().toUpperCase();
		
		int[] cnt = new int[26];
		int max = 0;
		char result = '?';
		
		for ( int i = 0; i < str.length(); i++) {
			cnt[str.charAt(i) - 65]++;         // 65 = A max보다 더 많이 나온 알파벳이 있다면 개수를 증가
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

// 문제 1152번 단어의 개수
/*
public class Step{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().trim();       // split()메서드 사용 구분자메서드 사용해 공백 기준으로 분리하면 편함
		// trim() 메서드 사용해 문자열의 앞 뒤 공백 제거
		
		if(str.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(str.split(" ").length);
		}	
	}
}*/

// 문제 2908 상수
/*
public class Step{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		sc.close();
		
		// Integer.parseInt -> String 을 Int로
		A = Integer.parseInt(new StringBuilder().append(A).reverse().toString());  
		//Interger.parseInt로 괄호안의 입력받은 숫자 
		B = Integer.parseInt(new StringBuilder().append(B).reverse().toString()); // append로 기존 문자열 뒤쪽에 문자열 추가
	}
	
}*/

//***** 개어려움 문제 5622번 다이얼
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

// 문제 2941번 크로아티아 알파벳
/*
public class Step{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int len = str.length();
		int count = 0;
 
		for (int i = 0; i < len; i++) {
 
			char ch = str.charAt(i);
 
			if(ch == 'c' && i < len - 1) {			// 만약 ch 가 c 라면?
				//만약 ch 다음 문자가 '=' 또는 '-' 이라면?
				if(str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {		
					// i+1 까지가 하나의 문자이므로 다음 문자를 건너 뛰기 위해 1 증가
					i++;		
				}
				
			}
		    
			else if(ch == 'd' && i < len - 1) {
				if(str.charAt(i + 1) == '-') {	// d- 일 경우
						i++;
					}
				else if(str.charAt(i + 1) == 'z' && i < len - 2) {
					
					if(str.charAt(i + 2) == '=') {	// dz= 일 경우
						i += 2;
					}
				}
			}
		    
			else if((ch == 'l' || ch == 'n') && i < len - 1) {
				if(str.charAt(i + 1) == 'j') {	// lj 또는 nj 일 경우
					i++;
				} 
			}
		    
 
			else if((ch == 's' || ch == 'z') && i < len - 1) {
				if(str.charAt(i + 1) == '=') {	// s= 또는z= 일 경우
					i++;
				}
			
		    }
		    
			count++;
 
		}
 
		System.out.println(count);
		

	}
}*/
//코드업 기초 1001
/*
public class Step{
	public static void main(String[] args) {
		System.out.println("Hello");
	}
}*/
//코드업 기초 1002
//public class Step{
//	public static void main(String[] args) {
//		System.out.println("Hello World");
//	}
//}
//코드업 기초 1003
//public class Step{
//	public static void main(String[] args) {
//		System.out.println("Hello\nWorld");
//	}
//}
//코드업 기초 1004
//public class Step{
//	public static void main(String[] args) {
//		System.out.println("'Hello'");
//	}
//}
//코드업 기초 1005
//public class Step{
//	public static void main(String[] args) {
//		System.out.println("\"Hello World\"");
//	}
//}
//코드업 기초 1006
//public class Step{
//	public static void main(String[] args) {
//		System.out.println("\"!@#$%^&()\"");
//	}
//}
//코드업 기초 1007
//public class Step{
//	public static void main(String[] args) {
//		System.out.println("\"C:\\Download\\hello.cpp\"");
//	}
//}
//코드업 기초 1008
//public class Step{
//	public static void main(String[] args) {
//		System.out.println("\u250C\u252C\u2510");
//		System.out.println("\u251C\u253C\u2524");
//		System.out.println("\u2514\u2534\u2518");
//}
//}
//코드업 기초 1009
public class Step{
	public static void main(String[] args) {
		
	}
}