package ���ڿ�;

import java.io.IOException;
import java.util.Scanner;

public class �Ҿ������ȣ {
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		/*
		 * 1.-�� �������� �и��Ѵ�
		 * 2.1���� �и��ѰŸ� +�� �������� �и����ش�.
		 * 3. ó���� -�� �Ⱥپ� �����Ƿ� �����ְ� �� �� ���ʹ� �� ���ش�.
		 */
		String input = sc.nextLine();
		//split�� ���Խ� ǥ���� ������ ������ +,- �տ� \\�� ������Ѵ�
		int result = 0;
		String[] minusArr = input.split("\\-"); 
		for(int i=0; i<minusArr.length; i++) {
			String[] plusArr = minusArr[i].split("\\+");
			for(int j=0; j<plusArr.length; j++) {
				if(i==0) {
					result += Integer.parseInt(plusArr[j]);
				}else {
					result -= Integer.parseInt(plusArr[j]);
				}
			}
		}
		System.out.println(result);
	}	
}