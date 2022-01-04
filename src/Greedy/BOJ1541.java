package Greedy;

import java.io.IOException;
import java.util.Scanner;
// �Ҿ���� ��ȣ
/* �ٽ��� �Է¹��� ���ڿ��� -�� �и�
 * �и��� ���ڿ��� ���ʴ�� ��ȸ�ϸ� +�� �и�
 * �и��� ���ڿ��� ����������� ��
 * ����� ù��° ���ڸ� �����س��� ����
 */
public class BOJ1541 {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		String temp = sc.nextLine();
		String[] str = temp.split("\\-");
		
		int answer = 0;
		for(int i=0; i<str.length; i++) {
			String[] subStr = str[i].split("\\+");
			
			int calc = 0;
			for(String item : subStr) {
				calc += Integer.parseInt(item);
			}	
			
			if(i==0) {
				answer += calc;
			}	else {
				answer -= calc;
			}
		}
		System.out.println(answer);
		sc.close();
	}
}

//���ڿ� �и� 2���� �޼ҵ�
/*
 * split[] �޼ҵ�
 * int sum = Integer.MAX_VALUE;
 * String[] subtraction = br.readLine().split("-");
 * 
 * for(int i = 0; i<subtraction.length; i++){
 * int temp = 0;
 * 
 * //�������� ���� ��ū�� �������� �и��Ͽ� �ش� ��ū���� ���Ѵ�.
 * String[] addition = subtraction[i].split("\\+");
 * 
 * //�������� ���� ��ū���� ��� ���Ѵ�.
 * for(int j=0; j<addition.length; j++){
 * temp+=Integer.parseInt(addition[j]);
 * }
 * 
 * 	//ù ��° ��ū�� ��� temp���� ù ��° ���� ��
 * if(sum==Integer.MAX_VALUE){
 * sum = temp;
 * }else{
 * sum-=temp;
 * }
 * }
 * 
 * StringTokenizer �޼ҵ�
 * int sum = Integer.MAX_VALUE; //�ʱ���� ���� Ȯ���� ���� ������ ����
 * StringTokenizer subtraction = new StringTokenizer(br.readLine(),"-");
 * 
 * while(subtraction.hasMoreTokens()){
 * int temp=0;
 * 	// �������� ���� ��ū�� �������� �и��Ͽ� �ش� ��ū���� ���Ѵ�.
 * StringTokenizer addition = new StringTokenizer(subtraction.nextToken(),"+");
 * 
 * while(addition.hasMoreTokens()){
 * temp+=Integer.parseInt(addition[j]);
 * }
 * 
 * 	//ù ��° ��ū�� ��� temp���� ù ��° ���� ��
 * if(sum==Integer.MAX_VALUE){
 * sum = temp;
 * }else{
 * sum-=temp;
 * }
 * }
 */
