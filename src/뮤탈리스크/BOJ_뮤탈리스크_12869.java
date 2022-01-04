package ��Ż����ũ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * DP ����
 */
// DP Top_Down
public class BOJ_��Ż����ũ_12869 {
	
	
	static int n; // scv�� ��
	static int[][][][] d; // ������� a,b,c�� ü�°� ������ ����Ƚ���� ���� ���� ���θ� ������ ����
	static int min = 70; // ������ �ƽø� ü���� 60�̶� 70���̸� �� ���̰� ����
	static int[][] p = {{9,3,1},{9,1,3},{3,9,1},{3,1,9},{1,3,9},{1,9,3}};
	static int go(int a, int b, int c, int cnt) {
		
		// a,b,c �� ������ ��� �迭 �ε��� ������ ���Ƿ� ��� 0���� ����
		if(a<0) a = 0;
		if(b<0) b = 0;
		if(c<0) c = 0;
		
		// �̹� �ּ� ����Ƚ���� �Ѿ���� ��� ���̻� �������� �ʴ´�.
		if(cnt >= min) {
			d[a][b][c][cnt] = 0;
			return 0;
		}
		
		// ü���� ��� �ٴ��̶�� cnt���� min�� ���� �� �޸����̼� �� �����Ѵ�.
		if( a <= 0 && b <=0 && c<=0) {
			min = cnt;
			return 1;
		}
		
		// �޸�� ���� �ִٸ� ��������
		if(d[a][b][c][cnt] != -1) {
			return d[a][b][c][cnt];
		}
		
		// ������ ���� ���Ͽ� ���� ��� �����Ѵ�
		for( int i=0; i<6; i++) {
			if(go(a-p[i][0], b-p[i][1], c-p[i][2], cnt+1) == 1) {
				d[a][b][c][cnt] = 1;
			}
		}
			// �������� ��..
			d[a][b][c][cnt] = 0;
			return 0;
		}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(br.readLine());
		int[] scv = new int[3];
		for(int i=0; i<3; i++) {
			scv[i] = Integer.parseInt(st.nextToken());
		}
		
		// d�� -1�� �ʱ�ȭ
		for(int i=0; i<=60; i++) {
			for(int j=0; j<=60; j++	) {
				for(int k=0; k<=60; k++) {
					Arrays.fill(d[i][j][k], -1);
				}
			}
		}
		
		go(scv[0],scv[1],scv[2], 0);
		System.out.println(min);
	}
}
/*
//DP - Top Down
public class Main{
// ������� a,b,c�� ü�°� ������ ����Ƚ���� ���� ���� ���θ� ������ ����
static int[][][][] d = new int[61][61][61][61];
// ������ �ƽø� ü���� 60�̶� 70���̸� �� ���̰� ����
static int min = 70;
// ������ ������ ����� ���� ����
static int[][] p = { {9,3,1},{9,1,3},{3,9,1},{3,1,9},{1,3,9},{1,9,3} };

static int go(int a, int b, int c, int cnt){
		
 // a,b,c�� ������ ��� �迭 �ε��� ������ ���Ƿ� ��� 0 ���� ����
 if(a < 0) a = 0;
 if(b < 0) b = 0;
 if(c < 0) c = 0;

 // �̹� �ּ� ����Ƚ���� �Ѿ���� ��� ���̻� �������� �ʴ´�
 if(cnt >= min){
   d[a][b][c][cnt] = 0;
   return 0;
 }
		
 // ü���� ��� �ٴ��̶�� cnt���� min�� ���� �� �޸������̼� �� �����Ѵ�
 if(a<=0 && b<=0 && c<=0){
   min = cnt;
   d[a][b][c][cnt] = 1;
   return 1;
 }
		
 // �޸�� ���� �ִٸ� ��������
 if(d[a][b][c][cnt] != -1){
   return d[a][b][c][cnt];
 }

 // ������ ���� ���Ͽ� ���� ��� �����Ѵ�
 for(int i = 0 ; i < 6 ; i++){
   if(go(a-p[i][0], b-p[i][1], c-p[i][2], cnt+1) == 1){
     d[a][b][c][cnt] = 1;
   }
 }

 // �������ΰ�..
 d[a][b][c][cnt] = 0;
 return 0;
}

public static void main(String []args) throws IOException{
 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 int n = Integer.parseInt(br.readLine());
 int[] scv = new int[3];
 StringTokenizer st = new StringTokenizer(br.readLine());
 for(int i = 0 ; i < n ; i++){
   scv[i] = Integer.parseInt(st.nextToken());
 }
		
 // d�� -1�� �ʱ�ȭ 
 for(int i = 0 ; i <= 60 ; i++ ){
   for(int j = 0 ; j <= 60 ; j++){
     for(int k = 0 ; k <= 60 ; k++){
       Arrays.fill(d[i][j][k], -1);
     }
   }
 }

 go(scv[0], scv[1], scv[2], 0);
 System.out.println(min);
}
}
*/